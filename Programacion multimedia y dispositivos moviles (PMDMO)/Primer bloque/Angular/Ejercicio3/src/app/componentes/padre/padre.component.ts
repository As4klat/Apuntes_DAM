import { Component } from '@angular/core';

@Component({
  selector: 'app-padre',
  templateUrl: './padre.component.html',
  styleUrls: ['./padre.component.css']
})
export class PadreComponent {
  logoOculto: boolean;
  cambiarImagen: boolean;
  imagenUrl: String;

  constructor() { 
    this.logoOculto = false;
    this.cambiarImagen = false;
    this.imagenUrl = "../../../assets/Angular.png";
  }

  hideLogo(valor: boolean){
    this.logoOculto = !this.logoOculto;
  }
  toggleLogo(valor: boolean){
    this.cambiarImagen = !this.cambiarImagen;
    if(!this.cambiarImagen){
      this.imagenUrl = "../../../assets/Angular.png"
    }
    else{
      this.imagenUrl = "../../../assets/Vue.png"
    }
  }
}
