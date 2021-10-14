import { Component, Input } from "@angular/core";
import { Data } from "@angular/router";
import { Joke } from "src/app/Clases/joke";

@Component({
    selector: 'joke',
    templateUrl: './joke.component.html'
})

export class JokeComponent {
    @Input('joke') data: Joke;
}