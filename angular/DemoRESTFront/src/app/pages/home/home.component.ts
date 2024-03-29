import { Component, OnChanges, OnInit } from '@angular/core';
import { Router } from "@angular/router";
import { SessionService } from "../../modules/security/services/session.service";
import { AuthService } from "../../modules/security/services/auth.service";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit, OnChanges{
  // variables
  username: string = "";
  password: string = "";

  // getters
  get isConnected(): boolean {
    return this._session.isConnected();
  }

  //constructor
  constructor(private _session: SessionService, private _auth: AuthService, private router: Router) {}

  //methods
  ngOnInit(): void {}

  ngOnChanges(changes: any) {
    console.log("CHANGES");
  }

  onSubmit(): void {
    this._auth.login(this.username, this.password).subscribe(data => {
      let token = data["token"];
      this._session.login(token);
      this.router.navigate(["/"]);
    });
  }
}
