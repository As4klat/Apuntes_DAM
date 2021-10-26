import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { ListBotonComponent } from './components/list-boton/list-boton.component';
import { HijoComponent } from './components/hijo/hijo.component';

@NgModule({
  declarations: [
    ListBotonComponent,
    HijoComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [ListBotonComponent]
})
export class AppModule { }
