import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { BotonComponent } from './components/boton/boton.component';
import { ListBotonComponent } from './components/list-boton/list-boton.component';

@NgModule({
  declarations: [
    AppComponent,
    BotonComponent,
    ListBotonComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
