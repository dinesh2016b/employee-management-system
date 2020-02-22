import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Employee } from '../../model/employee';
import { EmployeeService } from '../../service/employee.service';

@Component({
    selector: 'app-employee',
    templateUrl: './employee.component.html',
    styleUrls: ['./employee.component.css']
})

export class EmployeeComponent implements OnInit {

    employees: Employee[];

    constructor(private employeeService: EmployeeService, private route: ActivatedRoute) { }

    ngOnInit() {
        // this.id = this.route.snapshot.paramMap.get('id');
        // this.employeeService.findById($this.id).subscribe(data => {
        //    this.employees = data;
        // });

        console.log('employeeComponent.....');

        this.route.params.subscribe(params => {
            const id = params['id'];
            console.log('----> id : ' + id);

            this.employeeService
                .findById(id)
                .subscribe(data => this.employees = data);

            console.log('-----> Employees :' + this.employees);
        
        });

    }

}