import { BrowserModule } from '@angular/platform-browser';
import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { OrderBookChartComponent } from './order-book-chart/order-book-chart.component';
import {FormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import { AutochartistComponent } from './autochartist/autochartist.component';
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {SharedModule} from "primeng/shared";
import { InputTextModule } from 'primeng/inputtext';
import { ButtonModule } from 'primeng/button';
import { TableModule } from 'primeng/table';
import { DialogModule } from 'primeng/dialog'
import {ChartModule, UIChart} from "primeng/chart";

@NgModule({
  declarations: [
    AppComponent,
    OrderBookChartComponent,
    AutochartistComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule,
    BrowserAnimationsModule,
    SharedModule,
    InputTextModule,
    ButtonModule,
    TableModule,
    DialogModule,
    ChartModule
  ],
  schemas: [ CUSTOM_ELEMENTS_SCHEMA ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
