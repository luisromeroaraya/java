import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from "@angular/forms";
import { Child } from "../../child/types/child";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Tutor } from "../../tutor/types/tutor";
import { Router } from "@angular/router";
import { ReservationService } from "../services/reservation.service";

@Component({
  selector: 'app-reservation-create',
  templateUrl: './reservation-create.component.html',
  styleUrls: ['./reservation-create.component.css']
})
export class ReservationCreateComponent implements OnInit {
  // variables
  private children: Child[] = [];
  private tutors: Tutor[] = [];

  reservationForm = new FormGroup({
    tutorId: new FormControl("", [Validators.required]),
    childId: new FormControl("", [Validators.required]),
    timeArrival: new FormControl(Date.now().toLocaleString(), [Validators.required]),
    timeDeparture: new FormControl(Date.now().toLocaleString(), [Validators.required])
  });

  // getters
  get Children(): Child[] {
    return this.children;
  }
  get Tutors(): Tutor[] {
    return this.tutors;
  }

  // constructor
  constructor(private _http: HttpClient, private _router: Router, private _reservationService: ReservationService) { }

  // methods
  ngOnInit(): void {
    let token = "";
    if (localStorage.getItem("token") != null)
    { // @ts-ignore
      token = localStorage.getItem("token");
    }
    const params = new HttpHeaders().append("Authorization", `Bearer ${token}`);
    this._http.get('https://demo-rest-springboot.herokuapp.com/tutors/all', {headers: params}).subscribe(data => {
      const response: any = data;
      response.forEach((e: Tutor) => {
        let tutor: Tutor = e;
        this.tutors.push(tutor);
      })
    });
    this._http.get('https://demo-rest-springboot.herokuapp.com/children/all', {headers: params}).subscribe(data => {
      const response: any = data;
      response.forEach((e: Child) => {
        let child: Child = e;
        this.children.push(child);
      })
    });
  }

  createReservation(): void {
    this._reservationService.add(this.reservationForm.value);
  }
}
