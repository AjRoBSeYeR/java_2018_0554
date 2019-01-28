
//variables globales
var ulVehiculos;
var vehiculos = [];
var vehiculoSeleccionado;

const ENDPOINT = 'http://localhost:8080/wsrest/api/vehiculo/';


window.addEventListener('load', function(){

    console.info('documento cargado y listo');    
    // console.trace('esto es un trace');
    // console.debug('esto es un debug');
    // console.warn('esto es un waring');
    // console.error('esto es un ERROR');
    
    ulVehiculos = document.getElementById('ulVehiculo');

    refrescarLista();

});


function refrescarLista(){

    console.trace('refrescarLista');
    ulVehiculos.innerHTML = '<li class="list-group-item">Cargando vehiculos....</li>';

    let xhr = new XMLHttpRequest();    
    xhr.onreadystatechange = function(){ 
         if (xhr.readyState == 4 && xhr.status == 200 ){               
            let lis = '';
            vehiculos = JSON.parse(xhr.responseText);
            vehiculos.forEach( (vehiculo, index) => {
                lis += ` <li class="list-group-item">
                            <span class="matricula">${vehiculo.matricula}</span> 
                            <span class="modelo">${vehiculo.modelo}</span>
                            <span class="km"> ${vehiculo.km} KM</span>
                            <a href="#" onclick="eliminar(${vehiculo.id})">Eliminar</a>
                        </li>`;
            });
            ulVehiculos.innerHTML = lis;
         }    
    };
    xhr.open('GET', ENDPOINT );    
    xhr.send();
} // refrescarLista


function eliminar( idVehiculo ){

   
    console.log('click Eliminar %o', idVehiculo );

    if ( confirm('¿Estas Seguro?') ){
        let xhr = new XMLHttpRequest();    
        xhr.onreadystatechange = function(){ 
             if (xhr.readyState == 4) {
                 if ( xhr.status == 200 ){               
                    refrescarLista();
                 }else if ( xhr.status == 409 ){
                    showAlert('CONFLICTO existen multas asociadas', 'warning');
                 }   
             }    
        };
        xhr.open('DELETE', ENDPOINT + idVehiculo );    
        xhr.send();
    }    
    
} // eliminar


function crear(){
    console.log('click crear' );

    let matricula = document.getElementById('matricula').value;

    let jsonCoche = {
        "matricula" : matricula,
        "modelo": "harcodeado",
        "km": 1000000
    };

   let xhr = new XMLHttpRequest();    
   xhr.onreadystatechange = function(){ 
        if (xhr.readyState == 4 ){   
            console.debug(' STATUS ' + xhr.status );
            refrescarLista();
        }    
   };
   xhr.open('POST', ENDPOINT );
   xhr.setRequestHeader("Content-type", "application/json");
   xhr.send( JSON.stringify(jsonCoche) );

};


function showAlert( texto, tipo = 'info' ){

    
   let alertHTML = `<div class="alert alert-${tipo} alert-dismissible fade show" role="alert">
        <p>${texto}</p>
        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
            <span aria-hidden="true">&times;</span>
        </button>
        </div>`;

    document.getElementById('alert').innerHTML = alertHTML;


}// showAlert