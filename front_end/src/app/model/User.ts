import { Role } from './Role'

export class User {
  id!:number;
  login!:string;
  password!:string;
  roles!:Role[];
  firstname!:string;
  surname!:string;
  email!:string;
  phone!:string;
  address!:string;
}
