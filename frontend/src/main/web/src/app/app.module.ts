import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule, RoutingComponent } from './app-routing.module';
import { AppComponent } from './app.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { DepartmentDetailsComponent } from './department-details/department-details.component';
import { EmployeeComponent } from './employee/employee.component';
import { DepartmentComponent } from './department/department.component';
import { EmployeeService } from './service/employee.service';
import { EmployeeListComponent } from './employee-list/employee-list.component';

@NgModule({
    declarations: [
        AppComponent,
        EmployeeComponent,
        DepartmentComponent,
        RoutingComponent,
        PageNotFoundComponent,
        DepartmentDetailsComponent,
        EmployeeListComponent
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
