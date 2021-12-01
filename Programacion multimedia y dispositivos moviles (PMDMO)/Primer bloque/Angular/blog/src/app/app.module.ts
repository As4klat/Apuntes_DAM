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
import { ModoOscuroComponent } from './Componentes/modo-oscuro/modo-oscuro.component';
//Importaciones de servicios
import { ListaNoticiasService } from './Servicios/lista-noticias.service';
import { HomeComponent } from './Componentes/home/home.component';
import { SizeWordPipe } from './Pipers/sizeWord.pipe';

@NgModule({
  declarations: [
    LoginComponent,
    ListaNoticiasComponent,
    NoticiaComponent,
    FormNoticiaComponent,
    ModoOscuroComponent,
    HomeComponent,
    SizeWordPipe
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    AppRoutingModule
  ],
  providers: [ListaNoticiasService],
  bootstrap: [HomeComponent]
})
export class AppModule { }
