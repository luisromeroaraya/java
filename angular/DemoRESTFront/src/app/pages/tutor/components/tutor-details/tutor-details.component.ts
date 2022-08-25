import { Component, OnInit } from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from "@angular/common/http";
import {ActivatedRoute} from "@angular/router";
import {Tutor} from "../../types/tutor";
import {Observable} from "rxjs";

@Component({
  selector: 'app-tutor-details',
  templateUrl: './tutor-details.component.html',
  styleUrls: ['./tutor-details.component.css']
})
export class TutorDetailsComponent implements OnInit {
  //variables
  private getOne$?: Observable<Tutor>;
  private _tutor?: Tutor;
  token: string = "";

  // constructor
  constructor(private _http: HttpClient, private _route: ActivatedRoute) {
  }

  // getters
  get Tutor(): Tutor {
    return <Tutor>this._tutor;
  }

  // methods
  ngOnInit(): void {
    if (localStorage.getItem("token") != null)
    { // @ts-ignore
      this.token = localStorage.getItem("token");
    }
    this._route.paramMap.subscribe(map => {
      const params = new HttpHeaders().append("Authorization", `Bearer ${this.token}`);
      this.getOne$ = this._http.get<Tutor>(`https://demo-rest-springboot.herokuapp.com/tutors/${map.get("id")}`, {headers: params});
      this.getOne$.subscribe((tutor => this._tutor = tutor));
    });
  }
}
