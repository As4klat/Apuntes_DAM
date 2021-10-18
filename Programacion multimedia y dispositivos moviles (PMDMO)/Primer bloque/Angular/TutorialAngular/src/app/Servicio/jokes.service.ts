import { Injectable } from '@angular/core';
import { Joke } from '../Clases/joke';

@Injectable({
  providedIn: 'root'
})
export class JokesService {

  jokes: Joke[];
  constructor() {
    
  }
  addJoke(joke: Joke){
      
  }
}
