import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ManegerProductsComponent } from './maneger-products/maneger-products.component';



@NgModule({
  declarations: [ManegerProductsComponent],
  imports: [CommonModule],
  exports: [ManegerProductsComponent]
})
export class ManegerProductsModule { }
