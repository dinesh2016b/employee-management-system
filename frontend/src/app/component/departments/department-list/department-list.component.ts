import { Component, OnInit } from '@angular/core';
import { Departments } from '../../../model/departments';
import { DepartmentService } from '../../../service/department.service';

@Component({
  selector: 'app-department-list',
  templateUrl: './department-list.component.html',
  styleUrls: ['./department-list.component.css']
})

export class DepartmentListComponent implements OnInit {

  departments: Departments[];

  constructor(private departmentService: DepartmentService) { }

  ngOnInit() {
    this.departmentService.findAll().subscribe(data => {
      this.departments = data;
    });
  }

  editDepartment(event) {
    console.log('edit department details');
  }

  removeDepartment(event) {
    console.log(event);
  }
}
