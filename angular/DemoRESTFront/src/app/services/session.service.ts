import { Injectable } from '@angular/core';
import {BehaviorSubject, Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class SessionService {
  private token$ = new BehaviorSubject<string | null>(null);

  constructor() {
    const token = localStorage.getItem("token");
    if (token) {
      this.token$.next(token);
    }
  }


  get Token$(): Observable<string | null> { return this.token$.asObservable(); }

  login(token: string) {
    this.token$.next(token);
  }
  logout() {
    this.token$.next(null);
  }
}
