import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginUser } from './models/login_user.model';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginUser! : LoginUser;

  // Formを監視
  loginForm = new FormGroup({
    name: new FormControl(''),
    email: new FormControl(''),
    password: new FormControl(''),
  });

  constructor(
    private router: Router,
    private http: HttpClient
    ) { }

  ngOnInit(): void {
  }

  onSubmit(){
    // Formの値を取得する
    let loginUser: LoginUser = {
      name: String(this.loginForm.value["name"]),
      email: String(this.loginForm.value["email"]),
      password: String(this.loginForm.value["password"])
    }

    console.log(loginUser);

    let url = "api/login";

    this.http.post(url,loginUser)
    .subscribe( 
      {
        next:(res => {
          console.log(res);     
          // home画面へ遷移する
          this.router.navigate(['home']);
          
        }),
        error:(error=>{
          console.log(error);
        })
      }
    );

  }

}
