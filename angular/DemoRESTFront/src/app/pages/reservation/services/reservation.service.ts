import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Observable, Subject } from "rxjs";
import { SessionService } from "../../../modules/security/services/session.service";
import {IReservation} from "../types/IReservation";
import {ActivatedRoute} from "@angular/router";
import {IReservationDAO} from "../types/IReservationDAO";

@Injectable({
  providedIn: 'root'
})
export class ReservationService {
  // variables
  private refreshList$ = new Subject<boolean>();
  reservation?: IReservationDAO;

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

  getOne(id: number): IReservationDAO {
    let token;
    this._session.Token$.subscribe(data => token = data);
    const headers = new HttpHeaders().append("Authorization", `Bearer ${token}`);
    this._http.get<IReservationDAO>(`https://demo-rest-springboot.herokuapp.com/reservations/${id}`, {headers}).subscribe(data => {
      this.reservation = data;
    });
    return <IReservationDAO>this.reservation;
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
