import { Component, OnInit } from '@angular/core';
import { Employee } from '../../../model/employee';
import { EmployeeService } from '../../../service/employee.service';

@Component({
    selector: 'app-employee-list',
    templateUrl: './employee-list.component.html',
    styleUrls: ['./employee-list.component.css']
})

export class EmployeeListComponent implements OnInit {

    employees: Employee[];

    constructor(private employeeService: EmployeeService) { }

    ngOnInit() {
        this.employeeService.findAll().subscribe(data => {
            this.employees = data;
        });
    }

    editEmployee(event) {
        console.log('edit employee details');
    }

    removeEmployee(event) {
        console.log(event);
    }
}