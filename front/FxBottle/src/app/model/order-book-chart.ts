import DateTimeFormat = Intl.DateTimeFormat;
import {OrderBook} from "./OrderBook";

export class OrderBookChart {
  private instrumentName: string;
  private orderBooks: [string, OrderBook];


  constructor(instrumentName: string, orderBooks: [string, OrderBook]) {
    this.instrumentName = instrumentName;
    this.orderBooks = orderBooks;
  }

  getInstrumentName(): string {
    return this.instrumentName;
  }

  getOrderBooks(): [string, OrderBook] {
    return this.orderBooks;
  }
}
