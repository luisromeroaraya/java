import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import { Reservation } from "../types/reservation";
import { HttpClient } from "@angular/common/http";
import { Router } from "@angular/router";
import { ReservationService } from "../services/reservation.service";

@Component({
  selector: 'app-reservation-list',
  templateUrl: './reservation-list.component.html',
  styleUrls: ['./reservation-list.component.css']
})
export class ReservationListComponent implements OnInit {
  @Output("add") addEvent = new EventEmitter();

  // variables
  private reservations: Reservation[] = [];

  // getters
  get Reservations(): Reservation[] {
    return this.reservations;
  }

  // constructor
  constructor(private _http: HttpClient, private _router: Router, private _reservationService: ReservationService) { }

  // methods
  ngOnInit(): void {
    this._reservationService.RefreshList$.subscribe(isRefresh => {
      if (isRefresh) {
        this.getAllAction()
      }
    });
    this.getAllAction();
  }

  getAllAction() {
    this._reservationService.getAll().subscribe(data => {
      this.reservations = [];
      const response: any = data;
      response.forEach((e: Reservation) => {
        let reservation: Reservation = e;
        this.reservations.push(reservation);
      })
    })
  }

  addReservation() {
    this.addEvent.emit();
    this._router.navigateByUrl("/reservations/create");
  }
}
