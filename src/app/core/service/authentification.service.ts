import { HttpClient,HttpErrorResponse,HttpResponse,HttpHeaders  } from '@angular/common/http';
import { catchError } from 'rxjs/operators';

import { throwError } from 'rxjs'; 
import {BehaviorSubject} from "rxjs";
import { Injectable } from '@angular/core';
import { map } from 'rxjs/operators';
import { environment } from 'src/environments/environment';
import { Users } from '../model/Users';


@Injectable({
  providedIn: 'root'
})
export class AuthentificationService {
  url=environment.hostUrl;
  public email:string;
  public password:string;
  user:Users = new Users();
  public curUser= new BehaviorSubject(this.user);
  sharedUser = this.curUser.asObservable();
  tab:any=[]
  constructor(private http:HttpClient) { }

  login(email: string, password: string) {

    return this.http.get(this.url+'/user/login?email='+email+"&password="+password,
      { headers: { authorization: this.createBasicAuthToken(email, password) } }).pipe(map((res) => {
        this.email = email;
        this.password = password;
         this.tab=res;
         
         this.tab.roles.forEach((element:any) => {
           
          if(element.role!="USER") throw new Error("Not a User");
          ;
        });
        
        localStorage.setItem("data",this.tab['idClient']);
        
       this.curUser.next(this.tab);
        this.registerSuccessfulLogin(email, password);  

      }));
  }

  addUser(user:any){
    return this.http.post(this.url+'/api/user/registerUser',{responseType: 'text'},user)

  }
  private getServerErrorMessage(error: HttpErrorResponse): string {
    switch (error.status) {
        case 404: {
            return `Not Found: ${error.message}`;
        }
        case 403: {
            return `Access Denied: ${error.message}`;
        }
        case 500: {
            return `Internal Server Error: ${error.message}`;
        }
        default: {
            return `Unknown Server Error: ${error.message}`;
        }

    }
}
   getUserConnect(email: string) {
    console.log(email+" ")
    return this.http.get(this.url+'/user/getUserByEmail/'+email).pipe(map(data => {
      this.tab=data;
      this.curUser.next(this.tab);
    }))
  }

  createBasicAuthToken(email: string, password: string) {
    return 'Basic ' + window.btoa(email + ":" + password);
  }

  registerSuccessfulLogin(email:string, password:string) {
    // save the username to session
    sessionStorage.setItem("email",email);
    sessionStorage.setItem("password",password);
    localStorage.setItem("email",email)

  }

 

  isUserLoggedIn() {
    let user = sessionStorage.getItem('email')
    console.log(!(user === null))
    return !(user === null)
  }

  logOut() {
    
    localStorage.removeItem('email');
    sessionStorage.removeItem('email');
    sessionStorage.clear();
    localStorage.clear();
    this.curUser.lift;

    
  }

}
