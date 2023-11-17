import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Operator } from '../model/Operator';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: "root",
})
export class OperatorService {
  url: string = "http://localhost:8089/DevOps";
  constructor(private http: HttpClient) {}

  getOperators(): Observable<Operator[]> {
    return this.http.get<Operator[]>(this.url + "/getOperators");
  }

  postOperator(operator: Operator) {
    return this.http.post<Operator>(this.url + "/addOperator", operator);
  }
}
