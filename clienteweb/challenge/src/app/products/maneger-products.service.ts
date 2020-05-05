import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';
import { Product } from './models/product.model';

@Injectable({
  providedIn: 'root'
})
export class ManegerProductsService {

  private resouceUrl = environment.apiUrl + '/products';
  private httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }

  constructor(private http: HttpClient) { }

  getAll(): Observable<Product> {
    return this.http.get(this.resouceUrl, this.httpOptions);
  }

  get(id: string): Observable<Product> {
    return this.http
      .get(this.resouceUrl + '/' + JSON.stringify(id), this.httpOptions);
  }

  delete(id: string) {
    return this.http
      .delete(this.resouceUrl + '/' + id, this.httpOptions);
  }

  update(product: Product): Observable<Product> {
    return this.http
      .put(this.resouceUrl + '/' + product.productId, JSON.stringify(product), this.httpOptions);
  }
}
