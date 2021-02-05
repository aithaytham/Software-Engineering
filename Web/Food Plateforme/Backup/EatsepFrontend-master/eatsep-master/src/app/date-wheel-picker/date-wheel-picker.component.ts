import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-date-wheel-picker',
  templateUrl: './date-wheel-picker.component.html',
  styleUrls: ['./date-wheel-picker.component.scss']
})
export class DateWheelPickerComponent implements OnInit {

  months = ['janvier', 'fevrier', 'mars', 'avril', 'mai', 'juin', 'juillet', 'aout', 'septembre', 'octobre', 'novembre', 'decembre'
]
  currentMonth = 'janvier';

  constructor() { }

  ngOnInit() {
  }

  changeMonth(month: string) {
    this.currentMonth = month;
  }




}
