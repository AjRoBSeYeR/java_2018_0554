import { Component, OnInit } from '@angular/core';
import { validateConfig } from '@angular/router/src/config';
import { Validators } from '@angular/forms';

@Component({
  selector: 'app-flujo',
  templateUrl: './flujo.component.html',
  styleUrls: ['./flujo.component.scss']
})
export class FlujoComponent implements OnInit {
  //declaramos dentro de la clase
  expresion: string;
  ocultar :boolean;
  claseModelo :string;
  formControl :string;
  nombre:string;
 

  constructor() {
    console.trace('FlujoComponent constructor');
    //inicializamos en el constructor
    this.expresion= "Variable inicilizada en el Modelo";
    this.ocultar=true;
    this.claseModelo="text-primary";
    this.formControl="form-control invalid";
    this.nombre="";
  }
  
 
  cambiarClase(claseSeleccionada:string) {
    console.trace("CLICK RADIO "+claseSeleccionada);
    this.claseModelo=claseSeleccionada;
    
  }
  borrar(){
    this.nombre = '';
    this.formControl="form-control invalid";
  }
  
  validar(texto){
    texto = texto.trimLeft();
    texto = texto.trimRight();
    if(texto.length>=3){
      this.formControl="form-control valid";
    }else{}
    
  }
  ngOnInit() {
  }

}
