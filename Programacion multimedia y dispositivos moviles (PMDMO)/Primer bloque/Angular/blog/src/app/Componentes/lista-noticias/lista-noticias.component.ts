import { Component, OnInit } from '@angular/core';
import { ListaNoticiasService } from '../../Servicios/lista-noticias.service';
import { Noticia } from 'src/app/Clases/noticia';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-lista-noticias',
  templateUrl: './lista-noticias.component.html',
  styleUrls: ['./lista-noticias.component.css']
})
export class ListaNoticiasComponent implements OnInit {

  listaNoticias: Noticia[] = [];
  private listaNoticias$: Observable<Noticia[]>;

  constructor(private _noticia: ListaNoticiasService) { 
    this.listaNoticias$ = this._noticia.listaNoticiasObs$();
  }

  ngOnInit(): void {
    this.listaNoticias = this._noticia.getNoticias;
    this.listaNoticias$.subscribe(listaNoticias => this.listaNoticias = listaNoticias);
  }

  addNoticia(noticia: Noticia){
    this._noticia.addNoticia(noticia);
  }

  borrarNoticia(noticia: Noticia){
    this._noticia.borrarNoticias(noticia);
  }

}
