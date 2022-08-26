import {Component, OnChanges, OnInit} from '@angular/core';
import { Router } from "@angular/router";
import { SessionService } from "../../modules/security/services/session.service";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit, OnChanges {
  // variables
  date = Date();

  // constructor
  constructor(private router: Router, private _session: SessionService) {}

  // getters
  get isConnected(): boolean {
    return this._session.isConnected();
  }

  get isAdmin(): boolean {
    return this._session.isAdmin();
  }

  // methods
  ngOnInit(): void {}

  ngOnChanges(changes: any): void {
    console.log("CHANGES");
  }

  logout(): void {
    localStorage.clear();
    this._session.logout();
    this.router.navigate(["/"]);
  }
}
