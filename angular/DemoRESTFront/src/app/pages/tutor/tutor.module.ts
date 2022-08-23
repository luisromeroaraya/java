import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from "@angular/forms";

import { TutorRoutingModule } from './tutor-routing.module';
import { TutorComponent } from './tutor.component';
import { TutorListComponent } from "./components/tutor-list/tutor-list.component";
import { TutorDetailsComponent } from "./components/tutor-details/tutor-details.component";

@NgModule({
  declarations: [
    TutorComponent,
    TutorListComponent,
    TutorDetailsComponent,
  ],
  imports: [
    CommonModule,
    FormsModule,
    TutorRoutingModule
  ],
  exports: []
})
export class TutorModule { }
