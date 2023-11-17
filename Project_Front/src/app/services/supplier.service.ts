import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";

@Injectable({
  providedIn: "root",
})
export class SupplierService {
  readonly API_URL = "http://192.168.33.10:8089";

  constructor(private httpClient: HttpClient) {}
  getAllSupplier() {
    return this.httpClient.get(`${this.API_URL}/supplier`);
  }
  addSupplier(supplier: any) {
    return this.httpClient.post(`${this.API_URL}/supplier`, supplier);
  }
}
