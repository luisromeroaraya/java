import { Pipe, PipeTransform } from '@angular/core';
import {Product} from "../types/product";

@Pipe({
  name: 'getOne'
})
export class GetOnePipe implements PipeTransform {

  transform(value: Product[], id: number): Product {
    return value[id];
  }

}
