import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ReservationComponent } from "./reservation.component";
import { ReservationDetailsComponent } from "./reservation-details/reservation-details.component";
import { ReservationCreateComponent } from "./reservation-create/reservation-create.component";

const routes: Routes = [
  { path: "", component: ReservationComponent, children: [
      { path: "create", component: ReservationCreateComponent },
      { path: ":id", component: ReservationDetailsComponent},
    ]
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ReservationRoutingModule { }
