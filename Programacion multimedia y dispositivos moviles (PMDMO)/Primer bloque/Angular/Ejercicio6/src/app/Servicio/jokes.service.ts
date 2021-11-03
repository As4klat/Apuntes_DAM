import { Injectable } from '@angular/core';
import { Joke } from '../Clases/joke';

@Injectable({
  providedIn: 'root'
})
export class JokesService {

  jokes: Joke[] = [
    new Joke("What did the cheese say when it looked in the mirror?", "Hello-me(Halloumi)"),
    new Joke("What kind of cheese do you use to disguise a small horse?", "Mask-apony(Mascarpone)"),
    new Joke("A kid threw a lump of cheddar at me", "I thought ‘That’s not verymature’"),
  ];
  constructor() {
    
  }
  getJokes(){
    return this.jokes;
  }
  addJoke(joke: Joke){
      this.jokes.push(joke);
  }
}
