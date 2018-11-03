import { Component, OnInit } from '@angular/core';
import {Autochartist} from "../model/autochartist";
import {AutochatistService} from "../services/autochatist.service";

@Component({
  selector: 'app-autochartist',
  templateUrl: './autochartist.component.html',
  styleUrls: ['./autochartist.component.css']
})
export class AutochartistComponent implements OnInit {
  signal:Autochartist

  constructor(private autochart:AutochatistService) { }

  ngOnInit() {
  }

  getPattern():void{
    this.autochart.getPattern()
      .subscribe(signal => this.signal = signal)
  }
}
