import { Component, OnInit } from '@angular/core';
import { Departments } from '../../../model/departments';
import { DepartmentService } from '../../../service/department.service';

@Component({
  selector: 'app-department-list',
  templateUrl: './department-list.component.html',
  styleUrls: ['./department-list.component.css']
})

export class DepartmentListComponent implements OnInit {
  TOKEN_KEY = 'auth-token';
  departments: Departments[];

  constructor(private departmentService: DepartmentService) { }

  ngOnInit() {
    let jwtToken = window.sessionStorage.getItem(this.TOKEN_KEY);
    if (jwtToken == null || jwtToken === '' || jwtToken != undefined) {
      this.departmentService.findAll(jwtToken).subscribe(data => {
        this.departments = data;
        sessionStorage.setItem("departments", JSON.stringify(this.departments));
      });
    }
  }

  editDepartment(event) {
    console.log('edit department details');
  }

  removeDepartment(event) {
    console.log(event);
  }
}
