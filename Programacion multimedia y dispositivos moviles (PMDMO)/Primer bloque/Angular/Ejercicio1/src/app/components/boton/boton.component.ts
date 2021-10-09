import { Component, Input } from '@angular/core';
import { Data } from "@angular/router";

export class Boton{
  nombre: string;
  style: string;

  constructor(nombre: string, style: string){
    this.nombre = nombre;
    this.style = style;
  }

  cambiaColor(){
    alert("Has pulsado: " + this.nombre);
    
  }
}

@Component({
  selector: 'boton',
  templateUrl: './boton.component.html',
  styleUrls: ['./boton.component.css']
})
export class BotonComponent {
  
  @Input('boton') data: Boton;

}
