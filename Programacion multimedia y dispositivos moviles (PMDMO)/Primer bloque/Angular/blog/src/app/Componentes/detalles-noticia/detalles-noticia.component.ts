import { ListaNoticiasService } from './../../Servicios/lista-noticias.service';
import { ActivatedRoute } from '@angular/router';
import { Component } from '@angular/core';
import { Noticia } from 'src/app/Clases/noticia';

@Component({
  selector: 'app-detalles-noticia',
  templateUrl: './detalles-noticia.component.html',
  styleUrls: ['./detalles-noticia.component.css']
})
export class DetallesNoticiaComponent {
  data: Noticia;
  titulo: string = "";
  constructor(private _ac: ActivatedRoute, private _listaNoticias: ListaNoticiasService) {
    this._ac.paramMap.subscribe((paramMap: any) =>{
      const {params} = paramMap;
      this.titulo = params.noticia;
    });
    this.data = this._listaNoticias.getNoticia(this.titulo);
   }

  borrarNoticia(noticia: Noticia){
    this._listaNoticias.borrarNoticias(noticia);
  }
}
