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
  tutors?: any;

  // constructor
  constructor(private _http: HttpClient) { }

  // methods
  ngOnInit(): void {
    const params = new HttpHeaders().append("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyIiwicm9sZXMiOlsiUk9MRV9VU0VSIl0sImV4cCI6MTY2MjEwNzEzMn0.7wil4GDahiidJiw-fjju5fGZnxuY-GFYwHVoczVEL6uDgPCo-SycvxaZWirqvEacyZh_JU8u_DdN_BCNP0JOqA");
    // this._http.get('https://demo-rest-springboot.herokuapp.com/tutors/all', {headers: params}).subscribe(data => console.log(data));
    this._http.get('http://localhost:8080/tutors/all', {headers: params}).subscribe(data => this.tutors=data);
  }
}
