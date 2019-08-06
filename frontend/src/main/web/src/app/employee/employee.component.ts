import { Component, OnInit } from '@angular/core';
import { Employee } from '../model/employee';
import { EmployeeService } from '../service/employee.service';

@Component({
	selector: 'app-employee',
	templateUrl: './employee.component.html',
	styleUrls: ['./employee.component.css']
})

export class EmployeeComponent implements OnInit {

	employees: Employee[];

	constructor(private employeeService: EmployeeService) { }

	ngOnInit() {
		this.employeeService.findAll().subscribe(data => {
			this.employees = data;
		});
	}

}
