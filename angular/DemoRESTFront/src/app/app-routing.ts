import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from "./pages/home/home.component";
import { LoginComponent } from "./modules/security/components/login/login.component";

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'tutors', loadChildren: () => import("./pages/tutor/tutor.module").then(m => m.TutorModule) },
  { path: 'children', loadChildren: () => import("./pages/child/child.module").then(m => m.ChildModule) },
  { path: 'login', component: LoginComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
