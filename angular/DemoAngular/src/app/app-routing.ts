import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from "./components/home/home.component";
import { AccountComponent } from "./components/account/account.component";
import { ContactComponent } from "./components/contact/contact.component";

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'products', loadChildren: () => import("./pages/product/product.module").then(m => m.ProductModule) }, // we load the ProductModule
  { path: 'account', component: AccountComponent },
  { path: 'contact', component: ContactComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
