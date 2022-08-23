import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TutorComponent } from "./tutor.component";
import { TutorDetailsComponent } from "./components/tutor-details/tutor-details.component";

const routes: Routes = [
  { path: "", component: TutorComponent, children: [
      { path: ":id", component: TutorDetailsComponent }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class TutorRoutingModule { }
