import {OrderBook} from "./OrderBook";

export class OrderBookChart {
  private _instrumentName: string;
  private _orderBook: OrderBook;

  constructor(instrumentName: string, orderBook: OrderBook) {
    this._instrumentName = instrumentName;
    this._orderBook = orderBook;
  }

  get instrumentName(): string {
    return this._instrumentName;
  }

  get orderBook(): OrderBook {
    return this._orderBook;
  }
}
