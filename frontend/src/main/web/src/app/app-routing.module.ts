import { PageNotFoundComponent } from './page-not-found/page-not-found.component';

import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EmployeeComponent } from './employee/employee.component';
import { DepartmentComponent } from './department/department.component';
import { DepartmentListComponent } from './department-list/department-list.component';
import { DepartmentDetailsComponent } from './department-details/department-details.component';

const routes: Routes = [
    { path: '', redirectTo: '/employees', pathMatch: 'full' },
    { path: 'departmentslist', component: DepartmentListComponent },
    { path: 'departmentslist/:id', component: DepartmentDetailsComponent },
    { path: 'departments', component: DepartmentComponent },
    { path: 'employees', component: EmployeeComponent },
    { path: '**', component: PageNotFoundComponent }
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule { }

export const routingComponent = [DepartmentListComponent, DepartmentComponent, EmployeeComponent, PageNotFoundComponent, DepartmentDetailsComponent];