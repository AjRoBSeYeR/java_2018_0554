import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PruebaComponent } from './components/prueba/prueba.component';
import { HomeComponent } from './components/home/home.component';
import { AboutComponent } from './components/about/about.component';
import { MenuComponent } from './components/menu/menu.component';
import { Error404Component } from './components/error404/error404.component';
import { SaludarComponent } from './components/saludar/saludar.component';

import { PaginaDirectivaComponent } from './components/pagina-directiva/pagina-directiva.component';
import { Directiva1Directive } from './directives/directiva1.directive';
import { CountdownDirective } from './directives/countdown.directive';
import { FlujoComponent } from './components/flujo/flujo.component';
import { PaginaPipeComponent } from './components/pagina-pipe/pagina-pipe.component';

import { MonedaPipe } from './pipes/moneda.pipe';
import { ArraysComponent } from './components/arrays/arrays.component';
import { FiltroOfertaPipe } from './pipes/filtro-oferta.pipe';
import { PaginaArrayComponent } from './components/pagina-array/pagina-array.component';
import { FiltroBuscarPipe } from './pipes/filtro-buscar.pipe';
import { TrimarPipe } from './pipes/trimar.pipe';
import { PaginaComparadorComponent } from './components/pagina-comparador/pagina-comparador.component';
import { FrutaComponent } from './components/fruta/fruta.component';
import { TraductorComponent } from './components/traductor/traductor.component';
import { PaginaServiceComponent } from './components/pagina-service/pagina-service.component';
import { RandomuserPaginaComponent } from './components/randomuser-pagina/randomuser-pagina.component';

@NgModule({
  declarations: [
    AppComponent,
    PruebaComponent,
    HomeComponent,
    AboutComponent,
    MenuComponent,
    Error404Component,
    SaludarComponent,
    PaginaDirectivaComponent,
    Directiva1Directive,
    CountdownDirective,
    FlujoComponent,
    PaginaPipeComponent,
    MonedaPipe,
    ArraysComponent,
    FiltroOfertaPipe,
    PaginaArrayComponent,
    FiltroBuscarPipe,
    TrimarPipe,
    PaginaComparadorComponent,
    FrutaComponent,
    TraductorComponent,
    PaginaServiceComponent,
    RandomuserPaginaComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule, //para usarlo con los serivie
    FormsModule //para usarlo doble binding
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
