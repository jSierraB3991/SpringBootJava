import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import {environment} from '../environments/environment';
import {NgHcaptchaModule} from 'ng-hcaptcha';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    NgHcaptchaModule.forRoot({
      siteKey: environment.SITE_KEY
    }),
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
