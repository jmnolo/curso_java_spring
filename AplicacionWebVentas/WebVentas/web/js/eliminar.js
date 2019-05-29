var alPulsarEliminar = function () {
    antesDeEnviar();
    var nombre = document.getElementById("nombre").value;
    var email = document.getElementById("email").value;
    var password = document.getElementById("password_encrip").value;
    var edad = document.getElementById("edad").value;
    var activo = document.getElementById("activo").checked;
    activo = activo ? "on" : "off";
    var cliente = {
        "nombre": nombre,
        email: email,
        'edad': edad
    };
    cliente.password = password;
    cliente["activo"] = activo;
    
    // PARA UTILIZAR EL MÉTODO PUT (Por ejemplo para eliminar):
    var json = JSON.stringify(cliente);
    alert("Enviando...\n" + json);
    console.log(json); 
    
    var xhr = new XMLHttpRequest();
    xhr.open("PUT", "clienteDelete.do", true);
    xhr.setRequestHeader("Content-type",
            "application/json;charset=utf-8");
    xhr.onload = function() {
        var users = JSON.parse(xhr.responseText);
        if(xhr.readyState===4 && xhr.status === "200") {
            alert("Email recibido:  " + email);
            console.table(users);
        } else {
            alert("Email NO recibido:  " + email);
            console.error(users);
        }
    };
    xhr.send(json);
};
// document.getElementById("btn_modificar").addEventListener("click", alPulsarModificar );
document.getElementById("btn_modificar").onclick = alPulsarEliminar;