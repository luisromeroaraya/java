import { Component, OnInit } from '@angular/core';
import {AuthService} from "../../services/auth.service";
import {SessionService} from "../../services/session.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  // variables
  username: string = "";
  password: string = "";
  repeatPassword: string = "";
  token: string = "";

  // constructor
  constructor(private _auth: AuthService, private _session: SessionService, private _router: Router) { }

  // methods
  ngOnInit(): void {
  }

  register() {
    if (this.password == this.repeatPassword) {
      this._auth.register(this.username, this.password).subscribe(_ => {
        this._auth.login(this.username, this.password).subscribe(token => {
          this.token = token["token"];
          localStorage.setItem("token", this.token);
          this._session.login(this.token);
          this._router.navigate(["/"]);
        });
      });

    }
  }

}
