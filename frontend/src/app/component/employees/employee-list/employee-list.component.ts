import { Component, OnInit } from '@angular/core';
import { MatDialog, MatDialogRef } from '@angular/material';

import { Employee } from '../../../model/employee';
import { EmployeeService } from '../../../service/employee.service';
import { EmployeeDetailsComponent } from '../employee-details/employee-details.component';

@Component({
    selector: 'app-employee-list',
    templateUrl: './employee-list.component.html',
    styleUrls: ['./employee-list.component.css']
})

export class EmployeeListComponent implements OnInit {

    employees: Employee[];

    constructor(private dialog: MatDialog, private employeeService: EmployeeService) { }

    ngOnInit() {
        this.employeeService.findAll().subscribe(data => {
            this.employees = data;
        });
    }

    editEmployee(event) {
        console.log('edit employee details');

        this.dialog.open(EmployeeDetailsComponent, {
            data: {
                message: "Error!!!"
            }
        });
    }

    removeEmployee(event) {
        console.log(event);
    }
}