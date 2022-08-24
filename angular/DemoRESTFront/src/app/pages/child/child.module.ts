import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ChildRoutingModule } from './child-routing.module';
import { ChildComponent } from './child.component';
import { ChildListComponent } from './child-list/child-list.component';
import { ChildDetailsComponent } from './child-details/child-details.component';


@NgModule({
  declarations: [
    ChildComponent,
    ChildListComponent,
    ChildDetailsComponent
  ],
  imports: [
    CommonModule,
    ChildRoutingModule
  ]
})
export class ChildModule { }
