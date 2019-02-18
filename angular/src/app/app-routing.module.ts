import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PruebaComponent } from './components/prueba/prueba.component';
import { HomeComponent } from './components/home/home.component';
import { AboutComponent } from './components/about/about.component';
import { Error404Component } from './components/error404/error404.component';
import { SaludarComponent } from './components/saludar/saludar.component';
import { PaginaDirectivaComponent } from './components/pagina-directiva/pagina-directiva.component';
import { FlujoComponent } from './components/flujo/flujo.component';
import { PaginaPipeComponent } from './components/pagina-pipe/pagina-pipe.component';
import { ArraysComponent } from './components/arrays/arrays.component';
import { PaginaArrayComponent } from './components/pagina-array/pagina-array.component';
import { PaginaComparadorComponent } from './components/pagina-comparador/pagina-comparador.component';
import { FrutaComponent } from './components/fruta/fruta.component';
const routes: Routes = [
  { path: 'home', component: HomeComponent  },
  { path: 'about/:repeticiones', component: AboutComponent  },
  { path: 'juego', component: PruebaComponent  },
  { path: '404', component: Error404Component }, 
  { path: 'saludar/:nombre', component: SaludarComponent }, 
  { path: 'directiva', component: PaginaDirectivaComponent }, 
  { path: 'flujo', component: FlujoComponent }, 
  { path: 'pipe', component: PaginaPipeComponent },
  { path: 'array', component: ArraysComponent },
  { path: 'array2', component: PaginaArrayComponent },
  { path: 'comparador', component: PaginaComparadorComponent },
  { path: 'fruta_card', component: FrutaComponent },
  { path: '', pathMatch:'full', redirectTo : 'home'  },
  { path: '**', pathMatch:'full', redirectTo : '404'  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }







