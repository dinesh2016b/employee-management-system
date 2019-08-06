import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { EmployeeComponent } from './employee/employee.component';
import { DepartmentComponent } from './department/department.component';
import { EmployeeService } from './service/employee.service';

@NgModule({
    declarations: [
        AppComponent,
        EmployeeComponent,
        DepartmentComponent
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
