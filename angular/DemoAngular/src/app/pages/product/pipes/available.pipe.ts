import { Pipe, PipeTransform } from '@angular/core';
import { Product } from '../types/product';

@Pipe({
  name: 'available',
  pure: false // to force the pipe to be executed every time something changes in the page
})
export class AvailablePipe implements PipeTransform {

  transform(value: Product[], active: boolean = true): Product[] {
    if (active) {
      return value.filter((e)=> e.quantity > 0);
    }
    return value;
  }

}
