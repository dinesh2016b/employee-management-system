import { NgModule } from '@angular/core';
import { Employee } from './../../../model/employee';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-employee-details',
  templateUrl: './employee-details.component.html',
  styleUrls: ['./employee-details.component.css']
})

export class EmployeeDetailsComponent implements OnInit {

  model: Employee = {
    empNo: '',
    firstName: '',
    lastName: '',
    birthDate: '',
  };

  constructor() {

  }

  public closeMe() {
    //this.dialogRef.close();
  }

  public updateEmployee() {

  }
  ngOnInit() {
  }

}
