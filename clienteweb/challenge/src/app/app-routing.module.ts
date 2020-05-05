import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ManegerProductsComponent } from './products/maneger-products/maneger-products.component';


const routes: Routes = [
  { path: '', component: ManegerProductsComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
