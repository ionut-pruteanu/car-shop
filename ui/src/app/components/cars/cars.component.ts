import { Component, OnInit } from '@angular/core';
import {CarsService} from "../../service/cars.service";
import {Car} from "../../model/car.model";
import {Router} from "@angular/router";

@Component({
  selector: 'app-cars',
  templateUrl: './cars.component.html',
  styleUrls: ['./cars.component.scss']
})
export class CarsComponent implements OnInit {

  cars: Array<Car> = [];

  constructor(private router: Router,
              private carsService: CarsService) { }

  ngOnInit(): void {
    this.carsService.getAllCars().subscribe((cars: Array<Car>) => {
      this.cars = cars;
    })
  }

  showCarDetails(carId: number) {
    this.router.navigateByUrl('/cars/'+carId);
  }
}
