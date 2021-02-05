import { Plat } from '../plat.model';
import { USERS } from './users.mock';

export const Plats: Plat[] = [
  // id: number;
  //  user: User;
  //  title: string;
  //  description: string;
  //  ingredients: string;
  //  categorie: string[];
  //  prix: number;
  //  images: Image[];
  //  mark: number;
  //  keywords: string[];
  {
  id: 2,
  user: USERS[0],
  title: 'spaghetti carbonara',
  description: 'au top',
  ingredients: 'lardon / crème fraîche',
  categorie: ['viande', 'Healthy'],
  prix: 3.3,
  images: [{id: 1, name: '../../assets/images/plats/plat3.png'}],
  mark: 3,
  keywords: ['spag', 'carbo', 'italien', 'pate']
},
{
  id: 2,
  user: USERS[0],
  title: 'spaghetti carbonara',
  description: 'au top',
  ingredients: 'lardon / crème fraîche',
  categorie: ['viande', 'Healthy'],
  prix: 3.3,
  images: [{id: 1, name: '../../assets/images/plats/plat4.png'}],
  mark: 2,
  keywords: ['spag', 'carbo', 'italien', 'pate']
},
{
  id: 2,
  user: USERS[0],
  title: 'spaghetti carbonara',
  description: 'au top',
  ingredients: 'lardon / crème fraîche',
  categorie: ['viande', 'Healthy'],
  prix: 3.3,
  images: [{id: 1, name: '../../assets/images/plats/plat3.png'}],
  mark: 0,
  keywords: ['spag', 'carbo', 'italien', 'pate']
},
{
  id: 2,
  user: USERS[0],
  title: 'spaghetti carbonara',
  description: 'au top',
  ingredients: 'lardon / crème fraîche',
  categorie: ['viande', 'Healthy'],
  prix: 3.3,
  images: [{id: 1, name: '../../assets/images/plats/plat4.png'}],
  mark: 0,
  keywords: ['spag', 'carbo', 'italien', 'pate']
}
]
