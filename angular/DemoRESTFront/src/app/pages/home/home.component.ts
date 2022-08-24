import {Component, OnChanges, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";
import {SessionService} from "../../services/session.service";

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
  constructor(private _http: HttpClient, private router: Router, private _session: SessionService) {
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

  login(): void {
    this._http.post<any>("http://localhost:8080/user/login", {"username": this.username, "password": this.password }).subscribe(token => {
      this.token = token["token"];
      localStorage.setItem("token", this.token);
      this._session.login(this.token);
      this.router.navigate(["/"]);
    });
  }

}
