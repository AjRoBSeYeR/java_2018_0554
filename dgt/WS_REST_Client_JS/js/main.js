/*
    DOM --> acceder a un objeto por su id.
     -innerHTML --> para enmaquetar/acceder a contenidos, cuando manipulas html.
     -style/classname --> para modificar estilos
     -value--> para los inputs, datos introducidos por el usuario. SOLO PARA INPUTS
     -textContent --> para acceder al texto que tiene una etiqueta.

*/
//variables globales
var ulVehiculos;
var vehiculos = [];
var vehiculoSeleccionado;

const ENDPOINT = 'http://localhost:8080/wsrest/api/vehiculo/';

window.addEventListener('load',function(){
    console.info('documento cargado y listo');
    // resto de llamadas a metodos
    ulVehiculos= document.getElementById('ulVehiculo');

    refrescarLista();
    
});

function  refrescarLista(){
    console.trace('refrescarLista');
    ulVehiculos.innerHTML ='<li class="list-group-item">Cargando vehículos ....</li>';
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange= function(){
        //la lógica de negonio va dentro de la function
        if(xhr.readyState == 4 && xhr.status == 200){
            let lis='';
            vehiculos = JSON.parse(xhr.responseText);
            vehiculos.forEach((el,i) =>{
                lis+=`<li class="list-group-item">
                        <div class="row">
                            <span class="matricula mr-1">${el.matricula}</span> 
                            <span class="modelo mr-1">${el.modelo}</span>
                            <span class="km mr-1">${el.km}KM</span>
                        </div>   
                        <div class="row">    
                            <button type="button" class="btn btn-secondary  m-1" onclick="editar(${i})">Editar</button>
                            <button type="button" class="btn btn-danger  m-1 " onclick="eliminar(${el.id})">Eliminar</button>
                            <button type="button" class="btn btn-warning m-1 " onclick="darBaja(${el.id})">Dar de Baja</button>
                        </div>
                    </li>`
            });
            ulVehiculos.innerHTML =lis;
        }
    };
    xhr.open('GET', ENDPOINT);
    xhr.send();
}

function darBaja(idVehiculo){
    console.debug('click Dar de Baja %o', idVehiculo);
    if(confirm('¿Quiere dar de baja el vehículo?')){
        let xhr = new XMLHttpRequest(); 

        xhr.onreadystatechange = function(){
            switch(xhr.status){
                case 200:
                        showAlert('El coche se ha dado de baja correctamente', 'info');   
                        refrescarLista();
                    break;
                case 404:
                        showAlert('El coche que se quiere dar de baja no existe, seleccione uno del listado','warning');
                    break;
                default:
                    showAlert('Hay problemas técnicos', 'danger');
            }
        };//onreadystatechange
       
   
        xhr.open('PATCH', ENDPOINT + idVehiculo );    
        xhr.send();
    }//confirm
}// darBaja

function eliminar( idVehiculo ){
    console.log('click Eliminar %o', idVehiculo );
    if ( confirm('¿Estas Seguro?') ){
        let xhr = new XMLHttpRequest();    
        xhr.onreadystatechange = function(){ 
            //la lógica de negonio va dentro de la function
             if (xhr.readyState == 4) {
                switch(xhr.status){
                    case 200:
                            showAlert('El coche se ha eliminado correctamente', 'info');              
                            refrescarLista();
                        break;
                    case 409:
                            showAlert('CONFLICTO existen multas asociadas', 'warning');
                        break;
                    default:
                        showAlert('Hay problemas técnicos', 'danger');
                }
             }    
        };
        xhr.open('DELETE', ENDPOINT + idVehiculo );    
        xhr.send();
    }    
} // eliminar

// metodo que rellena el formulario con el coche seleccionado.
function editar(index){
    vehiculoSeleccionado = vehiculos[index];
    document.getElementById('id').value = vehiculoSeleccionado.id;
    document.getElementById('matricula').value = vehiculoSeleccionado.matricula;
    document.getElementById('modelo').value = vehiculoSeleccionado.modelo;
    document.getElementById('km').value = vehiculoSeleccionado.km;
}//editar


//metodo que  envia los cambios
function editarCocheSeleccionado(){
    console.log('click crear');
    //Obtengo los valores del formulario
    let id =  document.getElementById('id').value
    let matricula = document.getElementById('matricula').value;
    let modelo = document.getElementById('modelo').value;
    let km = document.getElementById('km').value;
    //modificar el mensaje
    let aviso="";

    if(!matricula.localeCompare("")){
        matricula = vehiculoSeleccionado.matricula;
        aviso="Se le ha puesto la matricula anterior ya que no la ha definido.";
    }
    if(!modelo.localeCompare("")){
        modelo = vehiculoSeleccionado.modelo;
        aviso="Se le ha puesto el modelo anterior ya que no lo ha definido.";
    }
    if(km<0){
        km = 0;
        aviso="No se aceptan valores negativos, se le ha puesto un 0 por defecto.";
    }
        let jsonCocheE = {
            "matricula" : matricula,
            "modelo" : modelo,
            "km" : km,
            "id" : id
        };
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange= function(){
        if(xhr.readyState == 4){
            switch(xhr.status){
                case 200:
                        showAlert('El coche se ha editado correctamente. '+ aviso , 'info');          
                        refrescarLista();
                        document.getElementById('id').value ="";
                        document.getElementById('matricula').value="";
                        document.getElementById('modelo').value="";
                        document.getElementById('km').value="";
                    break;
                case 404:
                        showAlert('El coche que se ha intentado editar no existe', 'warning');
                    break;
                case 409:
                        showAlert('La matrícula nueva que ha introducido ya la tiene otro coche, introduzca una difernete', 'warning');
                    break;
                default:
                    showAlert('Hay problemas técnicos', 'danger');
            }
        }
    }
    xhr.open('PUT',ENDPOINT + id);
    xhr.setRequestHeader("Content-type", "application/json");
    xhr.send( JSON.stringify(jsonCocheE) );

}//editarCocheSeleccionado

function crear(){
    console.log('click crear');

    let matricula = document.getElementById('matricula').value;
    let modelo = document.getElementById('modelo').value;
    let km = document.getElementById('km').value;

    let jsonCoche = {
        "matricula" : matricula,
        "modelo" : modelo,
        "km" : km
    };
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange= function(){
        //la lógica de negonio va dentro de la function
        if(xhr.readyState == 4){
            switch(xhr.status){
                case 201:
                        showAlert('El coche se ha creado correctamente, listo para recibir multas', 'info');          
                        refrescarLista();
                    break;
                case 400:
                        //TODO hacer comprobaciones una a una
                        showAlert('CONFLICTO Los datos no estan bien introducidos', 'danger');
                    break;
                case 409:
                        showAlert('CONFLICTO esa matricula ya existe', 'warning');
                    break;
                default:
                    showAlert('Hay problemas técnicos', 'danger');
            }
        }
    };
    xhr.open('POST', ENDPOINT);
    //El setRequestHeader sirve para decirle que tipo de datos se va a enviar, esto se está definiendo en la cabecera
    //JavaScript no tiene null, se usa undefined
    xhr.setRequestHeader("Content-type", "application/json");
    //a la hora de enviar datos hay que tranformar de json a texto
    // y a la hora de recibir datos hay que transformar de texto a json
    xhr.send( JSON.stringify(jsonCoche) );
}// crear

function showAlert(texto,tipo='info'){
    let alertHTML = `<div class="alert alert-${tipo} alert-dismissible fade show" role="alert">
        <p>${texto}</p>
        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
            <span aria-hidden="true">&times;</span>
        </button>
        </div>`;

    document.getElementById('alert').innerHTML = alertHTML;
}//showAlert
