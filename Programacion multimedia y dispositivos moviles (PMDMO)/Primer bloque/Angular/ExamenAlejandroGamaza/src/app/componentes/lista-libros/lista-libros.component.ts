import { Observable } from 'rxjs';
import { ListaLibrosService } from './../../servicios/lista-libros.service';
import { Libro } from './../../clases/libro';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-lista-libros',
  templateUrl: './lista-libros.component.html',
  styleUrls: ['./lista-libros.component.css']
})
export class ListaLibrosComponent implements OnInit {

  listaLibros:Libro[]=[];
  listaLibros$: Observable<Libro[]>;
  
  constructor(private _libros: ListaLibrosService) { 
    this.listaLibros$ = this._libros.librosObserve$();
    this.listaLibros = this._libros.getListaLibros;
    this.listaLibros$.subscribe(listaLibros => this.listaLibros = listaLibros);
  }

  ngOnInit(): void {
  }

}
