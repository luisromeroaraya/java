import { IAddress } from "./IAddress";

export interface ITutor {
  id: number,
  firstName: string;
  lastName: string;
  telephone: string;
  address: IAddress;
  childrenId: number[];
}
