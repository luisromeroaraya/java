import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Observable, Subject } from "rxjs";
import { SessionService } from "../../../modules/security/services/session.service";
import {IReservation} from "../types/IReservation";
import {IChild} from "../../child/types/IChild";
import {ActivatedRoute} from "@angular/router";

@Injectable({
  providedIn: 'root'
})
export class ReservationService {
  // variables
  private refreshList$ = new Subject<boolean>();

  // getters
  get RefreshList$(): Observable<boolean> {
    return this.refreshList$.asObservable();
  }

  // constructor
  constructor(private _session: SessionService, private _http: HttpClient, private _route: ActivatedRoute) { }

  // methods
  getAll(): IReservation[] {
    let reservations: IReservation[] = [];
    let token;
    this._session.Token$.subscribe(data => token = data);
    const headers = new HttpHeaders().append("Authorization", `Bearer ${token}`);
    this._http.get<any[]>('https://demo-rest-springboot.herokuapp.com/reservations/all', {headers}).subscribe(data => {
      const response: any = data;
      response.forEach((e: IReservation) => {
        let reservation: IReservation = e;
        reservations.push(reservation);
      });
    });
    return reservations;
  }

  getOne(id: number): any {
    let reservation;
    let token;
    this._session.Token$.subscribe(data => token = data);
    const headers = new HttpHeaders().append("Authorization", `Bearer ${token}`);
    this._http.get<any>(`https://demo-rest-springboot.herokuapp.com/reservations/${id}`, {headers}).subscribe(data => {
      reservation = data;
    });
    return reservation;
  }

  create(reservation: any) {
    let token;
    this._session.Token$.subscribe(data => token = data);
    const headers = new HttpHeaders().append("Authorization", `Bearer ${token}`);
    this._http.post('https://demo-rest-springboot.herokuapp.com/reservations/create', reservation, {headers})
      .subscribe(data => {
        this.refreshList$.next(true);
      });
  }
}
