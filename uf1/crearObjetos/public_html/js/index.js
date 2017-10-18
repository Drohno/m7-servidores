
window.addEventListener("load", function () {
    var p1 = new persona("David", 23, "Roger");
    var p2 = new persona("Roger", 29, "David");
    p1.saludo;
    p2.saludo;
    p1.preguntarEdad;
    p2.responderEdad;
    p1.darGracias;
    p2.responderGracias;
    p2.preguntarEdad;
    p1.responderEdad;
    p2.darGracias;
    p1.responderGracias;
    p1.despedirse;
    p2.despedirse;

}, false);

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