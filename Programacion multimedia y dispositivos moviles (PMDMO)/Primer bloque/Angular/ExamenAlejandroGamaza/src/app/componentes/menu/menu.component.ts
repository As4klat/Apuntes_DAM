import { Component, OnInit, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {
  loginText:string = 'Login';
  constructor() { }

  ngOnInit(): void {
  }
  @Output() _loged = new EventEmitter();
  login(){
    this.loginText = "Usuario 1234";
    this._loged.emit();
  }

}
