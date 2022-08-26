import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UserComponent } from "./user.component";
import { UserCreateComponent } from "./user-create/user-create.component";
import { UserDetailsComponent } from "./user-details/user-details.component";

const routes: Routes = [
  { path: "", component: UserComponent, children: [
      { path: "create", component: UserCreateComponent },
      { path: ":id", component: UserDetailsComponent},
    ]
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UserRoutingModule { }
