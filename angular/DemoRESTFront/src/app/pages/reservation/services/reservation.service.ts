import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Observable, Subject } from "rxjs";
import { SessionService } from "../../../modules/security/services/session.service";

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
  constructor(private _http: HttpClient, private _session: SessionService) { }

  // methods

  getAll(): Observable<any[]> {
    this._session.Token$.subscribe(e => console.log(e));
    let token = "";
    if (localStorage.getItem("token") != null)
    { // @ts-ignore
      token = localStorage.getItem("token");
    }
    const headers = new HttpHeaders().append("Authorization", `Bearer ${token}`);
    return this._http.get<any[]>('https://demo-rest-springboot.herokuapp.com/reservations/all', {headers});
  }

  add(reservation: any) {
    let token = "";
    if (localStorage.getItem("token") != null)
    { // @ts-ignore
      token = localStorage.getItem("token");
    }
    const headers = new HttpHeaders().append("Authorization", `Bearer ${token}`);
    this._http.post('https://demo-rest-springboot.herokuapp.com/reservations/create', reservation, {headers})
      .subscribe(data => {
        this.refreshList$.next(true);
      });
  }
}
