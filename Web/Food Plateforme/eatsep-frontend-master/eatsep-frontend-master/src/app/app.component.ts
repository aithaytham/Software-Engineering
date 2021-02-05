import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  pages = [{tilte: 'recherche' , icon: 'search', link: './search' }, {tilte: 'profile' , icon: 'person', link: './profile' }, {tilte: 'chef' , icon: 'restaurant', link: './cook' }];

}
