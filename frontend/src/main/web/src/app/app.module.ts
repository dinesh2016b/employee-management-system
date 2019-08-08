import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { Routes, RouterModule } from '@angular/router';
import { AppRoutingModule, routingComponent } from './app-routing.module';
import { AppComponent } from './app.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { DepartmentDetailsComponent } from './department-details/department-details.component';

import { EmployeeComponent } from './employee/employee.component';
import { DepartmentComponent } from './department/department.component';
import { EmployeeService } from './service/employee.service';

@NgModule({
    declarations: [
        AppComponent,
        EmployeeComponent,
        DepartmentComponent,
        routingComponent,
        PageNotFoundComponent,
        DepartmentDetailsComponent

    ],
    imports: [
        BrowserModule,
        HttpClientModule,
        AppRoutingModule
    ],
    providers: [EmployeeService],
    bootstrap: [AppComponent]
})
export class AppModule { }
