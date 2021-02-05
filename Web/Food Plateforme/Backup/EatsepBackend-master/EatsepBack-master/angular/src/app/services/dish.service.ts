import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';

import { environment } from '../../environments/environment';
import "@reactivex/rxjs/dist-compat/package/add/operator/map";

@Injectable()
export class DishService {
  constructor(private http: Http) { }

  getDishes() {
    return this.http.get(environment.api + '/dish')
      .map(res => res.json());
  }

  createDish(todo) {
    return this.http.post(environment.api + '/dish', todo)
      .map(res => res.json());
  }

  updateDish(todo) {
    return this.http.put(environment.api + '/dish', todo)
      .map(res => res.json());
  }

  deleteDish(todo) {
    return this.http.delete(environment.api + '/dish/' + todo.id);
  }
}
