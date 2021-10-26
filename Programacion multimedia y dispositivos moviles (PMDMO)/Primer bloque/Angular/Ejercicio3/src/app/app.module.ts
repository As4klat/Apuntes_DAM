import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { CabeceraComponent } from './componentes/cabecera/cabecera.component';

@NgModule({
  declarations: [
    CabeceraComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [CabeceraComponent]
})
export class AppModule { }
