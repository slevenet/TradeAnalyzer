import DateTimeFormat = Intl.DateTimeFormat;
import {OrderBook} from "./OrderBook";

export class OrderBookChart {
  instrumentName: string;
  // private _orderBooks: [string, OrderBook];

  constructor(instrumentName: string) {
    this.instrumentName = instrumentName;
  }
}
