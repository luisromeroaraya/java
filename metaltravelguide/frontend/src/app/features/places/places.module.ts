import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PlacesRoutingModule } from './places-routing.module';
import { PlacesListComponent } from './pages/places-list/places-list.component';
import { PlaceDetailsComponent } from './pages/place-details/place-details.component';
import { PlacesComponent } from './places.component';
import { HttpClientModule } from "@angular/common/http";
import { FormsModule } from "@angular/forms";
import { PlaceCardComponent } from './components/place-card/place-card.component';
import { SafePipe } from "../../core/pipes/safe.pipe";


@NgModule({
  declarations: [
    PlacesListComponent,
    PlaceDetailsComponent,
    PlacesComponent,
    PlaceCardComponent,
    SafePipe
  ],
  imports: [
    CommonModule,
    PlacesRoutingModule,
    HttpClientModule,
    FormsModule
  ]
})
export class PlacesModule { }
