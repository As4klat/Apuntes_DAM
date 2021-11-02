import { Directive, ElementRef, Host, HostListener, Input, Renderer2 } from '@angular/core';

@Directive({
  selector: '[mouseHover]'
})
export class MouseHoverDirective {
  
  cadena1: string;
  @Input('mouseHover') cadena: string;

  constructor(private el: ElementRef, private renderer: Renderer2) {
    let elemento = this.el.nativeElement;
    this.cadena1 = elemento.src;
    this.cadena = elemento.src;
   }
   @HostListener('mouseover') onMouseOver(){
    this.el.nativeElement.setAttribute('src', this.cadena);
    this.el.nativeElement.classList.add('borde');
  }
  @HostListener('mouseout') onMouseOut(){
    this.el.nativeElement.setAttribute('src', this.cadena1);
    this.el.nativeElement.classList.remove('borde');
  }
}
