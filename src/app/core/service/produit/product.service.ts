import { Injectable } from '@angular/core';
import {environment} from "../../../../environments/environment";
import {HttpClient,HttpEvent,HttpRequest} from "@angular/common/http";
import {Observable, throwError} from "rxjs";
import {Product} from "../../model/product";

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  url= environment.hostUrl+"/produit/"
  url1= "http://localhost:8080/api/produit/"
  constructor(private http: HttpClient) { }

  getListProduct(){
    return this.http.get<Product[]>(this.url+"getAllProduits");
  }

  addProduct(product:Product){
    return this.http.post(this.url+"addProduit",product)
  }

  deleteProduct(id:number){
    return this.http.delete(this.url+"deleteProduit/"+id)
  }
  updateProduct(product: Product){
    return this.http.put(this.url+"updateProduit/", product)
  }
  UploadImage(file: File , id : any): Observable<HttpEvent<any>> {
    const formData: FormData = new FormData();

    formData.append('file', file);

    const req = new HttpRequest('POST',this.url+"/addImgTopr/"+id, formData, {
      reportProgress: true,
      responseType: 'json'
    });

    return this.http.request(req);
  }

  getProductTitle(criteria: string){}

  getAllProducts() : Observable<Product[]> {
    return this.http.get<Product[]>(this.url1 + 'getAllProduits');
  }

  getProduct(id: number): Observable<Product> {
    return this.http.get<Product>(this.url1+'getProduit/'+id);
  }

}
