import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import {JokeComponent} from './components/JokeComponent/joke.component';
import { JokeListComponent } from './components/JokeListComponent/jokeList.component';

@NgModule({
  declarations: [
    JokeListComponent,
    JokeComponent,
    AppComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }