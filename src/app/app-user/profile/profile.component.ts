import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, NgForm } from '@angular/forms';
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

  constructor(private router:Router, private authService:AuthentificationService,private userService:UserService,private toastr: ToastrService) { }

  ngOnInit(): void {
    if(localStorage.getItem('email')==null){
      this.router.navigate([('/')])
    }
    this.verifUserRoleConncet(String(localStorage.getItem("email")))
    this.users=new Users();
      
    this.myForm= new FormGroup({
      'prenom':new FormControl(''),
      'nom':new FormControl(''),
      'dateNaissance':new FormControl(''),
      'tel':new FormControl(''),
      'street':new FormControl(''),
      'city':new FormControl(''),
      'state':new FormControl(''),
      'zip':new FormControl('')
    })
    console.log(this.verifUserRoleConncet(String(localStorage.getItem("email"))))
    this.authService.sharedUser.subscribe(
      (data:Users)=>
      {this.users=data},
      ()=>{},
      ()=>{this.users = new Users()}
    )


   
  }
  verifUserRoleConncet(email:string){
 
  
    this.authService.getUserConnect(String(email)).subscribe(user =>{
    
     console.log(user+"ezeeze") 
   
   
}
)
}
redirect(){
  this.router.navigate(['/']);
}
  updateProfile(){
    this.userService.updateUser(this.users,String(localStorage.getItem('data'))).subscribe((res)=>{
    this.toastr.success('Profile updated thanks !');

    }),()=>this.toastr.error("Error !","Update profile notification");
  }

}
