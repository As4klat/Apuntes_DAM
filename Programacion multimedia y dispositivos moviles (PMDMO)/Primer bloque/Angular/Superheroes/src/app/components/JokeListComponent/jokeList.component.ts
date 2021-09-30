import { Component } from "@angular/core";
import { Joke } from "../JokeComponent/joke.component";


@Component ({
    selector: 'joke-list',
    templateUrl: './jokeList.component.html'
})

export class JokeList {

    jokes: Joke[];

    constructor() {
        this.jokes = [
            new Joke("What did the cheese say when it looked in the mirror?", "Hello-me(helloumi)")
        ];
    }
}