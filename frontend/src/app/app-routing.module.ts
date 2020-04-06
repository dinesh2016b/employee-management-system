import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EmployeeDetailsComponent } from './component/employees/employee-details/employee-details.component';
import { EmployeeListComponent } from './component/employees/employee-list/employee-list.component';
import { DepartmentListComponent } from './component/departments/department-list/department-list.component';
import { DepartmentDetailsComponent } from './component/departments/department-details/department-details.component';
import { SalariesComponent } from './component/salaries/salaries.component';
import { LoginComponent } from './component/login/login.component';
import { PageNotFoundComponent } from './component/page-not-found/page-not-found.component';

const routes: Routes = [
    { path: '', redirectTo: '/ems-employees', pathMatch: 'full' },
    { path: 'ems-employees', component: EmployeeListComponent },
    { path: 'ems-employees/:id', component: EmployeeDetailsComponent },
    { path: 'ems-departments', component: DepartmentListComponent },
    { path: 'ems-departments/:id', component: DepartmentDetailsComponent },
    { path: 'ems-salaries', component: SalariesComponent },
    { path: 'ems-login', component: LoginComponent },
    { path: '**', component: PageNotFoundComponent }
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})

export class AppRoutingModule { }

export const RoutingComponent = [LoginComponent, DepartmentListComponent, EmployeeDetailsComponent, EmployeeListComponent, SalariesComponent, PageNotFoundComponent, DepartmentDetailsComponent];