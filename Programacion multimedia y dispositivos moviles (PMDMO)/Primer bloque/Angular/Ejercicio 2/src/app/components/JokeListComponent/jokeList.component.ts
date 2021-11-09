import { Component } from "@angular/core";
import { Joke } from "src/app/Clases/joke";
import { JokesService } from "src/app/Servicio/jokes.service";

@Component ({
    selector: 'joke-list',
    templateUrl: './jokeList.component.html'
})

export class JokeListComponent {

    jokes: Joke[];

    constructor(public _servicio:JokesService) {
        /*this.jokes = [
            new Joke("What did the cheese say when it looked in the mirror?", "Hello-me(Halloumi)"),
            new Joke("What kind of cheese do you use to disguise a small horse?", "Mask-apony(Mascarpone)"),
            new Joke("A kid threw a lump of cheddar at me", "I thought ‘That’s not verymature’"),
        ];*/
        this.jokes = _servicio.getJokes();
    }

    addJoke(joke: Joke){
        this.jokes.unshift(joke);
    }
    deleteJoke(joke: Joke){
        this.jokes.splice(this.jokes.indexOf(joke), 1);
    }
}