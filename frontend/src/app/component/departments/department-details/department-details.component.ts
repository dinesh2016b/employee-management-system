import { Component, OnInit, Input } from '@angular/core';
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

  constructor(private route: ActivatedRoute,
    private departmentService: DepartmentService) {
    this.departments = new Departments('D100', 'Book100');
  }

  ngOnInit(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    console.log('-------------> DepartmentDetails :' + id);

    this.getDepartmentDetails();
  }

  getDepartmentDetails() {
    this.departments = new Departments('D100', 'Book100');
    return this.departments;
  }

  goBack() {

  }

  save() {

  }
}
