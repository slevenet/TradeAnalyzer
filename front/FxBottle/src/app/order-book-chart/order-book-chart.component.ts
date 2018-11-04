import { Component, OnInit } from '@angular/core';
import {OrderBookChart} from "../model/order-book-chart";
import {OrderBookService} from "../services/order-book.service";

@Component({
  selector: 'app-order-book-chart',
  templateUrl: './order-book-chart.component.html',
  styleUrls: ['./order-book-chart.component.css']
})
export class OrderBookChartComponent implements OnInit {
  selectesOrderBookChart:OrderBookChart;
  OrderBookCharts: OrderBookChart[];

  constructor(private orderBookService:OrderBookService) { }

  getOrderBooks():void{
    this.orderBookService.getOrderBooks()
      .subscribe(orderbooks => this.OrderBookCharts = orderbooks)
  }

  ngOnInit() {
    this.getOrderBooks();
  }

  onSelect(orderbookchart: OrderBookChart): void{
    this.selectesOrderBookChart = orderbookchart;
  }

}
