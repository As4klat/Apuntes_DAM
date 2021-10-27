import { Component, Input } from '@angular/core';
import { Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-cabecera',
  templateUrl: './cabecera.component.html',
  styleUrls: ['./cabecera.component.css']
})
export class CabeceraComponent {

  constructor() { }

  @Output() btnHideLogo = new EventEmitter<boolean>();
  @Output() btnToggleLogo = new EventEmitter<boolean>();
  @Input('toggleImg') url: String;
  
  hideLogo(value: boolean){
    this.btnHideLogo.emit(value);
  }
  toggleLogo(value: boolean){
    this.btnToggleLogo.emit(value);
  }
}
