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
  private child?: Child;

  // constructor
  constructor(private _http: HttpClient, private _route: ActivatedRoute) {
  }

  // getters
  get Child(): Child {
    return <Child>this.child;
  }

  // methods
  ngOnInit(): void {
    let token = "";
    if (localStorage.getItem("token") != null)
    { // @ts-ignore
      token = localStorage.getItem("token");
    }
    this._route.paramMap.subscribe(map => {
      const headers = new HttpHeaders().append("Authorization", `Bearer ${token}`);
      this._http.get<Child>(`https://demo-rest-springboot.herokuapp.com/children/${map.get("id")}`, {headers})
        .subscribe((child => this.child = child));
    });
  }
}
