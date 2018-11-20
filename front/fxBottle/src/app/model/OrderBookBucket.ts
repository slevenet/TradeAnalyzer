
export class OrderBookBucket {
  private _price: string;
  private _longCountPercent: number;
  private _shortCountPercent: number;

  constructor(price: string, longCountPercent: number, shortCountPercent: number) {
    this._price = price;
    this._longCountPercent = longCountPercent;
    this._shortCountPercent = shortCountPercent;
  }

  get price(): string {
    return this._price;
  }

  set price(value: string) {
    this._price = value;
  }

  get longCountPercent(): number {
    return this._longCountPercent;
  }

  set longCountPercent(value: number) {
    this._longCountPercent = value;
  }

  get shortCountPercent(): number {
    return this._shortCountPercent;
  }

  set shortCountPercent(value: number) {
    this._shortCountPercent = value;
  }
}
