import { Component, OnInit } from "@angular/core";
import { Observable } from "rxjs";
import { Joke } from "src/app/Clases/joke";
import { JokesService } from "src/app/Servicio/jokes.service";

@Component ({
    selector: 'joke-list',
    templateUrl: './jokeList.component.html'
})

export class JokeListComponent {

    jokes$: Observable<Joke[]>;
    jokes: Joke[]; //Comentar esta linea para el ejemplo del for con 'async'

    constructor(public _servicio:JokesService) {
    }

    ngOnInit(){
        this.jokes$ = this._servicio.jokesObse$();
        this.jokes$.subscribe(jokes => this.jokes = jokes); //Comentar esta linea para el ejemplo del for con 'async'
        this._servicio.getJokes();      // Aqui es donde muestro la primera carga la lista de bromas, sin el no muestra.
                                        // *Nota: Si se usa async, da igual que se haga, no muestra la primera carga las bormas.
    }

    addJoke(joke: Joke){
        this._servicio.addJoke(joke);
    }
    deleteJoke(joke: Joke){
        this._servicio.deleteJoke(joke);
    }
    
}