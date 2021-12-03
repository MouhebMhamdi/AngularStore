import { Injectable } from '@angular/core';
import {environment} from "../../../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {catchError} from "rxjs/operators";
import {Observable, throwError} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  url = "http://localhost:8081/SpringMVC/produit/"
  constructor(private http: HttpClient) {
  }
  getAllProducts() : Observable<any> {
    return this.http.get(this.url + 'getAllProduits');
  }
}
