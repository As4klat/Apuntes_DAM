import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-hijo',
  templateUrl: './hijo.component.html',
  styleUrls: ['./hijo.component.css']
})
export class HijoComponent {

  @Input('btnPulsado') intPosicion:number;

  constructor() { }

  getBoton(){
    return this.intPosicion;
  }
}
