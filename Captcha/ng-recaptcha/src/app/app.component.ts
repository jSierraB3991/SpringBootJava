import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  siteKey: string;
  theme: string;
  
  //info: https://enngage.github.io/ngx-captcha/
  constructor(private readonly httpClient: HttpClient) {
    this.siteKey = environment.Site_Key;
    this.theme = "Dark";
  }
  title = 'ng-recaptcha';

  submit(form: NgForm): void {
    console.log(form.value.captcha);
    this.httpClient.post<CaptchaResponse>(environment.Api +'/inscriptions/form/captcha', {
      token: form.value.captcha
    }).subscribe(
      response => {
        if (response.success) {
          console.log("Sign up successful.");          
        } else {
          console.log(response.errorCodes[0]);
        }
      }
    );
  }

}

export class CaptchaResponse {
  success: boolean;
  errorCodes: Array<string>;
}