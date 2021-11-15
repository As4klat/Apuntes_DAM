import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { Joke } from '../Clases/joke';

@Injectable({
  providedIn: 'root'
})
export class JokesService {

  private jokes$ = new Subject<Joke[]>();
  jokes: Joke[] = [
    new Joke("What did the cheese say when it looked in the mirror?", "Hello-me(Halloumi)"),
    new Joke("What kind of cheese do you use to disguise a small horse?", "Mask-apony(Mascarpone)"),
    new Joke("A kid threw a lump of cheddar at me", "I thought ‘That’s not verymature’"),
  ];
  constructor() {}

  jokesObse$(): Observable<Joke[]>{
    return this.jokes$.asObservable();
  }

  getJokes(){
    this.jokes$.next(this.jokes);
  }
  addJoke(joke: Joke){
      this.jokes.push(joke);
      this.jokes$.next(this.jokes);
  }
  deleteJoke(joke: Joke){
    this.jokes.splice(this.jokes.indexOf(joke), 1);
    this.jokes$.next(this.jokes);
  }
}
