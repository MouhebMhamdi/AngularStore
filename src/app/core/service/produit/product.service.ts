import { Injectable } from '@angular/core';
import {environment} from "../../../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {catchError} from "rxjs/operators";
import {Observable, throwError} from "rxjs";
import {Product} from "../../model/product";

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  url = "http://localhost:8080/api/produit/"
  constructor(private http: HttpClient) {
  }
  getAllProducts() : Observable<Product[]> {
    return this.http.get<Product[]>(this.url + 'getAllProduits');
  }

  getProduct(id: number): Observable<Product> {
    return this.http.get<Product>(this.url+'getProduit/'+id);
  }


}
