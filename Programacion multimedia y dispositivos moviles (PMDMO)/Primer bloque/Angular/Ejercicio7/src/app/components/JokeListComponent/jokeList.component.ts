import { Component } from "@angular/core";
import { Observable } from "rxjs";
import { Joke } from "src/app/Clases/joke";
import { JokesService } from "src/app/Servicio/jokes.service";

@Component ({
    selector: 'joke-list',
    templateUrl: './jokeList.component.html'
})

export class JokeListComponent {

    jokes$: Observable<Joke[]>;
    jokes: Joke[];

    constructor(public _servicio:JokesService) {
        this.jokes$ = this._servicio.jokesObse$();
        this.jokes$.subscribe(jokes => this.jokes = jokes);
        this._servicio.getJokes();
    }

    addJoke(joke: Joke){
        this._servicio.addJoke(joke);
    }
    deleteJoke(joke: Joke){
        this._servicio.deleteJoke(joke);
    }
    
}