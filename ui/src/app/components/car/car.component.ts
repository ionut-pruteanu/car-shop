import {Component, OnDestroy, OnInit} from '@angular/core';
import {Car} from "../../model/car.model";
import {Warehouse} from "../../model/warehouse.model";
import {ActivatedRoute, Router} from "@angular/router";
import {WarehouseService} from "../../service/warehouse.service";
import {Subscription} from "rxjs";

@Component({
  selector: 'app-car',
  templateUrl: './car.component.html',
  styleUrls: ['./car.component.scss']
})
export class CarComponent implements OnInit, OnDestroy {

  car: Car;
  warehouse: Warehouse;

  private routeSubscription: Subscription;
  private warehouseSubscription: Subscription;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private warehouseService: WarehouseService) { }

  ngOnInit(): void {
    this.routeSubscription = this.route.data.subscribe(data => {
      this.car = data['car'];

      if (!this.car) {
        this.router.navigate(['/cars']);
      }
    });

    let warehouseSubscription = this.warehouseService.getWarehouseById(this.car.warehouseId).subscribe( (warehouse: Warehouse) => {
      this.warehouse = warehouse;
    });
  }

  ngOnDestroy(): void {
    if (this.routeSubscription) this.routeSubscription.unsubscribe();
    if (this.warehouseSubscription) this.warehouseSubscription.unsubscribe();
  }

}
