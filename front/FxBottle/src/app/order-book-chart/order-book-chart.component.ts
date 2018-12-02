import { Component, OnInit } from '@angular/core';
import {OrderBookChart} from "../model/order-book-chart";
import {OrderBookService} from "../services/order-book.service";
import {OrderBookChartData} from "../model/order-book-chart-data";
import {OrderBook} from "../model/OrderBook";
import {BarDataset} from "../model/bar-dataset";

@Component({
  selector: 'app-order-book-chart',
  templateUrl: './order-book-chart.component.html',
  styleUrls: ['./order-book-chart.component.css']
})
export class OrderBookChartComponent implements OnInit {
  selectedOrderBookChart:OrderBookChart;
  orderBookCharts: OrderBookChart[];
  currentChart: OrderBookChartData;

  constructor(private orderBookService:OrderBookService) { }

  getOrderBooks(): void {
    this.orderBookService.getOrderBooks()
      .subscribe(orderbooks => {
        this.orderBookCharts = orderbooks;
      })
  }

  ngOnInit() {
    this.getOrderBooks();
  }

  onSelect(orderBookChart: OrderBookChart): void {
    this.selectedOrderBookChart = orderBookChart;
    this.initChartData();
  }

  private initChartData(): void {
    let book: OrderBook = this.orderBookCharts[0].orderBook;
    for (let i = 0; i < book.buckets.length; i++) {
      if (book.buckets[i].price < book.price)
        continue;

      var start: number = +book.buckets[i-5].price;
      break;
    }

    let labels: string[] = [];
    for (let i = 0; i < 10; i++)
      labels.push((start += (+book.bucketWidth)).toFixed(5).toString());

    let datasets: BarDataset = new BarDataset(book.time, book.buckets.map(x => x.longCountPercent - x.shortCountPercent));
    this.currentChart = new OrderBookChartData(labels, datasets);
    console.log(this.currentChart);
  }
}
