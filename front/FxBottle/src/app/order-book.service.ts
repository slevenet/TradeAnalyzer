import { Injectable } from '@angular/core';
import {OrderBookChart} from "./order-book-chart";
import {OrderBookCharts} from "./mock-test";
import {Observable, of} from "rxjs";
import {MessageService} from "./message.service";

@Injectable({
  providedIn: 'root'
})
export class OrderBookService {

  getOrderBook(): Observable<OrderBookChart[]>{
    this.messageService.add('MessageService: teeest');
    return of(OrderBookCharts);
  }

  constructor(private messageService: MessageService) { }
}
