import { Pipe, PipeTransform } from '@angular/core';
import { forEach } from '@angular/router/src/utils/collection';

@Pipe({
  name: 'filtroOferta'
})
export class FiltroOfertaPipe implements PipeTransform {
  /**
   * Filtro para frutas
   * @param frutas [] array con todas las frutas a filtrar
   * @param isOferta boolean si true, mostrar sólo frutas en oferta
   * @param searchText string cadena de texto a buscar en el nombre de las frutas, 
   *                          caseInsensitive y cualquier coincidencia
   */
  transform( frutas: any[] , isOferta: boolean, searchText?: string ): any[] {
    
    console.trace("FiltroOferta isOferta= %s searchText=%s", isOferta, searchText);
    //Coseguimos el mismo array pero sin que apunte a la misma dirección de memoria
    //No usar aResult = frutas.
    let aResul = frutas.map(f => f);

    //1º Filtrar por oferta
    if ( isOferta ){   
      aResul = aResul.filter( f => f.oferta );
    }

    //2º Filtrar por searchText, si está definido y diferente de vacío
    if ( searchText && searchText !== ' '){
      aResul = aResul.filter( f => f.nombre.includes(searchText));
    }
    return aResul;
  }

}
