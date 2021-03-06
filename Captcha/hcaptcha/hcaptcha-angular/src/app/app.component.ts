import { Component } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment} from '../environments/environment';
import {NgForm} from '@angular/forms';
import { CaptchaResponse } from './model/CaptchaResponse.model';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  constructor(private readonly httpClient: HttpClient) {
  }

  submit(form: NgForm): void {
    console.log(form.value.captcha);
    this.httpClient.post<CaptchaResponse>(environment.API +'/inscriptions/form/captcha', {
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
