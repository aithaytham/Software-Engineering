import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import {
  MatInputModule,
  MatButtonModule,
  MatSelectModule,
  MatToolbarModule,
  MatTabsModule,
  MatIconModule
} from '@angular/material';

@NgModule({
  imports: [
    CommonModule,

  ],
  exports: [
    MatInputModule,
    MatButtonModule,
    MatSelectModule,
    MatToolbarModule,
    MatTabsModule,
    MatIconModule
  ]
})
export class AppMaterialModule { }
