import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {OrderBookChart} from "./order-book-chart";

const routes: Routes = [
  {path: 'orderbook/:currency', component: OrderBookChart}
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule { }
