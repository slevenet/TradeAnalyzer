import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { OrderBookChartComponent } from './order-book-chart/order-book-chart.component';
import {FormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import { AutochartistComponent } from './autochartist/autochartist.component';

@NgModule({
  declarations: [
    AppComponent,
    OrderBookChartComponent,
    HttpClientModule,
    AutochartistComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
