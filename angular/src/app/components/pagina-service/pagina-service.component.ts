import { Component, OnInit } from '@angular/core';
import { Fruta } from 'src/app/model/fruta';
import { FrutaService } from 'src/app/providers/fruta.service';

@Component({
  selector: 'app-pagina-service',
  templateUrl: './pagina-service.component.html',
  styleUrls: ['./pagina-service.component.scss']
})
export class PaginaServiceComponent implements OnInit {


  frutas: Fruta[];

  constructor( private frutaService: FrutaService ) {
    console.trace('PaginaServiceComponent constructor');
    this.frutas = [];
   }

  ngOnInit() {
    console.trace('PaginaServiceComponent ngOnInit');

    //Realizar llamada al Servicio
    this.frutaService.getAll().subscribe( json => {//Debemos suscribirnos porque devuelve un Observable
      console.debug("Recibimos datos del JSON: %o", json);
      //TODO mapear
      this.frutas = json.map( f => { //Mapear los datos del JSON a un objeto Fruta
        return new Fruta(f.nombre, f.precio, f.id, f.oferta, f.descuento, f.imagen, 1);
      });
    });

  }

}
