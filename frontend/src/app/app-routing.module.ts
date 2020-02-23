import { NgModule } from '@angular/core';
import { Departments } from './model/departments';
import { Routes, RouterModule } from '@angular/router';
import { EmployeeDetailsComponent } from './component/employees/employee-details/employee-details.component';
import { EmployeeListComponent } from './component/employees/employee-list/employee-list.component';
import { DepartmentComponent } from './component/departments/department/department.component';
import { DepartmentListComponent } from './component/departments/department-list/department-list.component';
import { DepartmentDetailsComponent } from './component/departments/department-details/department-details.component';
import { SalariesComponent } from './component/salaries/salaries.component';
import { PageNotFoundComponent } from './component/page-not-found/page-not-found.component';

const routes: Routes = [
    { path: '', redirectTo: '/employees', pathMatch: 'full' },
    { path: 'departmentslist', component: DepartmentListComponent },
    { path: 'departmentslist/:id', component: DepartmentDetailsComponent },
    { path: 'departments', component: DepartmentComponent },
    { path: 'employees', component: EmployeeListComponent },
    { path: 'employees/:id', component: EmployeeDetailsComponent },
    { path: 'salaries', component: SalariesComponent },
    { path: '**', component: PageNotFoundComponent }
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})

export class AppRoutingModule { }

export const RoutingComponent = [DepartmentListComponent, DepartmentComponent, EmployeeDetailsComponent, EmployeeListComponent, SalariesComponent, PageNotFoundComponent, DepartmentDetailsComponent];