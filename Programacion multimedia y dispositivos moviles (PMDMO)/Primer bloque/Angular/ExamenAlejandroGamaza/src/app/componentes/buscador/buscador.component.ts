import { ListaLibrosService } from './../../servicios/lista-libros.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-buscador',
  templateUrl: './buscador.component.html',
  styleUrls: ['./buscador.component.css']
})
export class BuscadorComponent implements OnInit {

  constructor(private _libros: ListaLibrosService) {}

  ngOnInit(): void {
  }

  buscar(titulo: string){
    this._libros.filtrar(titulo);
  }
}
