import { Component, OnInit } from '@angular/core';
import { ManegerProductsService } from '../maneger-products.service';
import { Product } from '../models/product.model';
import { FormGroup, FormBuilder } from '@angular/forms';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-maneger-products',
  templateUrl: './maneger-products.component.html',
  styleUrls: ['./maneger-products.component.css']
})
export class ManegerProductsComponent implements OnInit {

  selectedFile: File;
  products: Product[];
  form: FormGroup;
  idProductSelectDelete: string;
  alert: string = '';
  showModalDelete: boolean = false;
  showModal: boolean = false;
  fileReader = new FileReader();

  constructor(
    private productsService: ManegerProductsService,
    private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.getProducts();
    this.form = this.formBuilder.group({
      productId: [null],
      title: [null],
      type: [null],
      description: [null],
      filename: [null],
      height: [null],
      width: [null],
      price: [null],
      rating: [null],
      created: [null]
    });
  }

  getProducts() {
    this.productsService.getAll()
      .subscribe(dados => { this.products = <Product[]>dados });
  }

  onFileChanged(event) {
    this.selectedFile = event.target.files[0];
    this.fileReader.readAsText(this.selectedFile, "UTF-8");
  }

  onUpload(file) {
    this.productsService
      .upload(file)
      .subscribe(response => {
        alert("Products uploaded successful!");
        this.getProducts();
      }, (err: HttpErrorResponse) => {
        err.error.forEach(e => {
          this.alert = this.alert + e
        })
        alert(this.alert);
        this.alert = '';
      });
  }

  onUpdate() {
    this.productsService
      .update(this.form.value)
      .subscribe(response => {
        this.products.push(Object.assign({}, <Product>response));
        this.getProducts();
        alert("Product " + <Product>response.title + " updated successful!");
        this.form.reset();
      }, (err: HttpErrorResponse) => {
        err.error.forEach(e => {
          this.alert = this.alert + e
        })
        alert(this.alert);
        this.alert = '';
      });

    return false;
  }

  onDelete() {
    this.productsService.delete(this.idProductSelectDelete)
      .subscribe();
    alert("Product deleted successful!");
    this.getProducts();
    return false;
  }

  openModalConfirmDelete(id: string) {
    this.idProductSelectDelete = id;
    console.log(this.idProductSelectDelete);
    return true;
  }

  openModalSelectedProduct(productSelected) {
    this.form.controls.productId.setValue(productSelected.productId);
    this.form.controls.title.setValue(productSelected.title);
    this.form.controls.type.setValue(productSelected.type);
    this.form.controls.description.setValue(productSelected.description);
    this.form.controls.filename.setValue(productSelected.filename);
    this.form.controls.height.setValue(productSelected.height);
    this.form.controls.width.setValue(productSelected.width);
    this.form.controls.price.setValue(productSelected.price);
    this.form.controls.rating.setValue(productSelected.rating);
    this.form.controls.created.setValue(productSelected.created);
    return true;
  }

  openModal() {
    return true;
  }

  closeModal() {
    this.form.reset();
    return false;
  }

  // verificaValidTouched(input) {
  //   return !this.form.get(input).valid && this.form.get(input).touched;
  // }
}
