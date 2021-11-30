import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";

import {Router} from "@angular/router";
import { ToastrService } from 'ngx-toastr';
import {AuthentificationService} from '../../core/service/authentification.service';

import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Users } from '../../core/model/Users';
import { UserService } from '../../core/service/user.service';
import { ResetPasswordService } from '../../core/service/reset-password.service';
import { Observable, of } from 'rxjs';
import { filter, finalize } from 'rxjs/operators';
import { NgxSpinnerService } from "ngx-spinner";

import {BehaviorSubject} from "rxjs";
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  user:Users = new Users();
  public curUser= new BehaviorSubject(this.user);

  sharedUser = this.curUser.asObservable();
  users:Users;
  selectedFile: File;
  successMessage:string;
  loginSuccess:boolean=false;
  invalidLogin:boolean=false;
  errorMessage:string="invalid credentials";

  myForm: FormGroup;
  myForm1: FormGroup;
  myFormReset:FormGroup;
  msg: string;
  loading$: Observable<boolean> = of(false);
  loading = false
  constructor(private spinner: NgxSpinnerService,private resetPasswordService:ResetPasswordService,private userService:UserService,private authService:AuthentificationService, /*private data: SharedDataService,*/ private router:Router, private f: FormBuilder,private toastr: ToastrService,private modalService: NgbModal)  { }
  
  
  ngOnInit(): void {
   
    this.users=new Users();
      if(localStorage.getItem('email')!=null){
        this.router.navigate([('/')])
      }
    this.myForm= new FormGroup({
      'email': new FormControl('',[Validators.required,
        Validators.pattern("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$")]),
      'password': new FormControl('', Validators.required),
      'address': new FormGroup({
        'street number': new FormControl(),
        

      })
    });
    this.myFormReset=new FormGroup({
      'email':new FormControl('')
    })
    this.myForm1= new FormGroup({
      'email': new FormControl(''),
      'password': new FormControl(''),
      'nom':new FormControl(''),
      'prenom':new FormControl(''),
      'dateNaissance':new FormControl(''),
      'picture':new FormControl(''),
      'job':new FormControl(''),
      'profession':new FormControl('')

    })
  }
  tab:any=[];
  roles:any=[];
  public onFileChanged(event:any) {
    //Select File
    this.selectedFile = event.target.files[0];
  }
  sendEmail(){
    this.loading = true
    this.resetPasswordService.sendEmail(this.users.email).pipe(
      finalize(() => this.loading = false)
    ).subscribe((res)=>{
    this.tab=res;

    localStorage.setItem("resetToken",this.tab["token"]);
      this.toastr.success('Verify your email !!', 'Reset password Notification')
      
    },
      ()=>this.toastr.error('Error !!', 'Reset password Notification')
    )
  }

  verifToken(){
    this.resetPasswordService.VerifToken(String(localStorage.getItem("resetToken"))).subscribe((res)=>{
        localStorage.setItem("token","valid");
    },()=>{this.toastr.error('Token invalid !!', 'Token Notification')
      localStorage.getItem("token");
    }
    )
  }
verifUserRoleConncet(email:string){
 
  
      this.authService.getUserConnect(String(email))
      
      .subscribe(user =>{
      alert('hi')
       console.log(user+"ezeeze") 
       /*
      this.tab=user;
      this.roles=this.tab["roles"];
      localStorage.setItem("nom",this.tab["nom"])
      localStorage.setItem("prenom",this.tab["prenom"])
     */
      this.router.navigate(["/"]);
  }
  )
}
  login(myForm:FormGroup){
    this.authService.login(myForm.controls['email'].value,myForm.controls['password'].value).subscribe((user )=>{
      this.tab=user;
      this.successMessage="Login Successful";
      
      this.verifUserRoleConncet(myForm.controls['email'].value);
      this.curUser.next(this.tab);
      this.router.navigate(["/"]);

    },()=>{
      this.msg = 'please give a valid account';
    }
    )
  }
addUser(){

  console.log(this.users);
  this.userService.addUser(this.users).subscribe(
    ()=>this.addRoleToUser()
    
    ,
    ()=>this.toastr.error('Register invalid!!', 'User Notification')
  
  )

  
}
  addRoleToUser(){
    this.userService.addRoleTOUser(this.users.email,'user').subscribe(
      ()=>this.toastr.success('Signup Don !! !!', 'User Notification')
      ,
      ()=>this.toastr.error('Error !!', 'Role Notification')
      )
  }
  /*
  save(){
    //traitement
    this.user.accountCategory='Customer';
    this.data.list.push(this.user)
    this.router.navigate(['/user'])
  }
*/

  openVerticallyCentered(content:any) {
    this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title', windowClass : "myCustomModalClass"}).result.then((result) => {
     // this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      
    });
  }

}
