import { Component, OnInit } from '@angular/core';
import { CATEGORIES } from '../models/mock/categorie.mock';

@Component({
  selector: 'app-search-filter',
  templateUrl: './search-filter.component.html',
  styleUrls: ['./search-filter.component.scss']
})
export class SearchFilterComponent implements OnInit {
  allcat: boolean = false;

  categories = CATEGORIES;

  constructor() { }

  ngOnInit(): void {
  }

  toggleIcon(cat: any) {
    const index = this.categories.indexOf(cat);
    if (index === 0) {
      this.toggleAllIcon();
    } else {
      this.categories[index].isActive = !this.categories[index].isActive;
    }
  }

  toggleAllIcon() {
    this.allcat = !this.allcat;
    for(let i = 0; i < this.categories.length; i++){
      this.categories[i].isActive = this.allcat;
    }
  }

}
