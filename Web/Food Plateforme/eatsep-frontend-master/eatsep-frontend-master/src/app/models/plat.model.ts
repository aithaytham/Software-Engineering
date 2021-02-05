import { User } from './user.model';

export interface Plat {
   id: number;
   user: User;
   title: string;
   description: string;
   ingredients: string;
   categorie: string[];
   prix: number;
   images: Image[];
   mark: number;
   keywords: string[];
  }

export interface Image {
    id: number;
    name: string;
   }

export interface PlatDate {
    plat: Plat;
    date: Date ;

   }

export interface Reservation {
    platdate: PlatDate;
    isAccepted: boolean;
    comment: string;
    user: User;

   }
