import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ManterVeiculoComponent } from './manter-veiculo/manter-veiculo.component';
import { ListVeiculoComponent } from './list-veiculo/list-veiculo.component';

const routes: Routes = [
  { path: '', component: ListVeiculoComponent },
  { path: 'manter-veiculo', component: ManterVeiculoComponent },
  { path: 'manter-veiculo/:id', component: ManterVeiculoComponent }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
