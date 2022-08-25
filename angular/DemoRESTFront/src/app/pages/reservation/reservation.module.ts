import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ReservationRoutingModule } from './reservation-routing.module';
import { ReservationComponent } from './reservation.component';
import { ReservationDetailsComponent } from './reservation-details/reservation-details.component';
import { ReservationListComponent } from './reservation-list/reservation-list.component';
import { ReservationCreateComponent } from './reservation-create/reservation-create.component';
import { FormsModule, ReactiveFormsModule } from "@angular/forms";


@NgModule({
  declarations: [
    ReservationComponent,
    ReservationDetailsComponent,
    ReservationListComponent,
    ReservationCreateComponent
  ],
  imports: [
    CommonModule,
    ReservationRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ]
})
export class ReservationModule { }
