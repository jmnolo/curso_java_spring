window.onload = function ()
{
    var btn_reg = document.getElementById("btn_registro_ajax");

    var xhr = new XMLHttpRequest();

    btn_reg.onclick = function ()
    {
        var nombre = document.getElementById("nombre").value;
        var edad = document.getElementById("edad").value;
        var email = document.getElementById("email").value;

        if (nombre === "" || edad === "" || email === "")
            alert("Debe ingresar todos los datos.");
        else
            enviarDatosPost(nombre, edad, email);
    };

    function enviarDatosPost(nombre, edad, email)
    {
        xhr.onreadystatechange = prepararRespuestaPost;
        xhr.open("POST", "registro", true);
        xhr.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
        var datosJSON = crearDatosJSON(nombre, edad, email);
        alert(JSON.stringify(datosJSON));
        xhr.send(JSON.stringify(datosJSON));
    }

    function crearDatosJSON(nombre, edad, email)
    {
        var datosJSON = {nombre: nombre, edad: edad, email: email};
        return datosJSON;
    }

    function prepararRespuestaPost()
    {
        if (xhr.readyState === 4)
        {
            if (xhr.status === 200)
            {
                alert(xhr.responseText + " -JSON DEVUELTO- " + xhr.statusText);
                var jsonResp = this.responseText;  // this = peticionHTTP: obtiene el texsto JSON.
                var objResp = JSON.parse(jsonResp); // Deserializar JSON  en un objeto JS
                alert(" El nombre es  " + objResp.nombre);
                
                var divInfo = document.getElementById("div_info");
                divInfo.style = "display: block";
                var spanNombre = document.getElementById("span_nombre");
                spanNombre.innerHTML = objResp.nombre;
                var spanEmail = document.getElementById("span_email");
                spanEmail.innerHTML = objResp.email;
                var spanEdad = document.getElementById("span_edad");
                spanEdad.innerHTML = objResp.edad;
            }
        }
    }
};
document.getElementById("btn_registro_ajax").onclick = onload;