import { Component, Input } from "@angular/core";
import { Data } from "@angular/router";

export class Joke {

    public setup: string;
    public punchline: string;
    public hide: boolean;

    constructor(setup: string, punchline: string) {
        this.setup = setup;
        this.punchline = punchline;
        this.hide = true;
    }

    toggle(){
        this.hide = !this.hide;
    }
}

@Component({
    selector: 'joke',
    templateUrl: './joke.component.html'
})

export class JokeComponent {
    @Input('joke') data: Joke;
}