import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import {JokeComponent} from './components/JokeComponent/joke.component';
import { JokeListComponent } from './components/JokeListComponent/jokeList.component';
import { JokeFormComponentComponent } from './components/joke-form-component/joke-form-component.component';
import { JokesService } from './Servicio/jokes.service';

@NgModule({
  declarations: [
    JokeListComponent,
    JokeComponent,
    JokeFormComponentComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [JokesService],
  bootstrap: [JokeListComponent]
})
export class AppModule { }
