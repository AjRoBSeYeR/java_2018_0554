import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-pagina-comparador',
  templateUrl: './pagina-comparador.component.html',
  styleUrls: ['./pagina-comparador.component.scss']
})
export class PaginaComparadorComponent implements OnInit {

  frutas: any[];
  carrito: any[];
  frutaSelec1: any;
  frutaSelec2: any;

  totalCarro: number;
  totalDescuento: number;

  constructor() {

    this.carrito = [];
    this.totalCarro = 0;
    this.totalDescuento = 0;

    this.frutas =
    [{
        "nombre": "fresa",
        "oferta": true,
        "precio": 3.59,
        "descuento": 5,
        "imagen": "https://libbys.es/wordpress/wp-content/uploads/2018/05/fresas.jpg",
        "colores":  [
          { "nombre": "rojo" , "codigo": "red"}
        ]
      },
      {
        "nombre": "pomelo",
        "oferta": false,
        "precio": 7.43,
        "descuento": 7,
        "imagen": "https://www.comenaranjas.com/images/stories/virtuemart/product/pomelo-star-ruby.jpg",
        "colores":  [
          {"nombre": "rojo", "codigo":"red"},
          {"nombre": "naranja", "codigo":"orange"}
        ]
      },
      {
        "nombre": "chirimoya",
        "oferta": true,
        "precio": 10,
        "descuento": 0,
        "imagen": "https://www.frutadelasarga.com/server/Portal_0008706/img/products/chirimoya_1258331.jpg",
        "colores": [
          { "nombre": "verde" , "codigo": "green"}
        ]
      },
      {
        "nombre": "manzana",
        "oferta": true,
        "precio": 5.59,
        "descuento": 3.5,
        "imagen": "https://t1.uc.ltmcdn.com/images/2/7/4/img_como_evitar_que_la_manzana_se_oxide_5472_600.jpg",
        "colores": [
          {"nombre": "verde", "codigo":"green"},
          {"nombre": "rojo", "codigo":"red"},
          {"nombre": "amarillo", "codigo":"yellow"}
        ]
      },
      {
        "nombre": "tamarindo",
        "oferta": true,
        "precio": 13.7,
        "descuento": 3,
        "imagen": "https://e.rpp-noticias.io/normal/2016/03/30/042804_108586.jpg",
        "colores": [
          {"nombre": "verde", "codigo":"green"},
          {"nombre": "negro", "codigo":"black"}
        ]
      }
    ];

    this.frutaSelec1 = this.frutas[0];
    this.frutaSelec2 = this.frutas[1];

    //this.carrito.push( this.frutas[0]);
   }

  ngOnInit() {
  }

  cambiarFruta(i:number){
    console.log('click cambiarFruta %o', i);
    this.frutaSelec2 = this.frutaSelec1;
    this.frutaSelec1 = this.frutas[i];
  }


  addCarrito(event){

    this.carrito.push(event);

    //calcular totales
    this.totalCarro = this.carrito.map( f=> f.precio ).reduce( (p,c)=>{ return p+c }, 0);
  }

  eliminarCarro( frutaCarro: any ): void{
    console.trace('click eliminar %o', frutaCarro );
    this.carrito = this.carrito.filter( f=> {return f.nombre !== frutaCarro.nombre});

     //calcular totales
    this.totalCarro = this.carrito.map( f=> f.precio ).reduce( (p,c)=>{ return p+c }, 0);
  }

}