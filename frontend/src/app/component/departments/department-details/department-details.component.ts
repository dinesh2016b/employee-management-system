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
    //this.departments = new Departments('D100', 'Book100');
  }

  ngOnInit(): void {
    this.getDepartmentDetails();
  }

  getDepartmentDetails() {
    // this.departments = new Departments('D100', 'Book100');
    console.log('-------------> DepartmentDetails :' + this.route.snapshot.paramMap.get('id'));
    this.departmentService.findById(this.route.snapshot.paramMap.get('id')).subscribe(departments => this.departments = departments);
    return this.departments;
  }

  goBack() {

  }

  save() {

  }
}
