import {BarDataset} from "./bar-dataset";

export class OrderBookChartData {
  private _labels: string[];
  private _datasets: BarDataset[];

  constructor(labels: string[], datasets: BarDataset) {
    this._labels = labels;
    this._datasets = [datasets];
  }

  get labels(): string[] {
    return this._labels;
  }

  get datasets(): BarDataset[] {
    return this._datasets;
  }

  set labels(value: string[]) {
    this._labels = value;
  }

  set datasets(value: BarDataset[]) {
    this._datasets = value;
  }
}
