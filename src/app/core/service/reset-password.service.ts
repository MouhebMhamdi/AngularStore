
import { HttpClient,HttpErrorResponse,HttpResponse,HttpHeaders  } from '@angular/common/http';
import { catchError } from 'rxjs/operators';

import { throwError } from 'rxjs'; 

import { Injectable } from '@angular/core';
import { map } from 'rxjs/operators';
import { environment } from 'src/environments/environment';


@Injectable({
  providedIn: 'root'
})
export class ResetPasswordService {
  url=environment.hostUrl;
  constructor(private http:HttpClient) { }

  sendEmail(email:string){
    return this.http.get(this.url+"/user/send?email="+email);
  }

  VerifToken(token:string){
    return this.http.get(this.url+"/user/newPassword?token="+token,{responseType:'text'})
  }

  changePassword(token:string,password:string){
    return this.http.get(this.url+"/user/changePassword?token="+token+"&password="+password,{responseType:'text'});
  }
}
