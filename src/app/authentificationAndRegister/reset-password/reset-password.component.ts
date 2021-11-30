import { Component, OnInit } from '@angular/core';

import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ToastrService } from 'ngx-toastr';
import { finalize } from 'rxjs/operators';
import { Users } from '../../core/model/Users';
import { ResetPasswordService } from '../../core/service/reset-password.service';
@Component({
  selector: 'app-reset-password',
  templateUrl: './reset-password.component.html',
  styleUrls: ['./reset-password.component.css']
})
export class ResetPasswordComponent implements OnInit {
  loading = false
  users:Users;
  myFormReset:FormGroup;
  constructor(private modalService: NgbModal,private resetPasswordService:ResetPasswordService,
    private toastr: ToastrService,private router:Router) { }

  ngOnInit(): void {
    this.verifToken();
    this.users=new Users();
    this.myFormReset=new FormGroup({
      'password':new FormControl('')
    })
  }
  newPassword(){
    this.loading = true
    this.resetPasswordService.changePassword(String(localStorage.getItem("resetToken")),this.users.password).pipe(
      finalize(() => this.loading = false)
    ).subscribe(
      ()=>this.router.navigate(['/login'])
    ,()=>this.toastr.error('Error !!', 'Reset password Notification')
    )
  }
  verifToken(){
    this.resetPasswordService.VerifToken(String(localStorage.getItem("resetToken"))).subscribe((res)=>{
        
    },()=>this.router.navigate(['/login'])
    )
  }
  openVerticallyCentered(content:any) {
    this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title',centered: true}).result.then((result) => {
     // this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      
    });
  }
}
