import { Component, OnInit } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Tutor} from "../../types/tutor";

@Component({
  selector: 'app-tutor-list',
  templateUrl: './tutor-list.component.html',
  styleUrls: ['./tutor-list.component.css']
})
export class TutorListComponent implements OnInit {
  // variables
  private _tutors: Tutor[] = [];
  token: string = "";

  // constructor
  constructor(private _http: HttpClient) { }

  // getters
  get Tutors(): Tutor[] {
    return this._tutors;
  }

  // methods
  ngOnInit(): void {
    if (localStorage.getItem("token") != null)
      { // @ts-ignore
        this.token = localStorage.getItem("token");
      }
    const params = new HttpHeaders().append("Authorization", `Bearer ${this.token}`);
    this._http.get('https://demo-rest-springboot.herokuapp.com/tutors/all', {headers: params}).subscribe(data => {
      const response: any = data;
      response.forEach((e: Tutor) => {
        let tutor: Tutor = e;
        this._tutors.push(tutor);
      })
    });
  }
}
