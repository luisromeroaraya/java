import { Component, OnInit } from '@angular/core';
import {ReservationService} from "../services/reservation.service";
import {ActivatedRoute} from "@angular/router";
import {IReservationDAO} from "../types/IReservationDAO";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {SessionService} from "../../../modules/security/services/session.service";
import { Observable } from 'rxjs';

@Component({
  selector: 'app-reservation-details',
  templateUrl: './reservation-details.component.html',
  styleUrls: ['./reservation-details.component.css']
})
export class ReservationDetailsComponent implements OnInit {
  // variables
  private reservation?: any;

  // getters


  get Reservation(): any {
    return this.reservation;
  }

// constructor
  constructor(private _reservationService: ReservationService, private _session: SessionService, private _http: HttpClient, private _route: ActivatedRoute) { }

  // methods
  ngOnInit(): void {
    this._route.paramMap.subscribe(map => {
      const id: any = map.get("id");
      this.reservation = this._reservationService.getOne(id);
      console.log(this.reservation);
    });
  }
}
