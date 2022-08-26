import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { ITutor } from "../../types/ITutor";

@Component({
  selector: 'app-tutor-list',
  templateUrl: './tutor-list.component.html',
  styleUrls: ['./tutor-list.component.css']
})
export class TutorListComponent implements OnInit {
  // variables
  private tutors: ITutor[] = [];

  // constructor
  constructor(private _http: HttpClient) { }

  // getters
  get Tutors(): ITutor[] {
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
      response.forEach((e: ITutor) => {
        let tutor: ITutor = e;
        this.tutors.push(tutor);
      })
    });
  }
}
