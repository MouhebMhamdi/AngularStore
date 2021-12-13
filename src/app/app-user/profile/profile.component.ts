import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, NgForm, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { BehaviorSubject } from 'rxjs';
import { Users } from 'src/app/core/model/Users';
import { AuthentificationService } from 'src/app/core/service/authentification.service';
import { UserService } from 'src/app/core/service/user.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
   users: Users;
  myForm: FormGroup;
  submitted = false;
  file:File;
  tab:any=[]
  constructor(private router:Router, private authService:AuthentificationService,private userService:UserService,private toastr: ToastrService) { }

  ngOnInit(): void {
    if(localStorage.getItem('email')==null){
      this.router.navigate([('/')])
    }
    this.verifUserRoleConncet(String(localStorage.getItem("email")))
    this.users=new Users();
      
    this.myForm= new FormGroup({
      'prenom':new FormControl('',Validators.required),
      'nom':new FormControl('',Validators.required),
      'dateNaissance':new FormControl('',Validators.required),
      'tel':new FormControl('',Validators.required),
      'street':new FormControl('',Validators.required),
      'city':new FormControl('',Validators.required),
      'state':new FormControl('',Validators.required),
      'zip':new FormControl('',Validators.required),
      'picture':new FormControl('')
    })
    console.log(this.verifUserRoleConncet(String(localStorage.getItem("email"))))
    this.authService.sharedUser.subscribe(
      (data:Users)=>
      {this.users=data},
      ()=>{},
      ()=>{this.users = new Users()}
    )


   
  }

  onFileSelected(event:any) {
    this.file = event.target.files[0];
  }
  UploadImg(id:any){
    this.userService.UploadImage(this.file,id).subscribe((res)=>{
     
    })
  }
  verifUserRoleConncet(email:string){
    this.authService.getUserConnect(String(email)).subscribe(user =>{})
}
redirect(){
  this.router.navigate(['/']);
}
  updateProfile(){
    this.submitted = true;
    if (this.myForm.invalid) {
     return;
    }
    this.userService.updateUser(this.users,String(localStorage.getItem('data'))).subscribe((res)=>{
    
    this.UploadImg(this.users.idClient);
    this.toastr.success('Profile updated thanks !');

    }),()=>this.toastr.error("Error !","Update profile notification");
  }

}
