import { ListaLibrosService } from './servicios/lista-libros.service';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BibliotecaComponent } from './componentes/biblioteca/biblioteca.component';
import { MenuComponent } from './componentes/menu/menu.component';
import { BienvenidaComponent } from './componentes/bienvenida/bienvenida.component';
import { ListaLibrosComponent } from './componentes/lista-libros/lista-libros.component';
import { BuscadorComponent } from './componentes/buscador/buscador.component';
import { LibroComponent } from './componentes/libro/libro.component';

@NgModule({
  declarations: [
    BibliotecaComponent,
    MenuComponent,
    BienvenidaComponent,
    ListaLibrosComponent,
    BuscadorComponent,
    LibroComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [ListaLibrosService],
  bootstrap: [BibliotecaComponent]
})
export class AppModule { }
