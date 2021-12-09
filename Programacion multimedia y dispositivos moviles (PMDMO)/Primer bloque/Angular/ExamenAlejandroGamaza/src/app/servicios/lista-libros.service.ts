import { Libro } from './../clases/libro';
import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ListaLibrosService {

  private filtroLista: Libro[] = [];
  private listaLibros:Libro[] = [];
  private listaLibros$: Subject<Libro[]>;

  constructor() {
    for(let i = 0; i < 10; i++ ){
      this.listaLibros.push(new Libro('Titulo ' + i,'autor ' + i, 'IUSW71635815' + i, new Date()));
    };
    this.listaLibros$ = new Subject<Libro[]>();
  }

  librosObserve$() : Observable<Libro[]>{
    return this.listaLibros$.asObservable();
  }

  get getListaLibros(){
    return [...this.listaLibros];
  }

  filtrar(titulo:string){
    this.filtroLista = new Array<Libro>();
    if(titulo==''){
      this.listaLibros$.next([...this.listaLibros]);
    }
    else{
      this.listaLibros.forEach(libro => {
        if(libro.titulo === titulo){
          this.filtroLista.push(libro);
        }
      });
      this.listaLibros$.next([...this.filtroLista]);
    }
  }
}
