
var tabla_carreras;
var tabla_personas;
var tabla_materias;

const url_personas= 'https://spring-boot-juegobeta.herokuapp.com/getPerson';
const url_carreras= 'https://spring-boot-juegobeta.herokuapp.com/getCarrera';
const url_materias= 'https://spring-boot-juegobeta.herokuapp.com/getMateria';


function cargar_carreras(){
	fetch(url_carreras)
    .then(res => res.json())
    .then((datos) => {
       console.log(datos);
       cont =0;
       tabla_carrera.innerHTML='';
		for(let valor of datos){
			console.log(valor.nombre);
			cont = cont+1;
            tabla_carrera.innerHTML += `
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


function cargar_personas(){
	fetch(url_personas)
    .then(res => res.json())
    .then((datos) => {
       console.log(datos);
       cont =0;
       tabla_personas.innerHTML='';
		for(let valor of datos){
			console.log(valor.nombre);
			cont = cont+1;
            tabla_personas.innerHTML += `
            <tr>
                <th scope="row">`+ cont +` </th>
                <td>${valor.cedula}</td>
                <td>${valor.nombre}</td>
                <td>${valor.apellido}</td>
                <td><button class="btn btn-warning" onclick="editarUsuario('${valor.cedula}', '${valor.nombre}', '${valor.apellido}')" >Editar</button></td>
                <td>
                <form action="/eliminarUsuario" method="POST">
                    <input type="text" name="id" class="form-control" value="${valor.cedula}" style="display: none;">
                    <button type="submit" class="btn btn-danger">Eliminar</button>
                </form>
                </td>
            </tr>
            `
		}
    }).catch(err => console.error(err));
}



function cargar_materias(){
	fetch(url_materias)
    .then(res => res.json())
    .then((datos) => {
       console.log(datos);
       cont =0;
       tabla_materias.innerHTML='';
		for(let valor of datos){
			console.log(valor.nombre);
			cont = cont+1;
            tabla_materias.innerHTML += `
            <tr>
                <th scope="row">`+ cont +` </th>
                <td>${valor.idCarrera}</td>
                <td>${valor.codigoMateria}</td>
                <td>${valor.nombre}</td>
                <td><button class="btn btn-warning" onclick="editarUsuario('${valor.idCarrera}', '${valor.codigoMateria}', '${valor.nombre}')" >Editar</button></td>
                <td>
                    <form action="/deleteMateria" method="POST">
                        <input type="text" name="id" class="form-control" value="${valor.codigoMateria}" style="display: none;">
                        <button type="submit" class="btn btn-danger">Eliminar</button>
                    </form>
                </td>
            </tr>
            `
		}
    }).catch(err => console.error(err));
}




$(document).ready(function(){
    //alert('jajaja');
    tabla_carreras = document.getElementById("tabla_carrera");
    cargar_carreras();
    tabla_personas = document.getElementById("tabla_persona");
    cargar_personas();
    tabla_materias = document.getElementById("tabla_materia");
    cargar_materias();
    
});


function abrirModalMateria(){
    limpiar_camposNotificacion();
    $('#modal_Materia').modal('show');
}

function limpiar_camposNotificacion(){
    document.getElementById("cdMateria","cdCarrera","nombreM").value = "";
}


function nuevoNotificacion(){
    limpiar_camposNotificacion();
    $('#modal_Materia').modal('show');
    var boton = document.getElementById("btnRegistrar");
    boton.innerHTML= 'Registrar';
}