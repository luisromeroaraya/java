import { Pipe, PipeTransform } from '@angular/core';
import { Product } from '../types/product';

@Pipe({
  name: 'maxPrice'
})
export class MaxPricePipe implements PipeTransform {

  transform(value: Product[], priceFilter: number): Product[] {
    return value.filter((e) => e.price < priceFilter);
  }

}
