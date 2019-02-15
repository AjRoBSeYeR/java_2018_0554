import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-arrays',
  templateUrl: './arrays.component.html',
  styleUrls: ['./arrays.component.scss']
})
export class ArraysComponent implements OnInit {
  frutas:any;
  f_nombres:any[];
  f_precios:any[];
  f_np:any[];
  f_oferta:any[];
  f_no_oferta:any[];
  f_par:any[];
  f_impar:any[];
  total_frutas: number;
  total_frutas_oferta: number;
  f_precios_nombre: any[];
  isOferta: boolean;
  constructor() {
    console.trace("ArraysComponent constructor");

    this.frutas = [
      {
        "nombre": "fresa",
        "oferta": true,
        "precio": 3.59,
        "descuento": 5,
        "imagen": "https://media.mercola.com/assets/images/foodfacts/strawberry-nutrition-facts.jpg",
        "colores": [
          { "nombre": "rojo" , "codigo": "#F00"}
        ]
      },
      {
        "nombre": "pomelo",
        "oferta": false,
        "precio": 7.43,
        "descuento": 7,
        "imagen": "http://frutasfercas.com/wp-content/uploads/2018/03/pomelo-1.jpg",
        "colores": [
          {"nombre": "rojo", "codigo":"#F00"},
          {"nombre": "naranja", "codigo":"#FFA500"},
        ]
      },
      {
        "nombre": "chirimoya",
        "oferta": true,
        "precio": 10,
        "descuento": 0,
        "imagen": "https://media.mercola.com/assets/images/foodfacts/cherimoya-nutrition-facts.jpg",
        "colores": [
          {"nombre": "verde", "codigo":"#0F0"}
        ]
      },
      {
        "nombre": "manzana",
        "oferta": true,
        "precio": 5.59,
        "descuento": 3.5,
        "imagen": "https://www.comenaranjas.com/images/stories/virtuemart/product/manzana-royal.jpg",
        "colores": [
          {"nombre": "verde", "codigo":"#0F0"},
          {"nombre": "rojo", "codigo":"#F00"},
          {"nombre": "amarillo", "codigo":"#FF0"}
        ]
      },
      {
        "nombre": "tamarindo",
        "oferta": true,
        "precio": 13.70,
        "descuento": 3,
        "imagen": "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQTuiEhT2_yFMqcz3TlSGzmwVqrOXJnO1gdlEd5ErYl4ynfte4J",
        "colores": [
          {"nombre": "negro", "codigo":"#000"},
          {"nombre": "verde", "codigo":"#0F0"}
        ]
      }      
    ];

    console.trace("comenzos a mapear");
   // this.f_nombres = this.frutas.map(fruta => {return fruta.nombre});
   this.f_nombres = this.frutas.map((value, index, array) => {
     console.debug('value: '+ value);
     console.debug('index: '+ index);
     console.debug('array: ', array);
     return value.nombre;
    });
    this.f_precios = this.frutas.map(fruta => {return fruta.precio});

    this.f_oferta = this.frutas.filter(f => f.oferta).map(f => {return f.nombre});
    this.f_no_oferta = this.frutas.filter(f => !f.oferta).map(f => {return f.nombre});

    this.f_par = this.frutas.filter((f,i)=> i%2==0).map((f)=> {return f.nombre});

    this.total_frutas = this.frutas.map( f=>f.precio).reduce((p,c)=>{ return p + c }, 0);
    this.total_frutas_oferta = this.frutas.filter(f=>f.oferta).map( f=>f.precio).reduce((p,c)=>{ return p + c }, 0);
  
    this.f_precios_nombre = this.frutas.map( fruta => { 
      return {
        "nombre" : fruta.nombre,
        "precio" : fruta.precio
      };
    });
    
  }


  cambiarOferta( value: boolean){    
    this.isOferta = value;
    console.debug('click cambiarOferta ' + this.isOferta);
  }


   calcularDescuento(fruta:any):number{
      return (fruta.precio - (fruta.precio)*fruta.descuento/100);
   }


  ngOnInit() {
  }

}
