//Importaciones de angular
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
//Importacion de rutas
import { AppRoutingModule } from './app-routing.module';
//Importaciones de componentes
import { LoginComponent } from './Componentes/login/login.component';
import { ListaNoticiasComponent } from './Componentes/lista-noticias/lista-noticias.component';
import { NoticiaComponent } from './Componentes/noticia/noticia.component';
import { FormNoticiaComponent } from './Componentes/form-noticia/form-noticia.component';
//Importaciones de servicios
import { ListaNoticiasService } from './Servicios/lista-noticias.service';
import { ModoOscuroComponent } from './Componentes/modo-oscuro/modo-oscuro.component';

@NgModule({
  declarations: [
    LoginComponent,
    ListaNoticiasComponent,
    NoticiaComponent,
    FormNoticiaComponent,
    ModoOscuroComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    AppRoutingModule
  ],
  providers: [ListaNoticiasService],
  bootstrap: [FormNoticiaComponent]
})
export class AppModule { }
