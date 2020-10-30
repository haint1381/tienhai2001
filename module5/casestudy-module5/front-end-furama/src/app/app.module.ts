import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateContractComponent } from './contract/create-contract/create-contract.component';
import { ListContractComponent } from './contract/list-contract/list-contract.component';
import { DetailContractComponent } from './contract/detail-contract/detail-contract.component';
import { CreateContractDetailComponent } from './contract-detail/create-contract-detail/create-contract-detail.component';
import { DetailContractDetailComponent } from './contract-detail/detail-contract-detail/detail-contract-detail.component';
import { ListContractDetailComponent } from './contract-detail/list-contract-detail/list-contract-detail.component';
import { ListCustomerComponent } from './customer/list-customer/list-customer.component';
import { DetailCustomerComponent } from './customer/detail-customer/detail-customer.component';
import { CreateCustomerComponent } from './customer/create-customer/create-customer.component';
import { ListEmployeeComponent } from './employee/list-employee/list-employee.component';
import { CreateEmployeeComponent } from './employee/create-employee/create-employee.component';
import { DetailEmployeeComponent } from './employee/detail-employee/detail-employee.component';
import { ListServiceComponent } from './service/list-service/list-service.component';
import { CreateServiceComponent } from './service/create-service/create-service.component';
import { DetailServiceComponent } from './service/detail-service/detail-service.component';
import {CommonComponent} from './common/common.component';
import {HomePageComponent} from './home-page/home-page.component';

@NgModule({
  declarations: [
    AppComponent,
    CommonComponent,
    CreateContractComponent,
    ListContractComponent,
    DetailContractComponent,
    CreateContractDetailComponent,
    DetailContractDetailComponent,
    ListContractDetailComponent,
    ListCustomerComponent,
    DetailCustomerComponent,
    CreateCustomerComponent,
    ListEmployeeComponent,
    CreateEmployeeComponent,
    DetailEmployeeComponent,
    ListServiceComponent,
    CreateServiceComponent,
    DetailServiceComponent,
    CommonComponent,
    HomePageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
