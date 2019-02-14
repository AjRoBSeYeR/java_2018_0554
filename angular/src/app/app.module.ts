import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PruebaComponent } from './components/prueba/prueba.component';
import { OtromasComponent } from './components/otromas/otromas.component';
import { HomeComponent } from './components/home/home.component';
import { AboutComponent } from './components/about/about.component';
import { Error404Component } from './components/error404/error404.component';
import { SaludarComponent } from './components/saludar/saludar.component';
import { PaginaDirectivaComponent } from './components/pagina-directiva/pagina-directiva.component';
import { Directiva1Directive } from './directives/directiva1.directive';
import { CountdownDirective } from './directives/countdown.directive';
import { FlujoComponent } from './components/flujo/flujo.component';

@NgModule({
  declarations: [
    AppComponent,
    PruebaComponent,
    OtromasComponent,
    HomeComponent,
    AboutComponent,
    Error404Component,
    SaludarComponent,
    PaginaDirectivaComponent,
    Directiva1Directive,
    CountdownDirective,
    FlujoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule // para poder usar doble binding o banana in a box
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
