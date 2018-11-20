import { Component, OnInit } from '@angular/core';
import {OrderBookChart} from "../model/order-book-chart";
import {OrderBookService} from "../services/order-book.service";

@Component({
  selector: 'app-order-book-chart',
  templateUrl: './order-book-chart.component.html',
  styleUrls: ['./order-book-chart.component.css']
})
export class OrderBookChartComponent implements OnInit {
  selectedOrderBookChart:OrderBookChart;
  orderBookCharts: OrderBookChart[];

  constructor(private orderBookService:OrderBookService) { }

  getOrderBooks():void{
    this.orderBookService.getOrderBooks()
      .subscribe(orderbooks => {
        console.log(orderbooks);
        this.orderBookCharts = orderbooks
      })
  }

  ngOnInit() {
    this.getOrderBooks();
  }

  onSelect(orderBookChart: OrderBookChart): void{
    this.selectedOrderBookChart = orderBookChart;
  }

}
