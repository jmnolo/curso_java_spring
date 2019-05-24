/* GPL 3.0 */
"use strict";
console.log("Generando tabla...");
generarTabla();
var lista = new Array();

function generarTabla() {
    var table = document.getElementsByTagName("table");
    table = table[0];
    table.innerHTML = "<caption>Lista de vainas</caption>";

    var nombrePrecio = "precio";
    // += : añade al contenido y no sustituye.
    // TITULOS:
    // Funcionalidad de EcmaScript.
    table.innerHTML += `
<thead>
    <tr><th>Tipo</th>
        <th>Nombre</th>
        <th>${nombrePrecio}</th>
        <th>Stock</th>
    </tr>
</thead>`;
    // ARRAYS: dinámicos y puede mezclar objetos de distinto tipo.
    //var lista = new Array(); Esto es ignorado por la siguiente línea.
    lista = [["Vaina:", "Peine", "15 €", "7"]]; // Creación de Array al igual que la anterior. Puede estar el corchete vacío o no.
    // Array de 2 dimensiones. / Array de arrays.
    lista[1] = ["Vaina:", "Quitapelos", "50 €", "1"];
    lista[2] = ["Vaina:", "Coche", "500 €", "2"];


    // CREACIÓN DE TABLA:
    editarLista(table,lista);
    /*for (var i = 0; i < lista.length; i++) {
        var nodoTR = document.createElement("tr");
        table.appendChild(nodoTR);
        for (var columna of lista[i]) { // Bucle for-each
            var nodoCol = document.createElement("td");
            nodoTR.appendChild(nodoCol);
            var textoCol = document.createTextNode(columna);
            nodoCol.appendChild(textoCol);
        }
    }*/

}

function nuevoProducto() {

    var table = document.getElementsByTagName("table");
    table = table[0];
    // += : añade al contenido y no sustituye.
    // TITULOS:
    table.innerHTML += `
<thead>
    <tr>
    </tr>
</thead>`;
    // ARRAYS: dinámicos y puede mezclar objetos de distinto tipo.
    lista = [["Vaina:", "Peine", "15 €", "7"]]; // Creación de Array al igual que la anterior. Puede estar el corchete vacío o no.
    // Array de 2 dimensiones. / Array de arrays.

    var nombre = document.forms["form1"].elements[0].value;
    var precio = document.forms["form1"].elements[1].value;
    var stock = document.forms["form1"].elements[2].value;
    //var rowCount = table.rows.length+2;
    lista = [["Vaina:", nombre, precio, stock]];

    // EDICIÓN DE TABLA:
    editarLista(table,lista);
    /*for (var i = 0; i < lista.length; i++) {
        var nodoTR = document.createElement("tr");
        table.appendChild(nodoTR);
        for (var columna of lista[i]) { // Bucle for-each
            var nodoCol = document.createElement("td");
            nodoTR.appendChild(nodoCol);
            var textoCol = document.createTextNode(columna);
            nodoCol.appendChild(textoCol);
        }
    }*/
}

function editarLista(table, lista){
    // EDICIÓN DE TABLA:
    for (var i = 0; i < lista.length; i++) {
        var nodoTR = document.createElement("tr");
        table.appendChild(nodoTR);
        for (var columna of lista[i]) { // Bucle for-each
            var nodoCol = document.createElement("td");
            nodoTR.appendChild(nodoCol);
            var textoCol = document.createTextNode(columna);
            nodoCol.appendChild(textoCol);
        }
    }
}

// FUNCIONES PROFESOR:

// Comprobar.
function editLista() {
    var nombre = document.forms["form1"].elements[0].value;
    var precio = document.forms["form1"].elements[1].value;
    var stock = document.forms["form1"].elements[2].value;
    lista.push(["Vaina:", nombre, precio, stock]);
    generarTabla();
}

// Funciona.
function agregarCosaDirectamenteATablaInnerHTML() {
    var table = document.getElementsByTagName("table")[0];
    var tipo = "Vaina:";
    var nombre = document.forms["form1"].elements[0].value;
    var precio = document.forms["form1"].elements[1].value;
    var stock = document.forms["form1"].elements[2].value;
    table.innerHTML +=`<tr><td>${tipo}</td>
        <td>${nombre}</td>
        <td>${precio}</td>
        <td>${stock}</td>
    </tr>`;
}