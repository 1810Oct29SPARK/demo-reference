import { BearList } from "../models/bear-list.model";
import { Bear } from "../models/bear.model";
import { Cave } from "../models/cave.model";
import { BearType } from "../models/bear-type.model";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import {HttpClient } from '@angular/common/http';


@Injectable()
export class BearService {

    // inject HttpClient
    constructor(private httpClient: HttpClient) {}

    public fetchBearInformation(id: number): Observable<Bear> {
        return this.httpClient.get<Bear>(`URL TO YOUR LOCALLY DEPLOYED ENDPOINT/${id}`);
    }

    // get all bears, for real, from our backend. using HttpClient, newer version of HttpModule
  public fetchAllBears(): Observable<BearList> {
    return this.httpClient.get<BearList>('URL TO YOUR LOCALLY DEPLOYED ENDPOINT');
  }
}
