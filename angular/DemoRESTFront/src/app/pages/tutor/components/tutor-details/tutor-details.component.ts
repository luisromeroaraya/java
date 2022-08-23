import { Component, OnInit } from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {ActivatedRoute} from "@angular/router";
import {Tutor} from "../../types/tutor";
import {Observable} from "rxjs";

@Component({
  selector: 'app-tutor-details',
  templateUrl: './tutor-details.component.html',
  styleUrls: ['./tutor-details.component.css']
})
export class TutorDetailsComponent implements OnInit {
  private getOne$?: Observable<Tutor>;
  private _tutor?: Tutor;

  // constructor
  constructor(private _http: HttpClient, private _route: ActivatedRoute) {
    this._route.paramMap.subscribe(map => {
      const params = new HttpParams().append("id", map.get("id")!);
      this.getOne$ = this._http.get<Tutor>(`http://localhost:8080/tutors/${map.get("id")}`);
      this.getOne$.subscribe((tutor => this._tutor = tutor));
    });
  }

  // getters


  get Tutor(): Tutor {
    return <Tutor>this._tutor;
  }

// methods
  ngOnInit(): void {
  }
}
