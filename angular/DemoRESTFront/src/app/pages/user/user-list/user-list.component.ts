import { Component, OnInit } from '@angular/core';
import {IUser} from "../types/IUser";
import {UserService} from "../services/user.service";
import {IReservation} from "../../reservation/types/IReservation";

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {
  // variables
  private users: IUser[] = [];

  // constructor
  constructor(private _userService: UserService) { }

  // getters
  get Users(): IUser[] {
    return this.users;
  }

  // methods
  ngOnInit(): void {
    this.users = this._userService.getAll();
  }

}
