import { Injectable } from '@angular/core';
import { EMPTY, Observable, Subject } from 'rxjs';

import { Noticia } from '../Clases/noticia';

@Injectable({
  providedIn: 'root'
})
export class ListaNoticiasService {

  private listaNoticias: Noticia[];

  private listaNoticias$: Subject<Noticia[]>;

  constructor() {
    this.listaNoticias = [
      new Noticia("Noticia 1","Breve introducion a la primera noticia de este trabajo",new Date()),
      new Noticia("Noticia 2","Breve introducion a la primera noticia de este trabajo",new Date()),
      new Noticia("Noticia 3","Breve introducion a la primera noticia de este trabajo",new Date()),
      new Noticia("Noticia 4","Breve introducion a la primera noticia de este trabajo",new Date()),
    ];

    this.listaNoticias$ = new Subject<Noticia[]>();
  }

  listaNoticiasObs$(): Observable<Noticia[]>{
    return this.listaNoticias$.asObservable();
  }

  get getNoticias(){
    return [...this.listaNoticias];
  }

  addNoticia(noticia: Noticia){
    this.listaNoticias.push(noticia);
    this.listaNoticias$.next();
  }

  borrarNoticias(noticia: Noticia){
    this.listaNoticias.splice(this.listaNoticias.indexOf(noticia), 1);
    this.listaNoticias$.next();
  }
}
