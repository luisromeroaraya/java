import {Address} from "./address";

export interface Tutor {
  id: number,
  firstName: string;
  lastName: string;
  telephone: string;
  address: Address;
  childrenId: number[];
}
