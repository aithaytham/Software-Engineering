import { CookPageComponent } from './components/cook-page/cook-page.component';
import { ProfilePageComponent } from './components/profile-page/profile-page.component';
import { SearchPageComponent } from './components/search-page/search-page.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';


const routes: Routes =
[ { path: '', redirectTo: '/search', pathMatch: 'full' },
  { path: 'search', component:  SearchPageComponent},
  { path: 'profile', component:  ProfilePageComponent},
  { path: 'cook', component: CookPageComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
