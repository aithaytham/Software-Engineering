import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';

import { environment } from '../../environments/environment';
import "@reactivex/rxjs/dist-compat/package/add/operator/map";

@Injectable()
export class UserService {
  constructor(private http: Http) { }

  createUser(user) {
    return this.http.post(environment.api + '/user', user)
      .map(res => res.json());
  }

  /*updateTask(task) {
    return this.http.put(environment.api + '/task', task)
      .map(res => res.json());
  }*/

  deleteUser(user) {
    return this.http.delete(environment.api + '/task/' + user.id);
  }

}
