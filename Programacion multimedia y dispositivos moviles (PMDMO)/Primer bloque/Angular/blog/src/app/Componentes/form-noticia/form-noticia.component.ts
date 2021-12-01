import { Component, Output, EventEmitter } from '@angular/core';
import { Noticia } from 'src/app/Clases/noticia';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-form-noticia',
  templateUrl: './form-noticia.component.html',
  styleUrls: ['./form-noticia.component.css']
})
export class FormNoticiaComponent {

  form: FormGroup;

  @Output() _addNoticia = new EventEmitter<Noticia>();

  constructor(private fb: FormBuilder){
    this.form = this.fb.group({
      titulo: ["", [Validators.required]],
      cuerpo: ["", [Validators.required]],
      date: ["", [Validators.required]]
    })
  }
  
  addNoticia(titulo: string, cuerpo: string, date: Date | null){
    if(date==null){
      date = new Date();
    }
    this._addNoticia.emit(new Noticia(titulo,cuerpo,date));
    this.form.reset()
    //this.form.clearValidators();
  }
}
