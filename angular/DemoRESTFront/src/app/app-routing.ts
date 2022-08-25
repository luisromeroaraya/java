import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from "./pages/home/home.component";
import { LoginComponent } from "./modules/security/components/login/login.component";
import { RegisterComponent } from "./modules/security/components/register/register.component";

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'tutors', loadChildren: () => import("./pages/tutor/tutor.module").then(m => m.TutorModule) },
  { path: 'children', loadChildren: () => import("./pages/child/child.module").then(m => m.ChildModule) },
  { path: 'reservations', loadChildren: () => import("./pages/reservation/reservation.module").then(m => m.ReservationModule) },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
