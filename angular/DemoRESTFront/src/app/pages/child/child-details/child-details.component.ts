import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { ActivatedRoute } from "@angular/router";
import { IChild } from "../types/IChild";
import {SessionService} from "../../../modules/security/services/session.service";

@Component({
  selector: 'app-child-details',
  templateUrl: './child-details.component.html',
  styleUrls: ['./child-details.component.css']
})
export class ChildDetailsComponent implements OnInit {
  //variables
  private child?: IChild;

  // constructor
  constructor(private _session: SessionService, private _http: HttpClient, private _route: ActivatedRoute) {
  }

  // getters
  get Child(): IChild {
    return <IChild>this.child;
  }

  // methods
  ngOnInit(): void {
    let token: string | null;
    this._session.Token$.subscribe(data => token = data);
    this._route.paramMap.subscribe(map => {
      const headers = new HttpHeaders().append("Authorization", `Bearer ${token}`);
      this._http.get<IChild>(`https://demo-rest-springboot.herokuapp.com/children/${map.get("id")}`, {headers})
        .subscribe((child => this.child = child));
    });
  }
}
