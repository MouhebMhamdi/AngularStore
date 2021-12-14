import { HttpClient,HttpErrorResponse,HttpEvent,HttpRequest   } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { BehaviorSubject, Observable, throwError } from 'rxjs';


import { catchError, map } from 'rxjs/operators';
import { environment } from 'src/environments/environment';
import { Users } from '../../core/model/Users';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  url=environment.hostUrl;
  user:Users = new Users();
  tab:any=[];
  public curUser= new BehaviorSubject(this.user);
  sharedUser = this.curUser.asObservable();

  constructor(private http:HttpClient) { }

  addUser(data:Users){
    return this.http.post(this.url+'/user/registerUser/',data,{responseType: 'text'}).pipe(

      catchError(error => {
            let errorMsg: string;
            if (error.error instanceof ErrorEvent) {
                errorMsg = 'Error: ${error.error.message}';
            } else {
                errorMsg = this.getServerErrorMessage(error);
            }

            return throwError(errorMsg);
        })
    );

  }

  UploadImage(file: File , id : any): Observable<HttpEvent<any>> {
    const formData: FormData = new FormData();

    formData.append('file', file);

    const req = new HttpRequest('POST',this.url+"/user/addImgToUser/"+id, formData, {
      reportProgress: true,
      responseType: 'json'
    });

    return this.http.request(req);
  }
  updateUser(data:Users,id:string){
    return this.http.post(this.url+'/user/updateUser/'+id,data,{ observe: 'response' }).pipe(map((res) => {
      this.tab=res;
      this.curUser.next(this.tab);
    }));
  }
  addRoleTOUser(email:string,role:string){
    return this.http.get(this.url+'/user/addRoleToUser/'+email+'/'+role,{responseType: 'text'}).pipe(

      catchError(error => {
            let errorMsg: string;
            if (error.error instanceof ErrorEvent) {
                errorMsg = 'Error: ${error.error.message}';
            } else {
                errorMsg = this.getServerErrorMessage(error);
            }

            return throwError(errorMsg);
        })
    );

  }

  async getUserConnect(email: string) {
    console.log(email+" ")
     return await this.http.get(this.url+'/user/getUserByEmail/'+email).pipe(map((res) => {
      this.tab=res;
      console.log(this.tab)
      this.curUser.next(this.tab);

    }));
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


}
