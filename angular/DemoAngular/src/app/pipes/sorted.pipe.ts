import { Pipe, PipeTransform } from '@angular/core';
import { Product } from '../types/product';

@Pipe({
  name: 'sorted'
})
export class SortedPipe implements PipeTransform {

  transform(value: Product[], type: string): Product[] {
    switch(type) {
      case "priceAsc": {
        return value.sort(function(a,b) {return a.price - b.price});
        break;
      }
      case "priceDesc": {
        return value.sort(function(a,b) {return b.price - a.price});
        break;
      }
      case "nameAsc": {
        return value.sort(function(a,b) {return a.title > b.title ? 1 : -1});
        break;
      }
      case "nameDesc": {
        return value.sort(function(a,b) {return b.title > a.title ? 1 : -1});
        break;
      }
      default: {
        return value;
        break;
      }
    }
  }

}
