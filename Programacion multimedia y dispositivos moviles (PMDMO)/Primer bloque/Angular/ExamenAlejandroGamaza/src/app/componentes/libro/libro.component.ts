import { Libro } from './../../clases/libro';
import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-libro',
  templateUrl: './libro.component.html',
  styleUrls: ['./libro.component.css']
})
export class LibroComponent implements OnInit {

  
  constructor() {
    this.libro = new Libro('','','',new Date);
   }

  ngOnInit(): void {
  }
  @Input('libro') libro: Libro;

}
