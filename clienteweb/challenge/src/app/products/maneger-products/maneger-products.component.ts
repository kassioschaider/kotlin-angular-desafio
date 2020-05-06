import { Component, OnInit } from '@angular/core';
import { ManegerProductsService } from '../maneger-products.service';
import { Product } from '../models/product.model';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-maneger-products',
  templateUrl: './maneger-products.component.html',
  styleUrls: ['./maneger-products.component.css']
})
export class ManegerProductsComponent implements OnInit {

  form: FormGroup;
  fileReader = new FileReader();
  products: Product[];

  selectedFile: File;
  idProductSelectDelete: string;
  imageFileProductSelected: string = '';
  alert: string = '';

  showModalDelete: boolean = false;
  showModal: boolean = false;
  showProgressBar: boolean = false;

  constructor(
    private productsService: ManegerProductsService,
    private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.getProducts();
    this.form = this.formBuilder.group({
      productId: [null],
      title: [null, [Validators.min(3), Validators.maxLength(50), Validators.required]],
      type: [null, [Validators.min(3), Validators.maxLength(50), Validators.required]],
      description: [null],
      filename: [null],
      height: [null],
      width: [null],
      price: [null, [Validators.required]],
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
    if (!this.selectedFile) {
      alert(this.alert);
      this.alert = '';
      return;
    }

    if (this.selectedFile.type != 'application/json') {
      alert("Please, select a valid file JSON!");
      return;
    }

    this.showProgressBar = true;
    this.productsService.upload(file)
      .subscribe(response => {
        alert("Products uploaded successful!");
        this.getProducts();
        this.showProgressBar = false;
        this.selectedFile = null;
      });
  }

  onUpdate() {
    if (this.validUpdate()) {
      alert(this.alert);
      this.alert = '';
      return true;
    }
    this.productsService.update(this.form.value)
      .subscribe(response => {
        this.products.push(Object.assign({}, <Product>response));
        this.getProducts();
        alert("Product " + <Product>response.title + " updated successful!");
        this.form.reset();
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
    return true;
  }

  openModalSelectedProduct(productSelected) {
    this.form.controls.productId.setValue(productSelected.productId);
    this.form.controls.title.setValue(productSelected.title);
    this.form.controls.type.setValue(productSelected.type);
    this.form.controls.description.setValue(productSelected.description);
    this.form.controls.filename.setValue(productSelected.filename);
    this.imageFileProductSelected = "../../../assets/images/" + productSelected.filename;
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

  validAndTouched(input) {
    return !this.form.get(input).valid && this.form.get(input).touched;
  }

  validUpdate() {
    if (this.validAndTouched('title')) {
      this.alert = this.alert + 'Title can not be empty and must be between 3 and 50 letters. ';
    }
    if (this.validAndTouched('type')) {
      this.alert = this.alert + 'Type can not be empty and must be between 3 and 50 letters. ';
    }
    if (this.validAndTouched('price')) {
      this.alert = this.alert + 'Price can not be empty and must be between 3 and 50 letters. ';
    }

    return this.validAndTouched('title') || this.validAndTouched('type') || this.validAndTouched('price')
  }
}
