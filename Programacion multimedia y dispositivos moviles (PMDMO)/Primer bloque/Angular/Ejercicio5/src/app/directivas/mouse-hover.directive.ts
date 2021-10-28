import { Directive, ElementRef, Host, HostListener, Renderer2 } from '@angular/core';

@Directive({
  selector: '[mouseHover]'
})
export class MouseHoverDirective {
  
  cadena: String;

  constructor(private el: ElementRef, private renderer: Renderer2) {
    this.cadena = "../../../assets/Angular.png";
   }
   @HostListener('mouseover') mouseover(){
    this.toggle();
    this.el.nativeElement.setAttribute('src', this.cadena);
  }
  @HostListener('mouseout') mouseout(){
    this.toggle();
    this.el.nativeElement.setAttribute('src', this.cadena);
  }

  toggle(){
    if(this.cadena === "../../../assets/Angular.png"){
      this.cadena = "../../../assets/Vue.png"
    }
    else{
      this.cadena = "../../../assets/Angular.png"
    }
  }
}
