import { Component, OnInit } from '@angular/core';
import {FormGroup, FormBuilder, Validators} from '@angular/forms';

import { ToastrService } from 'ngx-toastr';
import { finalize } from 'rxjs/operators';
import { contactUs } from '../core/model/contactUs';
import { ContactUsService } from '../core/service/contact-us.service';
@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']
})
export class ContactComponent implements OnInit {
  data={
    "nom":String,
    "subject":String,
    "email":String,
    'msg':String
  }
  form: FormGroup;
  contactUs:contactUs;
  submitted = false;
  loading = false;
  constructor(private formBuilder: FormBuilder,private contactUsService: ContactUsService,private toastr: ToastrService ) { }

  ngOnInit(): void {
    this.contactUs=new contactUs();
    this.form = this.formBuilder.group(
      {
        name: ['',[
          Validators.required,
          Validators.minLength(6),
          Validators.maxLength(20)]
        ],
        subject: ['', [
          Validators.required,
          Validators.minLength(6)]
        ],
        email: ['', [
          Validators.required,
          Validators.email]
        ],
        phone: ['', [
          Validators.required,
          Validators.pattern("^[0-9]*$")
        ]
        ],
        message: ['', [
          Validators.required,
        ]
        ]
      },
      {
      }
    );
  }

  onSubmit(): void {
    this.submitted = true;

    if (this.form.invalid) {
      return;
    }

 
      

    
    this.loading = true;
    console.log(this.contactUs)
  
   this.contactUsService.sendEmailContacUs(this.contactUs).pipe(
    finalize(() => this.loading = false)
  ).subscribe((res)=> {
    this.toastr.success("Your email has been sent, Thanks","Email Notification")

   }),()=>this.toastr.error('Error, please try another time thank you !!',"Email notification");

    console.log(JSON.stringify(this.form.value, null, 2));
  }

  onReset(): void {
    this.submitted = false;
    this.form.reset();
  }
}

