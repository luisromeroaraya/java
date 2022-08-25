import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { ActivatedRoute } from "@angular/router";
import { Tutor } from "../../types/tutor";
import { Observable } from "rxjs";

@Component({
  selector: 'app-tutor-details',
  templateUrl: './tutor-details.component.html',
  styleUrls: ['./tutor-details.component.css']
})
export class TutorDetailsComponent implements OnInit {
  //variables
  private tutor?: Tutor;

  // constructor
  constructor(private _http: HttpClient, private _route: ActivatedRoute) {
  }

  // getters
  get Tutor(): Tutor {
    return <Tutor>this.tutor;
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
      this._http.get<Tutor>(`https://demo-rest-springboot.herokuapp.com/tutors/${map.get("id")}`, {headers})
        .subscribe((tutor => this.tutor = tutor));
    });
  }
}
