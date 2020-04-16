import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {CarsService} from "./service/cars.service";
import {CommonModule} from "@angular/common";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {HttpClientModule} from "@angular/common/http";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {WarehouseService} from "./service/warehouse.service";
import { CarsComponent } from './components/cars/cars.component';
import { CarComponent } from './components/car/car.component';
import {CartResolver} from "./components/car/car.resolver";

@NgModule({
  declarations: [
    AppComponent,

    CarsComponent,

    CarComponent
  ],
  imports: [
    BrowserModule,
    CommonModule,
    BrowserModule,
    BrowserAnimationsModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,

    AppRoutingModule,
  ],
  providers: [
    CartResolver,
    CarsService,

    WarehouseService,

  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
