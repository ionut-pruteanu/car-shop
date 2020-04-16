import {Injectable} from "@angular/core";
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {Car} from "../model/car.model";

@Injectable()
export class CarsService {

  private CARS_URL = "/rest/v1/cars";

  constructor(private http: HttpClient) {
  }

  getAllCars(): Observable<Array<Car>> {
    return this.http.get<Array<Car>>(this.CARS_URL)
  }

  getCarById(id: number): Observable<Car> {
    return this.http.get<Car>(this.CARS_URL + "/" + encodeURIComponent(id))
  }
}
