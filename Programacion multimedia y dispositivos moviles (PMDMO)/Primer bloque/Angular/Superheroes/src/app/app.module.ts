import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { Superheroes } from './app.component';

@NgModule({
  declarations: [
    Superheroes
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [Superheroes]
})
export class AppModule { }
