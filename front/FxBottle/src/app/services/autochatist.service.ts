import { Injectable } from '@angular/core';
import {Autochartist} from "../model/autochartist";
import {Observable} from "rxjs";
import {HttpClient, HttpHeaders} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class AutochatistService {

  private restUrl = 'http://localhost:8080/autochartist/EUR_USD'

  constructor(private http: HttpClient) { }

  getPattern(): Observable<Autochartist>{
    return this.http.get<Autochartist>(this.restUrl)
  }
}
