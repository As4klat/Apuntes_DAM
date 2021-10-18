import { Component, Input, Output,EventEmitter } from "@angular/core";
import { Data } from "@angular/router";
import { Joke } from "src/app/Clases/joke";

@Component({
    selector: 'joke',
    templateUrl: './joke.component.html'
})

export class JokeComponent {
    @Input('joke') data: Joke;

    @Output() jokeDelete = new EventEmitter<Joke>();
    deleteJoke(data: Joke){
        this.jokeDelete.emit(data);
    }
}