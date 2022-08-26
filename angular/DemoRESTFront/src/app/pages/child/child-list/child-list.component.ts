import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { IChild } from "../types/IChild";

@Component({
  selector: 'app-child-list',
  templateUrl: './child-list.component.html',
  styleUrls: ['./child-list.component.css']
})
export class ChildListComponent implements OnInit {
  // variables
  private children: IChild[] = [];

  // constructor
  constructor(private _http: HttpClient) { }

  // getters
  get Children(): IChild[] {
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
      response.forEach((e: IChild) => {
        let child: IChild = e;
        this.children.push(child);
      })
    });
  }
}
