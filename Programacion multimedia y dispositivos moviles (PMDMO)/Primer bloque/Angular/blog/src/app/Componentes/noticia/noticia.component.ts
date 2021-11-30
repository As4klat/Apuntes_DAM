import { Component, Input, Output, EventEmitter } from '@angular/core';
import { Noticia } from 'src/app/Clases/noticia';

@Component({
  selector: 'app-noticia',
  templateUrl: './noticia.component.html',
  styleUrls: ['./noticia.component.css']
})
export class NoticiaComponent {

  constructor(){
    this.data = new Noticia("","",new Date);
  }

  @Input('noticia') data: Noticia;
  @Output() _borrarNoticia = new EventEmitter<Noticia>();

  borrarNoticia(data: Noticia){
    this._borrarNoticia.emit(data);
  }
}
