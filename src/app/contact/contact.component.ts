import { Component, OnInit } from '@angular/core';
import {FormGroup, FormControl, FormBuilder, Validators, AbstractControl} from '@angular/forms';

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']
})
export class ContactComponent implements OnInit {

  form: FormGroup;
  submitted = false;
  constructor(private formBuilder: FormBuilder) { }

  ngOnInit(): void {
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
    console.log(JSON.stringify(this.form.value, null, 2));
  }

  onReset(): void {
    this.submitted = false;
    this.form.reset();
  }
}

