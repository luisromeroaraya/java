import { Component, OnInit } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Child} from "../types/child";

@Component({
  selector: 'app-child-list',
  templateUrl: './child-list.component.html',
  styleUrls: ['./child-list.component.css']
})
export class ChildListComponent implements OnInit {
// variables
  private _children: Child[] = [];
  token: string = "";

  // constructor
  constructor(private _http: HttpClient) { }

  // getters
  get Children(): Child[] {
    return this._children;
  }

  // methods
  ngOnInit(): void {
    if (localStorage.getItem("token") != null)
    { // @ts-ignore
      this.token = localStorage.getItem("token");
    }
    const params = new HttpHeaders().append("Authorization", `Bearer ${this.token}`);
    // this._http.get('https://demo-rest-springboot.herokuapp.com/tutors/all', {headers: params}).subscribe(data => console.log(data));
    this._http.get('http://localhost:8080/children/all', {headers: params}).subscribe(data => {
      const response: any = data;
      response.forEach((e: Child) => {
        let child: Child = e;
        this._children.push(child);
      })
    });
  }

}
