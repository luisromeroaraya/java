import {Component, OnChanges, OnInit} from '@angular/core';
import { Router } from "@angular/router";
import {SessionService} from "../../modules/security/services/session.service";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit, OnChanges {
  // variables
  date = Date();
  disconnected: boolean = true;

  // constructor
  constructor(private router: Router, private _session: SessionService) {
    this._session.Token$.subscribe(token => this.disconnected = token == null);
  }

  // methods
  ngOnInit(): void {
    if (localStorage.getItem("token") != null)
      this.disconnected = false;
  }

  ngOnChanges(changes: any): void {
    console.log("CHANGES");
  }

  logout(): void {
    localStorage.clear();
    this._session.logout();
    this.router.navigate(["/"]);
  }
}
