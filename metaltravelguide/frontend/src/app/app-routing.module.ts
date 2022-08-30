import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RegisterComponent } from "./core/security/components/register/register.component";
import { LoginComponent } from "./core/security/components/login/login.component";
import { HomeComponent } from "./core/components/home/home.component";
import { PrivacyComponent } from "./core/components/privacy/privacy.component";
import { ContactComponent } from "./core/components/contact/contact.component";

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'places', loadChildren: () => import("./features/places/places.module").then(m => m.PlacesModule) },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'privacy', component: PrivacyComponent },
  { path: 'contact', component: ContactComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
