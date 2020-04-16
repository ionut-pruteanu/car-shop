import {Injectable} from "@angular/core";
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {Warehouse} from "../model/warehouse.model";

@Injectable()
export class WarehouseService {

  private WAREHOUSE_URL = "/rest/v1/warehouse";

  constructor(private http: HttpClient) {
  }

  getWarehouseById(id: number): Observable<Warehouse> {
    return this.http.get<Warehouse>(this.WAREHOUSE_URL + "/" + encodeURIComponent(id))
  }
}
