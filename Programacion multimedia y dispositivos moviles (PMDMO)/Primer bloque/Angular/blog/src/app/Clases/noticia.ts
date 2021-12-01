export class Noticia {

    titulo:string;
    cuerpo:string;
    fecha:Date;

    constructor(titulo:string, cuerpo:string, fecha:Date){
        this.titulo = titulo;
        this.cuerpo = cuerpo;
        this.fecha = fecha;
    }
}
