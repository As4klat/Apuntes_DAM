import { Component } from '@angular/core';

@Component({
  selector: 'app-list-boton',
  templateUrl: './list-boton.component.html',
  styleUrls: ['./list-boton.component.css']
})
export class ListBotonComponent {
  btnId: number;
  constructor() {
    this.btnId = 1;
  }

}
