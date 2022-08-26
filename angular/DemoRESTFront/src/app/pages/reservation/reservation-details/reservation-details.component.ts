import { Component, OnInit } from '@angular/core';
import {ReservationService} from "../services/reservation.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-reservation-details',
  templateUrl: './reservation-details.component.html',
  styleUrls: ['./reservation-details.component.css']
})
export class ReservationDetailsComponent implements OnInit {
  // variables
  reservation: any;

  // constructor
  constructor(private _reservationService: ReservationService, private _route: ActivatedRoute) { }

  // methods
  ngOnInit(): void {
    this._route.paramMap.subscribe(map => {
      const id: any = map.get("id");
      this.reservation = this._reservationService.getOne(id);
    });
  }
}
