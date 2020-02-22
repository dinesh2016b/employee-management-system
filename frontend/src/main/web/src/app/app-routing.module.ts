import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EmployeeComponent } from './component/employee/employee.component';
import { EmployeeListComponent } from './component/employee-list/employee-list.component';
import { DepartmentComponent } from './component/department/department.component';
import { DepartmentListComponent } from './component/department-list/department-list.component';
import { DepartmentDetailsComponent } from './component/department-details/department-details.component';
import { SalariesComponent } from './component/salaries/salaries.component';
import { PageNotFoundComponent } from './component/page-not-found/page-not-found.component';

const routes: Routes = [
    { path: '', redirectTo: '/employees', pathMatch: 'full' },
    { path: 'departmentslist', component: DepartmentListComponent },
    { path: 'departmentslist/:id', component: DepartmentDetailsComponent },
    { path: 'departments', component: DepartmentComponent },
    { path: 'employees', component: EmployeeListComponent },
    { path: 'employees/:id', component: EmployeeComponent },
    { path: 'salaries', component: SalariesComponent },
    { path: '**', component: PageNotFoundComponent }
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})

export class AppRoutingModule { }

export const RoutingComponent = [DepartmentListComponent, DepartmentComponent, EmployeeComponent, EmployeeListComponent, SalariesComponent, PageNotFoundComponent, DepartmentDetailsComponent];