import { Component, Output,EventEmitter } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Joke } from 'src/app/Clases/joke';

@Component({
  selector: 'joke-form-component',
  styleUrls: ['./joke-form-component.component.css'],
  templateUrl: './joke-form-component.component.html'
})
export class JokeFormComponentComponent {

  @Output() jokeCreated = new EventEmitter<Joke>();

  form: FormGroup;
  formInvalid: boolean;

  constructor(private fb: FormBuilder){
    this.formInvalid = false;
    this.form = this.fb.group({
      chiste: ["", [Validators.required, Validators.minLength(6)]],
      respuesta: ["", [Validators.required, Validators.minLength(6)]]
    });
  }

  onSubmit(setup: string, punchline: string){
    if(this.form.valid){
      this.jokeCreated.emit(new Joke(setup, punchline));
      this.formInvalid = false;
    }
    else{
      this.formInvalid = true;
    }
  }
}
