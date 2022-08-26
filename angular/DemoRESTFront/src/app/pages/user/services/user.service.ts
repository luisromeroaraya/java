import { Injectable } from '@angular/core';
import {IUser} from "../types/IUser";
import {Observable} from "rxjs";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {SessionService} from "../../../modules/security/services/session.service";

@Injectable({
  providedIn: 'root'
})
export class UserService {
  // variables

  // constructor
  constructor(private _session: SessionService, private _http: HttpClient) { }

  // getters

  // methods
  getAll(): IUser[] {
    let users: IUser[] = [];
    let token;
    this._session.Token$.subscribe(data => token = data);
    const headers = new HttpHeaders().append("Authorization", `Bearer ${token}`);
    this._http.get<any[]>('https://demo-rest-springboot.herokuapp.com/user/all', {headers}).subscribe(data => {
      const response: any = data;
      response.forEach((e: IUser) => {
        let user: IUser = e;
        users.push(user);
      });
    });
    return users;
  }
}
