import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Users } from 'src/app/core/model/Users';
import { AuthentificationService } from 'src/app/core/service/authentification.service';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {
  user:Users;
  constructor(private router:Router,private athservice:AuthentificationService) { }

  ngOnInit(): void {
    this.user=new Users();
    
    localStorage.removeItem('email');
    sessionStorage.removeItem('email');
    sessionStorage.clear();
    localStorage.clear();
    
    this.router.navigate(['/']);
  }

}
