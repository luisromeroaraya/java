import { Injectable } from '@angular/core';
import {BehaviorSubject, Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class SessionService {
  // variables
  private token$: BehaviorSubject<string | null> = new BehaviorSubject<string | null>(null);

  // constructor
  constructor() {
    const token = localStorage.getItem("token");
    if (token) {
      this.token$.next(token);
    }
  }

  // getters
  get Token$(): Observable<string | null> {
    return this.token$.asObservable();
  }

  // methods
  login(token: string) {
    this.token$.next(token);
  }

  logout() {
    this.token$.next(null);
  }
}
