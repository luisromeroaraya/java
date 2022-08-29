import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { IReservation } from "../types/IReservation";
import { Router } from "@angular/router";
import { ReservationService } from "../services/reservation.service";

@Component({
  selector: 'app-reservation-list',
  templateUrl: './reservation-list.component.html',
  styleUrls: ['./reservation-list.component.css']
})
export class ReservationListComponent implements OnInit {
  // variables
  @Output("create") createEvent = new EventEmitter();
  @Output("details") detailsEvent = new EventEmitter();
  private reservations: IReservation[] = [];

  // getters
  get Reservations(): IReservation[] {
    return this.reservations;
  }

  // constructor
  constructor(private _router: Router, private _reservationService: ReservationService) { }

  // methods
  ngOnInit(): void {
    this._reservationService.RefreshList$.subscribe(isRefresh => {
      if (isRefresh) {
        this.getAllAction()
      }
    });
    this.getAllAction();
  }

  getAllAction(): void {
    this.reservations = this._reservationService.getAll();
  }

  createReservation():void {
    this.createEvent.emit();
    this._router.navigateByUrl("/reservations/create");
  }

  seeDetails(id: number): void {
    this.detailsEvent.emit();
    this._router.navigateByUrl(`/reservations/${id}`);
  }
}
