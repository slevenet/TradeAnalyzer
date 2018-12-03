import {OrderBookBucket} from "./OrderBookBucket";

export class OrderBook {
  private instrumentName: string;
  private _time: string;
  private _price: string;
  private _bucketWidth: string;
  private _buckets: OrderBookBucket[];

  constructor(instrumentName: string, time: string, price: string, bucketWidth: string, buckets: OrderBookBucket[]) {
    this.instrumentName = instrumentName;
    this._time = time;
    this._price = price;
    this._bucketWidth = bucketWidth;
    this._buckets = buckets;
  }

  get time(): string {
    return this._time;
  }

  set time(value: string) {
    this._time = value;
  }

  get price(): string {
    return this._price;
  }

  set price(value: string) {
    this._price = value;
  }

  get bucketWidth(): string {
    return this._bucketWidth;
  }

  set bucketWidth(value: string) {
    this._bucketWidth = value;
  }

  get buckets(): OrderBookBucket[] {
    return this._buckets;
  }

  set buckets(value: OrderBookBucket[]) {
    this._buckets = value;
  }
}
