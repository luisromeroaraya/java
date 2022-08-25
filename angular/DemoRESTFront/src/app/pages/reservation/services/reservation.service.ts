import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Observable, Subject } from "rxjs";

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
  constructor(private _http: HttpClient) { }

  // methods

  getAll(): Observable<any[]> {
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
    this._http.post('https://demo-rest-springboot.herokuapp.com/reservations/add', reservation, {headers})
      .subscribe(data => {
        this.refreshList$.next(true);
      });
  }
}
