import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { FormsModule } from "@angular/forms";
import { ProductsComponent } from './components/products/products.component';
import { AvailablePipe } from './pipes/available.pipe';
import { SortedPipe } from './pipes/sorted.pipe';
import { MaxPricePipe } from './pipes/max-price.pipe';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import { AppRoutingModule } from "./app-routing";
import { HomeComponent } from './components/home/home.component';
import { AccountComponent } from './components/account/account.component';
import { ContactComponent } from './components/contact/contact.component';
import { ProductComponent } from './components/product/product.component';
import { GetOnePipe } from './pipes/get-one.pipe';

@NgModule({
  declarations: [
    AppComponent,
    ProductsComponent,
    AvailablePipe,
    SortedPipe,
    MaxPricePipe,
    HeaderComponent,
    FooterComponent,
    HomeComponent,
    AccountComponent,
    ContactComponent,
    ProductComponent,
    GetOnePipe
  ],
  imports: [
    BrowserModule,
    NgbModule,
    FormsModule, // we add this to manage forms
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
