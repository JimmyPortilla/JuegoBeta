var tabla_docentes;
var tabla_carreras;
var tabla_personas;
var tabla_materias;
var tabla_preguntas;
var tabla_preguntasMuestra;



var combo_materia;
var combo_carreras;
var combo_area;
var conttabla=0;

const url_preguntas = 'https://spring-boot-juegobeta.herokuapp.com/getPreguntas';
const url_docentes = 'https://spring-boot-juegobeta.herokuapp.com/getDocente';
const url_personas = 'https://spring-boot-juegobeta.herokuapp.com/getPerson';
const url_carreras = 'https://spring-boot-juegobeta.herokuapp.com/getCarrera';
const url_materias = 'https://spring-boot-juegobeta.herokuapp.com/getMateria';
const url_areas = 'https://spring-boot-juegobeta.herokuapp.com/getArea';



/////////////////////////////////////COMOBOS BIMESTRE Y SEMANA/////////////////////////////////////////////////
function selecBimestre(){
    var select_bimestre = document.getElementById("bimestre").value;
    var select_semana =document.getElementById("semana");

    if (select_bimestre == "Primer Bimestre"){
        select_semana.innerHTML = '';
        select_semana.innerHTML += `
        <option >Seleccione Semana</option>
        <option value="Semana 1" >Semana 1</option>
        <option value="Semana 2" >Semana 2</option>
        <option value="Semana 3" >Semana 3</option>
        <option value="Semana 4" >Semana 4</option>
        <option value="Semana 5" >Semana 5</option>
        <option value="Semana 6" >Semana 6</option>
        <option value="Semana 7" >Semana 7</option>
        <option value="Semana 8" >Semana 8</option>        
        `
    }else{
        select_semana.innerHTML = '';
        select_semana.innerHTML += `
        <option >Seleccione semana</option>
        <option value="Semana 9" >Semana 9</option>
        <option value="Semana 10" >Semana 10</option>
        <option value="Semana 11" >Semana 11</option>
        <option value="Semana 12" >Semana 12</option>
        <option value="Semana 13" >Semana 13</option>
        <option value="Semana 14" >Semana 14</option>
        <option value="Semana 15" >Semana 15</option>
        <option value="Semana 16" >Semana 16</option>                           
        `
    }
}

////////////////////////////FUNCIONES PREGUNTAS/////////////////////////////////////////////////

function cargar_preguntas() {	
    var select_materia = document.getElementById("materia").value; 
    fetch(url_preguntas)
        .then(res => res.json())
        .then((datos) => {
            console.log(datos);
            cont = 0;
            contPreg= 0;
            respuestas= 0;
            tabla_preguntasMuestra.innerHTML = '';
            for (let valor of datos) {
                
               
                
                if(select_materia == valor.idMateria){   
                    contPreg =0;
                        
                        cont = cont + 1;
                        tabla_preguntasMuestra.innerHTML += `
                    <tr><th scope="row" colspan="9" style="background-color: #004170; color: white; text-align: center;">` + valor.codigo + ` </th></tr>
                    <tr>
                        <!-- <th scope="row">` + cont + ` </th>    -->
                            
                        `
                        for(let pregunta of valor.preguntas){
                            if(contPreg==0){
                                respuestas = 0;
                            }else{
                                respuestas = contPreg *3;
                            }
                            tabla_preguntasMuestra.innerHTML += `
                             
                            <th >${valor.bimestre} </th>
                            <th >${valor.semana} </th>
                             <td>${pregunta}</td>
                             <td >${valor.respuestas[respuestas]}</td>
                             <td >${valor.respuestas[respuestas+1]}</td>
                             <td >${valor.respuestas[respuestas+2]}</td>
                             <td >${valor.resCorrecta[contPreg]}</td>         
                            `
                            contPreg = contPreg+1;                         
                        }

                }
                
            }            
        }).catch(err => console.error(err));
}
//////////////////////////EDITAR PREGUNTAS//////////////////////////////
/*function editarPreguntas(pregunta,res1,res2,res3,resCorrecta) {
    $('#modal_Preguntas').modal('show');
    document.getElementById("pregunta").value = pregunta;
    document.getElementById("res1").value = res1;
    document.getElementById("res2").value = res2;
    document.getElementById("res3").value = res3;
    document.getElementById("resCorrecta").value = resCorrecta;
    var boton = document.getElementById("btnRegistrar");
    boton.innerHTML = 'Actualizar';
}*/


//////////////////////////////////PREGUARDADO PREGUNTAS////////////////////
function agregarPTabla(){
    
   var pregunta_actual = document.getElementById('preguntaTemp1').value;
   var respuesta_actual = document.getElementById('resTemp1').value;
   var respuesta_actual2 = document.getElementById('resTemp2').value;
   var respuesta_actual3 = document.getElementById('resTemp3').value;
   var opcion_actual = document.getElementById('resCorrectTemp').value;
   var final;

   if(opcion_actual=="1"){
       final =respuesta_actual;

   }
   if(opcion_actual=="2"){
    final =respuesta_actual2;

   }
   if(opcion_actual=="3"){
    final =respuesta_actual3;

   }
    
   document.getElementById('preguntas').value = document.getElementById('preguntas').value + document.getElementById('preguntaTemp1').value +";";

    document.getElementById('respuestas').value = document.getElementById('respuestas').value + document.getElementById('resTemp1').value +";"+ document.getElementById('resTemp2').value +";"+document.getElementById('resTemp3').value +";";

    document.getElementById('resCorrecta').value = document.getElementById('resCorrecta').value + final+";";


    conttabla=conttabla+1;
    
    tabla_preguntas.innerHTML += `
            <tr>
                <th scope="row">` + conttabla + ` </th>
                <td>${pregunta_actual}</td>
                <td>${respuesta_actual}</td>
                <td>${respuesta_actual2}</td>               
                <td>${respuesta_actual3}</td>
                <td>${final}</td>
                
            </tr>
            `
            limpiar_camposPreGuardado();
}

////////////////MODAL PREGUNTAS PREGUARDADO ////////////////////////////////////////////
function editarPreguntaPreguardado(pregunta,res1,res2,res3,resCorrecta) {
    alert("dfghjk");
    $('#modal_PreguntasPreguardado').modal('show');
    document.getElementById("pregunta").value = pregunta;
    document.getElementById("res1").value = res1;
    document.getElementById("res2").value = res2;
    document.getElementById("res3").value = res3;
    document.getElementById("resCorrecta").value = resCorrecta;
    var boton = document.getElementById("btnRegistrar");
    boton.innerHTML = 'Actualizar';
}

function limpiar_camposPreGuardado() {
    document.getElementById("preguntaTemp1").value = "";
    document.getElementById("resTemp1").value = "";
    document.getElementById("resTemp2").value = "";
    document.getElementById("resTemp3").value = "";
}

/*function nuevaPregunta() {
    //limpiar_camposPregunta();
    $('#modal_Preguntas').modal('show');
    //var boton = document.getElementById("btnRegistrar");
}

function modalPregunta() {
    limpiar_camposPregunta();
    $('#modal_Pregunta').modal('show');
}*/










////////////////////////////FUNCIONES DOCENTES/////////////////////////////////////////////////

function cargar_docentes() {
    fetch(url_docentes)
        .then(res => res.json())
        .then((datos) => {
            console.log(datos);
            cont = 0;
            tabla_docentes.innerHTML = '';
            for (let valor of datos) {
                console.log(valor.nombre);
                cont = cont + 1;
                tabla_docentes.innerHTML += `
            <tr>
                <th scope="row">` + cont + ` </th>
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

function modalDocente() {
    limpiar_camposDocente();
    $('#modal_Docente').modal('show');
}

function editarDocente(cedula, nombre, apellido, clave, correoUTPL) {
    $('#modal_Docente').modal('show');
    document.getElementById("cedula").value = cedula;
    document.getElementById("nombre").value = nombre;
    document.getElementById("apellido").value = apellido;
    document.getElementById("clave").value = clave;
    document.getElementById("correoUTPL").value = correoUTPL;
    var boton = document.getElementById("btnRegistrar");
    //document.getElementById ( "cedula" ) .disabled = true;
    boton.innerHTML = 'Actualizar';
}

////////////////////////////FUNCIONES CARRERA////////////////////////////////////////////////
function cargar_carreras() {
    fetch(url_carreras)
        .then(res => res.json())
        .then((datos) => {
            console.log(datos);
            cont = 0;
            tabla_carrera.innerHTML = '';
            for (let valor of datos) {
                console.log(valor.nombre);
                cont = cont + 1;
                tabla_carrera.innerHTML += `
            <tr>
                <th scope="row">` + cont + ` </th>
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
////////////////////////////////////////////////COMBO CARRERAS//////////////////////////////////////////////////////////////////
function cargar_combo_carreras() {

    var select_area = document.getElementById('area').value;
    
    fetch(url_carreras)
        .then(res => res.json())
        .then((datos) => {


            combo_carreras.innerHTML = '<option>Seleccione Carrera</option>';
            for (let valor of datos) {

                if (select_area == valor.idArea) {
                    combo_carreras.innerHTML += `
                    <option value="${valor.codigoCarrera}">${valor.nombre}</option>
                    `
                }
            }
        }).catch(err => console.error(err));
}


function cargar_combo_materia() {

    var select_carrera = document.getElementById('carrera').value;
    
    fetch(url_materias)
        .then(res => res.json())
        .then((datos) => {


            combo_materia.innerHTML = '<option>Seleccione Materia</option>';
            for (let valor of datos) {

                if (select_carrera == valor.idCarrera) {
                    combo_materia.innerHTML += `
                    <option value="${valor.codigoMateria}">${valor.nombre}</option>
                    `
                }
            }
        }).catch(err => console.error(err));
}


/////////////////////////////////////////////////FUNCIONES PERSONAS////////////////////////////////////////////////////////
function cargar_personas() {
    fetch(url_personas)
        .then(res => res.json())
        .then((datos) => {
            console.log(datos);
            cont = 0;
            tabla_personas.innerHTML = '';
            for (let valor of datos) {
                console.log(valor.nombre);
                cont = cont + 1;
                tabla_personas.innerHTML += `
            <tr>
                <th scope="row">` + cont + ` </th>
                <td>${valor.nombre}</td>
                <td>${valor.apellido}</td>
                <td>${valor.correo}</td>
                <td>${valor.password}</td>
                <td><button class="btn btn-warning" onclick="editarUsuario('${valor.nombre}', '${valor.apellido}', '${valor.correo}', '${valor.password}')" >Editar</button></td>
                <td>
                <form action="/eliminarUsuario" method="POST">
                    <input type="text" name="id" class="form-control" value="${valor.correo}" style="display: none;">
                    <button type="submit" class="btn btn-danger">Eliminar</button>
                </form>
                </td>
            </tr>
            `
            }
        }).catch(err => console.error(err));
}

///////////////////////////FUNCIONES MATERIAS////////////////////////////////////////////////////////

function cargar_materias() {
    fetch(url_materias)
        .then(res => res.json())
        .then((datos) => {
            console.log(datos);
            cont = 0;
            tabla_materias.innerHTML = '';
            for (let valor of datos) {
                console.log(valor.nombre);
                cont = cont + 1;
                tabla_materias.innerHTML += `
            <tr>
                <th scope="row">` + cont + ` </th>
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


////////////////////////////////////////COMBO AREAS//////////////////////////

function cargar_areas() {
    fetch(url_areas)
        .then(res => res.json())
        .then((datos) => {
            console.log(datos);

            combo_area.innerHTML = '<option>Seleccione Area</option>';
            for (let valor of datos) {
                console.log(valor.nombre);

                combo_area.innerHTML += `
	            <option value="${valor.codigo}">${valor.nombre}</option>
	            `

            }
        }).catch(err => console.error(err));

}

////////////////////////////CONTROL COMBOS///////////////////////////////////////

function control() {
    cargar_combo_carreras();
}

function controlMateria() {
    cargar_combo_materia();
}

function consultarPreguntas(){
    cargar_preguntas();
}



$(document).ready(function () {

    tabla_docentes = document.getElementById("tabla_docente");
    cargar_docentes();
    tabla_carreras = document.getElementById("tabla_carrera");
    cargar_carreras();
    tabla_personas = document.getElementById("tabla_persona");
    cargar_personas();
    tabla_materias = document.getElementById("tabla_materia");
    cargar_materias();
    tabla_preguntasMuestra = document.getElementById("tabla_preguntasMuestra");
    //cargar_preguntas();

    tabla_preguntas = document.getElementById("tabla_preguntas");

    cargar_areas();


    combo_materia = document.getElementById("materia");
    combo_carreras = document.getElementById("carrera");
    combo_area = document.getElementById("area");


});


function abrirModalMateria() {
    limpiar_camposNotificacion();
    $('#modal_Materia').modal('show');
}



function limpiar_camposNotificacion() {
    document.getElementById("cdMateria").value = "";
    document.getElementById("cdCarrera").value = "";
    document.getElementById("nombreM").value = "";
}

function limpiar_camposDocente() {
    document.getElementById("cedula").value = "";
    document.getElementById("nombre").value = "";
    document.getElementById("apellido").value = "";
    ocument.getElementById("clave").value = "";
    ocument.getElementById("correoUTPL").value = "";
}

function editarMateria(idCarrera, codigoMateria, nombre) {
    $('#modal_Materia').modal('show');
    document.getElementById("cdMateria").value = codigoMateria;
    document.getElementById("cdCarrera").value = idCarrera;
    document.getElementById("nombreM").value = nombre;
    var boton = document.getElementById("btnRegistrar");
    document.getElementById("cdMateria").disabled = true;

    boton.innerHTML = 'Actualizar Materia';
}


function nuevaMateria() {
    limpiar_camposNotificacion();
    $('#modal_Materia').modal('show');
    var boton = document.getElementById("btnRegistrar");
    //document.getElementById ( "cdCarrera" ) .disabled = true;
    boton.innerHTML = 'Registrar';
}