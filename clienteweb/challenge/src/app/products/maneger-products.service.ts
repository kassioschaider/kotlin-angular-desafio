import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators'
import { Product } from './models/product.model';

@Injectable({
  providedIn: 'root'
})
export class ManegerProductsService {

  private resouceUrl = environment.apiUrl + '/products';
  private httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json; charset=utf-8'
    })
  }

  constructor(private http: HttpClient) { }

  getAll(): Observable<Product> {
    return this.http.get(this.resouceUrl, this.httpOptions);
  }

  get(id: string): Observable<Product> {
    return this.http
      .get(this.resouceUrl + '/' + id, this.httpOptions);
  }

  delete(id: string) {
    return this.http
      .delete(this.resouceUrl + '/' + id, this.httpOptions);
  }

  update(product: Product): Observable<Product> {
    return this.http
      .put(this.resouceUrl + '/' + product.productId, JSON.stringify(product), this.httpOptions);
  }

  upload(products: Product[]) {
    return this.http
      .post(this.resouceUrl + '/', products, this.httpOptions)
      .pipe(catchError(this.handleError));
  }

  private handleError(error: HttpErrorResponse) {
    if (error.error instanceof ErrorEvent) {
      console.error('An error occurred:', error.error.message);
    } else {
      console.error(
        `Backend returned code ${error.status}, ` +
        `body was: ${error.error}`);
      error.error.forEach(element => {
        alert("Invalid JSON");
      });
    }
    return throwError(
      'Something bad happened; please try again later.');
  }
}
