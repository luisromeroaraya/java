import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { FormsModule } from "@angular/forms";
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from "@angular/common/http";
import { SecurityModule } from "./core/security/security.module";
import { AppComponent } from './app.component';
import { HeaderComponent } from "./core/components/header/header.component";
import { FooterComponent } from "./core/components/footer/footer.component";
import { HomeComponent } from './core/components/home/home.component';
import { PrivacyComponent } from './core/components/privacy/privacy.component';
import { ContactComponent } from './core/components/contact/contact.component';



@NgModule({
    declarations: [
      AppComponent,
      HeaderComponent,
      FooterComponent,
      HomeComponent,
      PrivacyComponent,
      ContactComponent
    ],
  imports: [
    BrowserModule,
    FormsModule,
    NgbModule,
    AppRoutingModule,
    HttpClientModule,
    SecurityModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
