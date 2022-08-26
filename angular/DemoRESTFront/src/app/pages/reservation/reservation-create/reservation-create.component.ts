import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from "@angular/forms";
import { IChild } from "../../child/types/IChild";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { ITutor } from "../../tutor/types/ITutor";
import { Router } from "@angular/router";
import { ReservationService } from "../services/reservation.service";
import { SessionService } from "../../../modules/security/services/session.service";

@Component({
  selector: 'app-reservation-create',
  templateUrl: './reservation-create.component.html',
  styleUrls: ['./reservation-create.component.css']
})
export class ReservationCreateComponent implements OnInit {
  // variables
  private children: IChild[] = [];
  private tutors: ITutor[] = [];

  reservationForm = new FormGroup({
    tutorId: new FormControl("", [Validators.required]),
    childId: new FormControl("", [Validators.required]),
    timeArrival: new FormControl(Date.now().toLocaleString(), [Validators.required]),
    timeDeparture: new FormControl(Date.now().toLocaleString(), [Validators.required])
  });

  // getters
  get Children(): IChild[] {
    return this.children;
  }
  get Tutors(): ITutor[] {
    return this.tutors;
  }

  // constructor
  constructor(private _session: SessionService, private _http: HttpClient, private _router: Router, private _reservationService: ReservationService) { }

  // methods
  ngOnInit(): void {
    let token;
    this._session.Token$.subscribe(data => token = data);
    const params = new HttpHeaders().append("Authorization", `Bearer ${token}`);
    this._http.get('https://demo-rest-springboot.herokuapp.com/tutors/all', {headers: params}).subscribe(data => {
      const response: any = data;
      response.forEach((e: ITutor) => {
        let tutor: ITutor = e;
        this.tutors.push(tutor);
      })
    });
    this._http.get('https://demo-rest-springboot.herokuapp.com/children/all', {headers: params}).subscribe(data => {
      const response: any = data;
      response.forEach((e: IChild) => {
        let child: IChild = e;
        this.children.push(child);
      })
    });
  }

  createReservation(): void {
    this._reservationService.create(this.reservationForm.value);
  }
}
