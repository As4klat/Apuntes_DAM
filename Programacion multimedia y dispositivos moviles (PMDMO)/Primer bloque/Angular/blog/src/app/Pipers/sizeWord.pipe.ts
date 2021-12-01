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
          cadena = cadena.substr(0,limite) + "...";
        }
        break;
      case 1:
        limite = 50;
        if(cadena.length >= limite){
          cadena = cadena.substr(0,limite) + "..."
        }
        break;
    }
    
    return cadena;
  }
}
