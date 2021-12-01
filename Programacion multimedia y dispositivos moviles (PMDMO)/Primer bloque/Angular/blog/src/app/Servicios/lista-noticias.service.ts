import { findReadVarNames, not } from '@angular/compiler/src/output/output_ast';
import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';
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

  getNoticia(titulo: string): Noticia{
    let noticia = new Noticia("","",new Date());
    this.listaNoticias.forEach(x => {
      if(titulo == x.titulo){
        noticia = x;
      }
    });
    return noticia;
  }

  addNoticia(noticia: Noticia){
    this.listaNoticias.push(noticia);
    this.listaNoticias$.next([...this.listaNoticias]);
  }

  borrarNoticias(noticia: Noticia){
    this.listaNoticias.splice(this.listaNoticias.indexOf(noticia), 1);
    this.listaNoticias$.next([...this.listaNoticias]);
  }
}
