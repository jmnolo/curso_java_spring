function encriptar(valor) {
    var splitString= valor.split(""); // Desglosa en un array caracter a caracter.
    var reverseArray= splitString.reverse(); // Revertimos el array.
    var joinArray= reverseArray.join(""); //Junta los caracteres.
    //return joinArray;
    joinArray = "K7"+joinArray+"Up";
    
    md5(/*valor*/joinArray);
    var hash = md5.create();
    hash.update(joinArray);
    return hash.hex();
}
function antesDeEnviar(){ // Antes de enviarse los datos se encripta:
    var passwd = document.getElementById("password").value; // Cogemos el valor de password
    document.getElementById("password_encrip").value = encriptar(passwd); // Y lo pasamos como valor encriptado.
    document.getElementById("password").value = ""; // password iría vacío y en el doPost del controlador hay que asignar el pasword_encrip.
}

var form1 = document.getElementById("form1");
form1.addEventListener("submit", antesDeEnviar); // Cuando se envíe el formulario, se llame a la función antesDeEnviar.
// Función CALLBACK.  (No ordenamos la ejecución, en este caso se encarga el navegador).
// Pasamos la referencia de la función antesDeEnviar, no el valor devuelto.
// La función la ejecuta el navegador, cuando se pulse "submit".