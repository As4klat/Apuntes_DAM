import { ListaNoticiasComponent } from './Componentes/lista-noticias/lista-noticias.component';
import { LoginComponent } from './Componentes/login/login.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path: '',
    component: LoginComponent
  },
  {
    path: 'noticias',
    component: ListaNoticiasComponent,
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
