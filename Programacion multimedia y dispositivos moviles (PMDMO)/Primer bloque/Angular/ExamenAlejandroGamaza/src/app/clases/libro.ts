export class Libro {
    titulo:string;
    autor:string;
    isbn:string;
    fecha:Date;

    constructor(titulo:string, autor:string, isbn:string,fecha:Date){
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.fecha = fecha;
    }
}
