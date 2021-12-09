import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-biblioteca',
  templateUrl: './biblioteca.component.html',
  styleUrls: ['./biblioteca.component.css']
})
export class BibliotecaComponent implements OnInit {

  login:boolean = false;
  constructor() { }

  ngOnInit(): void {
  }

  isLoged(){
    this.login=true;
  }

}
