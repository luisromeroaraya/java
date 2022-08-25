import { Component, OnInit } from '@angular/core';
import { Router} from "@angular/router";

@Component({
  selector: 'app-reservation',
  templateUrl: './reservation.component.html',
  styleUrls: ['./reservation.component.css']
})
export class ReservationComponent implements OnInit {
  // variables
  split: boolean = false;

  // constructor
  constructor(private router: Router) { }

  // methods
  ngOnInit(): void {
    if (this.router.url != "/reservations")
      this.split = true;
  }
}
