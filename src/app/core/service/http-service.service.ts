import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {catchError} from "rxjs/operators";
const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json'
  })
}
@Injectable({
  providedIn: 'root'
})
export class HttpServiceService {
  url = "http://localhost:8080/";

  constructor(private http: HttpClient) { }

  postRequest(url:string,param:{}){
    return this.http.post(this.url+url,param,httpOptions)

  }
  postRequestWithToken(url:string,param:{}){
    const httpOptionsWithToken = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json',
        'Authorization':'Bearer '+this.getLoginToken()
      })
    };

    // @ts-ignore
    param['userId'] = "1";
    return this.http.post(this.url+url,param,httpOptionsWithToken)

  }







  getLoginToken(){
    return localStorage.getItem("token")
  }
  logout(){
    localStorage.setItem("token","");
  }

}
