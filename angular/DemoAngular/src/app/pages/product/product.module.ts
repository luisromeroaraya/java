import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from "@angular/forms";

import { ProductRoutingModule } from './product-routing.module';
import { ProductComponent } from './product.component';
import { ProductListComponent } from "./components/product-list/product-list.component";
import { ProductDetailsComponent } from "./components/product-details/product-details.component";
import { AvailablePipe } from "./pipes/available.pipe";
import { SortedPipe } from "./pipes/sorted.pipe";
import { MaxPricePipe } from "./pipes/max-price.pipe";

@NgModule({
  declarations: [
    ProductComponent,
    ProductListComponent,
    ProductDetailsComponent,
    AvailablePipe,
    SortedPipe,
    MaxPricePipe,
  ],
  imports: [
    CommonModule,
    FormsModule,
    ProductRoutingModule
  ],
  exports: [
    AvailablePipe,
    SortedPipe,
    MaxPricePipe
  ]
})
export class ProductModule { }
