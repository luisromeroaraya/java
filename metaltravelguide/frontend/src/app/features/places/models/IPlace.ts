import {IAddress} from "./IAddress";
import {IContact} from "./IContact";

export interface IPlace {
  id: number;
  googleId?: any;
  name: string;
  address: IAddress;
  contact: IContact;
  type: string;
  description: string;
  image: string;
  username: string;
}
