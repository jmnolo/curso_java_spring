var alPulsarModificar = function () {
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

    var clienteJSON = JSON.stringify(cliente);// Convertir obj en JSON
    alert("Enviando...\n" + clienteJSON);
    console.log(clienteJSON);

    // ActiveX para IE 7
    var peticionHTTP = new XMLHttpRequest(); // Objeto AJAX
    // ¿Que tiene que hacer al recibir la respuesta?
    peticionHTTP.onreadystatechange = function () {
        // alert("Ha cambiado de estado");
        if (this.readyState === 4 && this.status === 200) {
            // alert("Hemos recibido algo!" + this.responseText);     
            var jsonResp = this.responseText;  // this = peticionHTTP: obtiene el texsto JSON.
            var objResp = JSON.parse(jsonResp); // Deserializar JSON  en un objeto JS
            alert("¿Email recibido?  " + objResp["email"]
                    + " Y el nombre es  " + objResp.nombre);
            
            // http://mialtoweb.es/modificar-html-con-javascript/
            var divInfo = document.getElementById("div_info");
            divInfo.style = "display: block";
            var spanId = document.getElementById("span_id");
            spanId.innerHTML = objResp.id;
            var spanNombre = document.getElementById("span_nombre");
            spanNombre.innerHTML = objResp.nombre;
            var spanEdad = document.getElementById("span_edad");
            spanEdad.innerHTML = objResp.edad;
            var spanEmail = document.getElementById("span_email");
            spanEmail.innerHTML = objResp.email;
            var spanPassword = document.getElementById("span_password");
            spanPassword.innerHTML = objResp.password;
            var spanActivo = document.getElementById("span_activo");
            spanActivo.innerHTML = objResp.activo;
            
        } /*else {
         alert("Aun NO hemos recibido nada!");
         }*/
    };
    // Definimos la petición
    // document.location = "www.otraweb.com";
    peticionHTTP.open("POST", "clientes2.do", true);
    peticionHTTP.setRequestHeader("Content-type",
            "application/x-www-form-urlencoded");
    // lanzamos la petición
    var form1 = document.getElementById("form1");
    var formData = new FormData(form1);
    var cadenaEnvio =
            "nombre=" + encodeURIComponent(document.getElementById("nombre").value)
            + "&email=" + encodeURIComponent(document.getElementById("email").value)
            + "&password_encrip=" + encodeURIComponent(document.getElementById("password_encrip").value)
            + "&activo=" + encodeURIComponent(activo)
            + "&edad=" + encodeURIComponent(document.getElementById("edad").value);

    alert("¿Qué se va a enviar?\n" + cadenaEnvio);
    peticionHTTP.send(cadenaEnvio);
    
    
    /* PARA UTILIZAR EL MÉTODO PUT (Por ejemplo para eliminar):
    var json = JSON.stringify(cliente);
    
    var xhr = new XMLHttpRequest();
    xhr.open("PUT", url+'/12', true);
    xhr.setRequestHeader("Content-type",
            "application/json;charset=utf-8");
    xhr.onload = function() {
        var users = JSON.parse(xhr.responseText);
        if(xhr.readyState===4 && xhr.status === "200") {
            console.table(users);
        } else {
            console.error(users);
        }
    };
    xhr.send(json);*/
};
// document.getElementById("btn_modificar").addEventListener("click", alPulsarModificar );
document.getElementById("btn_modificar").onclick = alPulsarModificar;
