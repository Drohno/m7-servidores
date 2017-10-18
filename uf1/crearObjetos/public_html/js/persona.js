var nombre;
var edad;

function persona(nombre, edad, interpelido){
    this.nombre = nombre;
    this.edad = edad;
    this.interpelido = interpelido;
    var saludo = function(){
        console.log("Hola, me llamo " + this.nombre);
    };
    var preguntarEdad = function(){
        console.log("¿Cuántos años tienes " + this.interpelido + "?");
    };
    var responderEdad = function(){
        console.log("Mi edad es de " + this.edad + "años");
    };
    var darGracias = function(){
        console.log("Gracias");
    };
    var responderGracias = function(){
        console.log("De nada");
    };
    var despedirse = function(){
        console.log("Adiós " + this.interpelido);
    };    
}