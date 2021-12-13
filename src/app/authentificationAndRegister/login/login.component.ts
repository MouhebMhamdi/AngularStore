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
import Swal from 'sweetalert2'

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
  hideAddUser:boolean=false;
  myFormLogin: FormGroup;
  myForm1: FormGroup;
  myFormReset:FormGroup;
  msg: string;
  msgAdd:string;
  loading$: Observable<boolean> = of(false);
  submitted = false;
  submittedLogin=false;
  hideReset:boolean=false;
  loading = false
  file:File;
  Add:boolean;
  
  constructor(private formBuilder: FormBuilder,private spinner: NgxSpinnerService,private resetPasswordService:ResetPasswordService,private userService:UserService,private authService:AuthentificationService, /*private data: SharedDataService,*/ private router:Router, private f: FormBuilder,private toastr: ToastrService,private modalService: NgbModal)  { }
  
  
  ngOnInit(): void {
   
 
    this.toastr.error('Register invalid!!', 'User Notification')
    this.users=new Users();

      if(localStorage.getItem('email')!=null){
        this.router.navigate([('/')])
      }

    this.myFormLogin=  this.formBuilder.group(
      {
        email: ['',[
          Validators.required,
          Validators.email]
        ],
        password: ['',[
          Validators.required
        ]]

      });
    this.myFormReset=this.formBuilder.group(
      {
        email: ['',[
          Validators.required,
          Validators.email]
          
        ]});

 this.myForm1=this.formBuilder.group({
          nom: ['',[
            Validators.required], Validators.minLength(6),
            Validators.maxLength(20)],

          prenom: ['',[
                Validators.required], Validators.minLength(6),
                Validators.maxLength(20)],

          email: ['',[
                Validators.required,
                Validators.email]],

          password: ['',[
                Validators.required]],

         
          dateNaissance: ['',[
                Validators.required]],

         
        

          profession: ['',[
                Validators.required]],

          genre: ['',[
                  Validators.required]],
    });
     /* 
    this.myForm1= new FormGroup({
      'email': new FormControl('',[Validators.required,Validators.email]),
      'password': new FormControl('',[Validators.required]),
      'nom':new FormControl('',[Validators.required,Validators.minLength(6),Validators.maxLength(20)]),
      'prenom':new FormControl('',[Validators.required,Validators.minLength(6),Validators.maxLength(20)]),
      'dateNaissance':new FormControl('',Validators.required),
      'picture':new FormControl(''),
      
      'profession':new FormControl('',Validators.required )

    })*/
  }
  tab:any=[];
  roles:any=[];
  public onFileChanged(event:any) {
    //Select File
    this.selectedFile = event.target.files[0];
  }
  sendEmail(){
    this.submitted = true;
    if (this.myFormReset.invalid) {
      return;
    }
    this.loading = true
    this.resetPasswordService.sendEmail(this.users.email).pipe(
      finalize(() => this.loading = false)
    ).subscribe((res)=>{
      this.tab=res;
      
      localStorage.setItem("resetToken",this.tab["token"]);
   
      
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
    this.submittedLogin = true;
    if (this.myFormLogin.invalid) {
      return;
    }

    this.authService.login(myForm.controls['email'].value,myForm.controls['password'].value).subscribe((user:any )=>{
      this.tab=user;
     
      this.successMessage="Login Successful";
      
      this.verifUserRoleConncet(myForm.controls['email'].value);
      this.curUser.next(this.tab['nom']);
      console.log(user.data.nom)
      this.router.navigate(["/"]);
      
    },()=>{
      this.msg = 'please give a valid account';
    }
    )
  }

  onFileSelected(event:any) {
    this.file = event.target.files[0];
  }
  UploadImg(id:any){
    this.userService.UploadImage(this.file,id).subscribe((res)=>{})
  }
addUser(){
  
  console.log(this.myForm1.value);
  
  let data:any={
    "prenom":this.myForm1.controls['prenom'].value,
    "email":this.myForm1.controls['email'].value,
    "nom":this.myForm1.controls['nom'].value,
    "dateNaissance":this.myForm1.controls['dateNaissance'].value,
    "password":this.myForm1.controls['password'].value,
    "proffesion":this.myForm1.controls['profession'].value,
    "genre":this.myForm1.controls['genre'].value

    
  }
  
  this.submitted = true;
    if (this.myForm1.invalid) {
     
     return;
    }
  
  
  this.userService.addUser(data).subscribe(
    ()=>this.addRoleToUser() ,
    ()=>{this.msgAdd="You have an error please try again or contact us",this.Add=false},
    ()=>this.msgAdd="your account has been created !! "
  )
  
  
}
  addRoleToUser(){
    this.userService.addRoleTOUser(this.users.email,'user').subscribe(
      ()=>this.Add=true
      ,
      ()=>this.toastr.error('Error !!', 'Role Notification'),
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
openCreateAccount(){
  if(this.hideAddUser==false){
    this.hideAddUser=true;
  }else{
    this.hideAddUser=false;
  }
}
openResetPass(){
  if(this.hideReset==false){
    this.hideReset=true;
  }else{
    this.hideReset=false;
  }
}
  openVerticallyCentered(content:any) {
    this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title', windowClass : "myCustomModalClass"}).result.then((result) => {
     // this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      
    });
  }

}