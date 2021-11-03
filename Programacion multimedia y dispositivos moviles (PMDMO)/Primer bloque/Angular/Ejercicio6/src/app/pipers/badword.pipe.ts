import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'badword'
})
export class BadwordPipe implements PipeTransform {

  transform(cadena: string, args: string[]): string {

    for (let palabra of args){
      cadena = cadena.replace(palabra, this.contarLetras(palabra));
    }
    return cadena;
  }

  contarLetras(palabra: string){
    let asteriscos = "";
    for (let caracter of palabra){
      asteriscos += "*";
    }
    return asteriscos;
  }

}
