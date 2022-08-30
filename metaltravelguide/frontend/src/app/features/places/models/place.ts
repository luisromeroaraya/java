import {Address} from "./address";
import {Contact} from "./contact";

export interface place {
  id: number;
  googleId?: any;
  name: string;
  address: Address;
  contact: Contact;
  type: string;
  description: string;
  image: string;
  username: string;
}
