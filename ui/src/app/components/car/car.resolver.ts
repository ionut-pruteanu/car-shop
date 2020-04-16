import {Injectable} from "@angular/core";
import {ActivatedRoute, ActivatedRouteSnapshot, Resolve} from "@angular/router";
import {CarsService} from "../../service/cars.service";

@Injectable()
export class CartResolver implements Resolve<any> {

  constructor(private route: ActivatedRoute,
              private carService: CarsService) {
  }

  resolve(route: ActivatedRouteSnapshot) {
    let carId = route.params['carId'];

    return this.carService.getCarById(carId);
  }
}
