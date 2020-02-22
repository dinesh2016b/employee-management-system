import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule, RoutingComponent } from './app-routing.module';

import { AppComponent } from './app.component';
import { EmployeeComponent } from './component/employee/employee.component';
import { DepartmentComponent } from './component/department/department.component';
import { EmployeeListComponent } from './component/employee-list/employee-list.component';
import { DepartmentDetailsComponent } from './component/department-details/department-details.component';
import { SalariesComponent } from './component/salaries/salaries.component';
import { PageNotFoundComponent } from './component/page-not-found/page-not-found.component';

import { EmployeeService } from './service/employee.service';
import { DepartmentService } from './service/department.service';
import { SalariesService } from './service/salaries.service';

@NgModule({
    declarations: [
        AppComponent,
        EmployeeComponent,
        DepartmentComponent,
        RoutingComponent,
        PageNotFoundComponent,
        DepartmentDetailsComponent,
        EmployeeListComponent,
        SalariesComponent
    ],
    imports: [
        BrowserModule,
        HttpClientModule,
        AppRoutingModule
    ],
    providers: [EmployeeService, DepartmentService, SalariesService],
    bootstrap: [AppComponent]
})

export class AppModule { 
    
}