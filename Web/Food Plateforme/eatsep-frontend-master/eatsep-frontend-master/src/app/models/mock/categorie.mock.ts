import { Categorie } from '../categorie.model';

export const CATEGORIES: Categorie[] = [
  {label: 'Tout',
   isActive: false,
   srcUrlFalse: '../../../assets/icons_dishes_filter/all_cat_false.png',
   srcUrlTrue: '../../../assets/icons_dishes_filter/all_cat_true.png'},
  {label: 'Viande',
   isActive: false,
   srcUrlFalse: '../../../assets/icons_dishes_filter/meat_false.png',
   srcUrlTrue: '../../../assets/icons_dishes_filter/meat_true.png'},
  {label: 'Poisson',
   isActive: false,
   srcUrlFalse: '../../../assets/icons_dishes_filter/fish_false.png',
   srcUrlTrue: '../../../assets/icons_dishes_filter/fish_true.png'},
  {label: 'Feculent',
   isActive: false,
   srcUrlFalse: '../../../assets/icons_dishes_filter/starchy_false.png',
   srcUrlTrue: '../../../assets/icons_dishes_filter/starchy_true.png'},
  {label: 'Vegan',
   isActive: false,
   srcUrlFalse: '../../../assets/icons_dishes_filter/vegan_false.png',
   srcUrlTrue: '../../../assets/icons_dishes_filter/vegan_true.png'},
  {label: 'Healthy',
   isActive: false,
   srcUrlFalse: '../../../assets/icons_dishes_filter/healthy_false.png',
   srcUrlTrue: '../../../assets/icons_dishes_filter/healthy_true.png'},
  {label: 'Froid',
   isActive: false,
   srcUrlFalse: '../../../assets/icons_dishes_filter/cold_false.png',
    srcUrlTrue: '../../../assets/icons_dishes_filter/cold_true.png'}
];

export const FEWCTAEGORIES: Categorie[] = [
  {label: 'Healthy',
   isActive: false,
   srcUrlFalse: '../../../assets/icons_dishes_filter/healthy_false.png',
   srcUrlTrue: '../../../assets/icons_dishes_filter/healthy_true.png'},
  {label: 'Froid',
   isActive: false,
   srcUrlFalse: '../../../assets/icons_dishes_filter/froid_false.png',
    srcUrlTrue: '../../../assets/icons_dishes_filter/froid_true.png'}
]
