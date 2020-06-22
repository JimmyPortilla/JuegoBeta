var tabla_docentes;
var tabla_carreras;
var tabla_personas;
var tabla_materias;

var combo_materia;

const url_docentes= 'https://spring-boot-juegobeta.herokuapp.com/getDocente';
const url_personas= 'https://spring-boot-juegobeta.herokuapp.com/getPerson';
const url_carreras= 'https://spring-boot-juegobeta.herokuapp.com/getCarrera';
const url_materias= 'https://spring-boot-juegobeta.herokuapp.com/getMateria';

///////FUNCIONES DOCENTES

function cargar_docentes(){
	fetch(url_docentes)
    .then(res => res.json())
    .then((datos) => {
       console.log(datos);
       cont =0;
       tabla_docentes.innerHTML='';
		for(let valor of datos){
			console.log(valor.nombre);
			cont = cont+1;
			tabla_docentes.innerHTML += `
            <tr>
                <th scope="row">`+ cont +` </th>
                <td>${valor.cedula}</td>
                <td>${valor.nombre}</td>
                <td>${valor.apellido}</td>
                <td>${valor.clave}</td>
                <td>${valor.correoUTPL}</td>
                <td><button class="btn btn-warning" onclick="editarDocente('${valor.cedula}', '${valor.nombre}', '${valor.apellido}', '${valor.clave}', '${valor.correoUTPL}')" >Editar</button></td>
                <td>
                <form action="/deleteDocente" method="POST">
                    <input type="text" name="id" class="form-control" value="${valor.correoUTPL}" style="display: none;">
                    <button type="submit" class="btn btn-danger">Eliminar</button>
                </form>
                </td>
            </tr>
            `
		}
    }).catch(err => console.error(err));
}

function nuevoDocente() {
	limpiar_camposDocente();
	var boton = document.getElementById("btnRegistrar");
}

function modalDocente(){
	 limpiar_camposDocente();
	    $('#modal_Docente').modal('show');
}
function editarDocente(cedula, nombre, apellido,clave,correoUTPL){
	$('#modal_Docente').modal('show');
	document.getElementById("cedula").value = cedula;
   document.getElementById("nombre").value = nombre;
   document.getElementById("apellido").value = apellido;
   document.getElementById("clave").value = clave;
   document.getElementById("correoUTPL").value = correoUTPL;
   var boton = document.getElementById("btnRegistrar");
   //document.getElementById ( "cedula" ) .disabled = true;
   boton.innerHTML= 'Actualizar';
}

////////FUNCIONES CARRERA
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
                <td><button class="btn btn-warning" onclick="editarMateria('${valor.idCarrera}', '${valor.codigoMateria}', '${valor.nombre}')" >Editar</button></td>
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

db.collection("materia").onSnapshot((querySnapshot) => {
    combo_materia.innerHTML='';
    querySnapshot.forEach((doc) => {
        combo_materia.innerHTML += `
        <option>${doc.data().nombre}</option>
        `
    });
});



$(document).ready(function(){
    
	tabla_docentes = document.getElementById("tabla_docente");
    cargar_docentes();
    tabla_carreras = document.getElementById("tabla_carrera");
    cargar_carreras();
    tabla_personas = document.getElementById("tabla_persona");
    cargar_personas();
    tabla_materias = document.getElementById("tabla_materia");
    cargar_materias();
    
    combo_materia = document.getElementById("piso"); 
    
});


function abrirModalMateria(){
    limpiar_camposNotificacion();
    $('#modal_Materia').modal('show');
}



function limpiar_camposNotificacion(){
    document.getElementById("cdMateria").value = "";
    document.getElementById("cdCarrera").value = "";
    document.getElementById("nombreM").value = "";
}

function limpiar_camposDocente(){
    document.getElementById("cedula").value = "";
    document.getElementById("nombre").value = "";
    document.getElementById("apellido").value = "";
    ocument.getElementById("clave").value = "";
    ocument.getElementById("correoUTPL").value = "";
}

function editarMateria(idCarrera, codigoMateria, nombre){
	$('#modal_Materia').modal('show');
	document.getElementById("cdMateria").value = codigoMateria;
    document.getElementById("cdCarrera").value = idCarrera;
    document.getElementById("nombreM").value = nombre;
    var boton = document.getElementById("btnRegistrar");
    document.getElementById ( "cdMateria" ) .disabled = true;
    
    boton.innerHTML= 'Actualizar Materia';
}


function nuevoNotificacion(){
    limpiar_camposNotificacion();
    $('#modal_Materia').modal('show');
    var boton = document.getElementById("btnRegistrar");
    document.getElementById ( "cdCarrera" ) .disabled = true;
    boton.innerHTML= 'Registrar';
}

