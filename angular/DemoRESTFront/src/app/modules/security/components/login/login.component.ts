import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {AuthService} from "../../services/auth.service";
import {SessionService} from "../../services/session.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  // variables
  username: string = "";
  password: string = "";
  token: string = "";

  constructor(private _auth: AuthService, private _session: SessionService, private _router: Router) { }

  ngOnInit(): void {
  }

  login(): void {
    this._auth.login(this.username, this.password).subscribe(token => {
      this.token = token["token"];
      localStorage.setItem("token", this.token);
      this._session.login(this.token);
      this._router.navigate(["/"]);
    });
  }

}
