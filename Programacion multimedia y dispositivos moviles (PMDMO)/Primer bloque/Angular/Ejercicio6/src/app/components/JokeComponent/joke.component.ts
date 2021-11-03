import { Component, Input, Output,EventEmitter } from "@angular/core";
import { Joke } from "src/app/Clases/joke";

@Component({
    selector: 'joke',
    templateUrl: './joke.component.html'
})

export class JokeComponent {

    badwordGroup: string[];

    @Input('joke') data: Joke;

    @Output() jokeDelete = new EventEmitter<Joke>();
    deleteJoke(data: Joke){
        this.jokeDelete.emit(data);
    }

    constructor(){
        this.badwordGroup = [
            'caca',
            'pene',
            'popo',
            'fuck',
            'lol'
        ]
    }
    
}