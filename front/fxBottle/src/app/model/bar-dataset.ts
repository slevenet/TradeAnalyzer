export class BarDataset {
  private _label: string;
  private _data: number[];

  constructor(label: string, data: number[]) {
    this._label = label;
    this._data = data;
  }

  get label(): string {
    return this._label;
  }

  get data(): number[] {
    return this._data;
  }

  set label(value: string) {
    this._label = value;
  }

  set data(value: number[]) {
    this._data = value;
  }
}
