import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {OrderBookChart} from "./model/order-book-chart";

const routes: Routes = [
  {path: 'orderbook', component: OrderBookChart}
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}
