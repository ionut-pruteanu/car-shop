import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {CarsComponent} from "./components/cars/cars.component";
import {CarComponent} from "./components/car/car.component";
import {CartResolver} from "./components/car/car.resolver";


const routes: Routes = [
  {path: 'cars', component: CarsComponent},
  {path: 'cars/:carId', component: CarComponent, resolve: {car: CartResolver}},
  {path: '', redirectTo: "/cars", pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
