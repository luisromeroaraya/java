import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Tutor } from "../../types/tutor";

@Component({
  selector: 'app-tutor-list',
  templateUrl: './tutor-list.component.html',
  styleUrls: ['./tutor-list.component.css']
})
export class TutorListComponent implements OnInit {
  // variables
  private tutors: Tutor[] = [];

  // constructor
  constructor(private _http: HttpClient) { }

  // getters
  get Tutors(): Tutor[] {
    return this.tutors;
  }

  // methods
  ngOnInit(): void {
    let token = "";
    if (localStorage.getItem("token") != null)
    { // @ts-ignore
      token = localStorage.getItem("token");
    }
    const headers = new HttpHeaders().append("Authorization", `Bearer ${token}`);
    this._http.get('https://demo-rest-springboot.herokuapp.com/tutors/all', {headers}).subscribe(data => {
      const response: any = data;
      response.forEach((e: Tutor) => {
        let tutor: Tutor = e;
        this.tutors.push(tutor);
      })
    });
  }
}
