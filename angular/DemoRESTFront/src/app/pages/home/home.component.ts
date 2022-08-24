import {Component, OnChanges, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {SessionService} from "../../modules/security/services/session.service";
import {AuthService} from "../../modules/security/services/auth.service";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit, OnChanges{
  // variables
  username: string = "";
  password: string = "";
  token: string = "";
  disconnected: boolean = true;

  //constructor
  constructor(private _session: SessionService, private _auth: AuthService, private router: Router) {
    this._session.Token$.subscribe(token => this.disconnected = token == null);
  }

  // getters

  //methods
  ngOnInit(): void {
    if (localStorage.getItem("token") != null)
      this.disconnected = false;
  }

  ngOnChanges(changes: any) {
    console.log("CHANGES");
  }

  onSubmit(): void {
    this._auth.login(this.username, this.password).subscribe(token => {
      this.token = token["token"];
      localStorage.setItem("token", this.token);
      this._session.login(this.token);
      this.router.navigate(["/"]);
    });
  }

}
