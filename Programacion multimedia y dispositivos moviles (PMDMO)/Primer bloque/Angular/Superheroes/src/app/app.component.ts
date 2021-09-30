import { Component } from '@angular/core';

class Superheroe {
  nombre: String;
  superPoder: String;
  volar: boolean;

  constructor(nombre: String, superPoder: String, volar: boolean){
    this.nombre = nombre;
    this.superPoder = superPoder;
    this.volar = volar;
  }
}

@Component({
  selector: 'Superheroes',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class Superheroes {
  title = 'Superheroes';
  superheroes: Superheroe[];

  constructor(){
    this.superheroes = [
      new Superheroe("Antonio", "Super fuerza", true),
      new Superheroe("Juan", "Intangible", false),
      new Superheroe("Super Lopez", "Conocimiento", false)
    ]
      
  }
}
