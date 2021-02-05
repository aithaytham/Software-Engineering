import { Component, OnInit } from '@angular/core';

import { UserService } from './services/user.service';
import { DishService } from './services/dish.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  Dishs: Array<any>;
  newDish: any;
  User: any;
  requesting: boolean;

  constructor(private DishService: DishService, private UserService: UserService) { }

  ngOnInit() {
    this.newDish = { title: 'a', description: 'a'/*, Users: []*/ };
    this.User = { name: ''/*, Users: []*/ };
    this.requesting = false;
    this.getDishes();
  }


  getDishes() {
    this.requesting = true;
    this.DishService.getDishes().subscribe((res) => {
      this.Dishs = res.Dishs;
      this.requesting = false;
    }, (err) => {
      this.requesting = false;
    })
  }

  createDish() {
    this.requesting = true;
    this.DishService.createDish(this.newDish).subscribe((res) => {
      this.Dishs.push(res);
      this.newDish = {};
      this.requesting = false;
    })

  }

  deleteDish(Dish) {

    this.requesting = true;
    this.DishService.deleteDish(Dish).subscribe(() => {
      this.Dishs.forEach((t, i) => {
        if (t.id == Dish.id) {
        }
      });
      this.requesting = false;
    })
  }

  createUser(User) {

    this.requesting = true;
    let newUser = { content: User.UserContent };

    this.UserService.createUser(newUser).subscribe((res) => {
      User.push(res);
      this.requesting = false;
    })
  }

  updateDish(Dish) {

    this.DishService.updateDish(Dish).subscribe((res) => {
      Dish = res;
      this.requesting = false;
    })
  }

  deleteUser(User) {
    this.requesting = true;
    this.UserService.deleteUser(User).subscribe(() => {
      this.requesting = false;
    })

  }
}
