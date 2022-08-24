import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ChildComponent } from "./child.component";
import { ChildDetailsComponent } from "./child-details/child-details.component";

const routes: Routes = [
  { path: "", component: ChildComponent, children: [
      { path: ":id", component: ChildDetailsComponent }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ChildRoutingModule { }
