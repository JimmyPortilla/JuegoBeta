
var tabla_carreras;

const url_personas= 'https://spring-boot-juegobeta.herokuapp.com/getCarrera';


function cargar_materias(){
	fetch(url_personas)
    .then(res => res.json())
    .then((datos) => {
       console.log(datos);
       cont =0;
       tabla_usuarios.innerHTML='';
		for(let valor of datos){
			console.log(valor.nombre);
			cont = cont+1;
            tabla_usuarios.innerHTML += `
            <tr>
                <th scope="row">`+ cont +` </th>
                <td>${valor.idArea}</td>
                <td>${valor.codigoCarrera}</td>
                <td>${valor.nombre}</td>
                <td><button class="btn btn-warning" onclick="editarUsuario('${valor.idArea}', '${valor.codigoCarrera}', '${valor.nombre}')" >Editar</button></td>
                <td>
                <form action="/eliminarUsuario" method="POST">
                    <input type="text" name="id" class="form-control" value="${valor.codigoCarrera}" style="display: none;">
                    <button type="submit" class="btn btn-danger">Eliminar</button>
                </form>
                </td>
            </tr>
            `
		}
    }).catch(err => console.error(err));
}

$(document).ready(function(){
    alert('jajaja');
    tabla_carreras = document.getElementById("tabla_materias");
    cargar_materias();
    
     

});