import { Component } from '@angular/core';
import { Boton } from '../boton/boton.component';

@Component({
  selector: 'app-list-boton',
  templateUrl: './list-boton.component.html',
  styleUrls: ['./list-boton.component.css']
})
export class ListBotonComponent {
  botons: Boton[];
  
  constructor() {
    this.botons = [
      new Boton("Color Azul","blue"),
      new Boton("Color Verde","Green"),
      new Boton("Color Rojo","Red")
  ];
  }

}
