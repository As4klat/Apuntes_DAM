import { Component, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-modo-oscuro',
  templateUrl: './modo-oscuro.component.html',
  styleUrls: ['./modo-oscuro.component.css']
})
export class ModoOscuroComponent {

  oscuro: boolean;
  constructor() { 
    this.oscuro = false;
  }

  @Output() _toggleTheme = new EventEmitter<boolean>();
  toggleTheme(){
    this.oscuro = !this.oscuro;
    this._toggleTheme.emit(this.oscuro);
  }
}
