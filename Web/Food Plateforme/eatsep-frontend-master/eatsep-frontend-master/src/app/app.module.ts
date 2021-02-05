import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppMaterialModule } from './app-material/app-material.module';

import { FlexLayoutModule } from '@angular/flex-layout';
import { SearchPageComponent } from './components/search-page/search-page.component';
import { ProfilePageComponent } from './components/profile-page/profile-page.component';
import { CookPageComponent } from './components/cook-page/cook-page.component';
import { SearchFilterComponent } from './search-filter/search-filter.component';
import { DishCardComponent } from './dish-card/dish-card.component';



@NgModule({
  declarations: [
    AppComponent,
    SearchPageComponent,
    ProfilePageComponent,
    CookPageComponent,
    SearchFilterComponent,
    DishCardComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    AppMaterialModule, // './app-material/app-material.module'
    FlexLayoutModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
