import { Component, Output,EventEmitter } from '@angular/core';
import { Joke } from 'src/app/Clases/joke';

@Component({
  selector: 'joke-form-component',
  templateUrl: './joke-form-component.component.html'
})
export class JokeFormComponentComponent {
  @Output() jokeCreated = new EventEmitter<Joke>();

  createJoke(setup: string, punchline: string){
    this.jokeCreated.emit(new Joke(setup, punchline));
  }
}
