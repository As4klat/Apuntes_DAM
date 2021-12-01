import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'sizeWord'
})
export class SizeWordPipe implements PipeTransform {

  transform(cadena: string, args: number): string {
    let limite;
    switch(args){
      case 0:
        limite = 10;
        if(cadena.length >= limite){
          let cadena2 = cadena.substr(limite-1,cadena.length);
          cadena = cadena.replace(cadena2, "...")
        }
        break;
      case 1:
        limite = 50;
        if(cadena.length >= limite){
          cadena.substr(limite-1,cadena.length) + "..."
        }
        break;
    }
    
    return cadena;
  }
}
