
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { CabeceraComponent } from './componentes/cabecera/cabecera.component';
import { PadreComponent } from './componentes/padre/padre.component';

@NgModule({
  declarations: [
    CabeceraComponent,
    PadreComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [PadreComponent]
})
export class AppModule { }
