import { Component, OnInit } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Router } from "@angular/router";
import { SessionService } from "../../services/session.service";

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

  //constructor
  constructor(private _http: HttpClient, private router: Router, private _session: SessionService) { }

  // getters

  //methods
  ngOnInit(): void {
  }

  login(): void {
    this._http.post<any>("http://localhost:8080/user/login", {"username": this.username, "password": this.password }).subscribe(token => {
      this.token = token["token"];
      localStorage.setItem("token", this.token);
      this._session.login(this.token);
      this.router.navigate(["/"]);
    });
  }

}
