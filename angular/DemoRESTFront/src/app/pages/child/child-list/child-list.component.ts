import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Child } from "../types/child";

@Component({
  selector: 'app-child-list',
  templateUrl: './child-list.component.html',
  styleUrls: ['./child-list.component.css']
})
export class ChildListComponent implements OnInit {
  // variables
  private children: Child[] = [];

  // constructor
  constructor(private _http: HttpClient) { }

  // getters
  get Children(): Child[] {
    return this.children;
  }

  // methods
  ngOnInit(): void {
    let token = "";
    if (localStorage.getItem("token") != null)
    { // @ts-ignore
      token = localStorage.getItem("token");
    }
    const params = new HttpHeaders().append("Authorization", `Bearer ${token}`);
    this._http.get('https://demo-rest-springboot.herokuapp.com/children/all', {headers: params}).subscribe(data => {
      const response: any = data;
      response.forEach((e: Child) => {
        let child: Child = e;
        this.children.push(child);
      })
    });
  }
}
