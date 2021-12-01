import { Injectable } from '@angular/core';
import { HttpClient,HttpErrorResponse,HttpResponse,HttpHeaders  } from '@angular/common/http';
import { catchError } from 'rxjs/operators';

import { throwError } from 'rxjs'; 
import {BehaviorSubject} from "rxjs";

import { map } from 'rxjs/operators';
import { environment } from 'src/environments/environment';
import { Users } from '../model/Users';
@Injectable({
  providedIn: 'root'
})
export class ContactUsService {
  url=environment.hostUrl;


  constructor(private http:HttpClient) { }


sendEmailContacUs(data:any){
  return this.http.get(this.url+"/user/contactUs?name="+data.name+"&email="+data.email+"&subject="+
  data.subject+"&messages="+data.subject+"&phone="+data.phone,{responseType: "text"} )

}

}
