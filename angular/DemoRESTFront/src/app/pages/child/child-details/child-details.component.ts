import { Component, OnInit } from '@angular/core';
import { Observable } from "rxjs";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { ActivatedRoute } from "@angular/router";
import { Child } from "../types/child";

@Component({
  selector: 'app-child-details',
  templateUrl: './child-details.component.html',
  styleUrls: ['./child-details.component.css']
})
export class ChildDetailsComponent implements OnInit {
  //variables
  private getOne$?: Observable<Child>;
  private _child?: Child;
  token: string = "";

  // constructor
  constructor(private _http: HttpClient, private _route: ActivatedRoute) {
  }

  // getters
  get Child(): Child {
    return <Child>this._child;
  }

  // methods
  ngOnInit(): void {
    if (localStorage.getItem("token") != null)
    { // @ts-ignore
      this.token = localStorage.getItem("token");
    }
    console.log(this.token);
    this._route.paramMap.subscribe(map => {
      const params = new HttpHeaders().append("Authorization", `Bearer ${this.token}`);
      this.getOne$ = this._http.get<Child>(`http://localhost:8080/children/${map.get("id")}`, {headers: params});
      this.getOne$.subscribe((child => this._child = child));
    });
  }
}
