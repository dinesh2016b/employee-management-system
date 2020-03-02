import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { DepartmentService } from './../../../service/department.service';
import { Departments } from '../../../model/departments';

@Component({
  selector: 'app-department-details',
  templateUrl: './department-details.component.html',
  styleUrls: ['./department-details.component.css']
})
export class DepartmentDetailsComponent implements OnInit {

  @Input() departments: Departments;
  @Output() departmentsEntry: EventEmitter<any> = new EventEmitter();

  constructor(private route: ActivatedRoute,
    private departmentService: DepartmentService) {
  }

  ngOnInit(): void {
    this.getDepartmentDetails();
  }

  getDepartmentDetails() {
    this.departmentsEntry.emit(this.departments);
    console.log('-------------> DepartmentDetails Id :' + this.route.snapshot.paramMap.get('id'));

    //this.departments = new Departments(this.route.snapshot.paramMap.get('id'), '');
    this.departmentService.findById(this.departments).subscribe(res => {
      console.log('-------> departments.deptNo      ----> ' + this.departments.deptNo);
      console.log('-------> departments.deptName  ----> ' + this.departments.deptName);

    });


    //(departments => this.departments = departments);
    console.log('-------------> DepartmentDetails :' + this.departments);
  }

  goBack() {
    /*
        this.passEntry.emit(this.employee);
    
        this.employeeService.save(this.employee).subscribe(res => {
          console.log('-------> employee.empNo      ----> ' + this.employee.empNo);
          console.log('-------> employee.firstName  ----> ' + this.employee.firstName);
          console.log('-------> employee.lastName   ----> ' + this.employee.lastName);
          console.log('-------> employee.brthDate   ----> ' + this.employee.birthDate);
        });
        this.activeModal.close(this.employee);
      */
  }

  save() {

  }
}
