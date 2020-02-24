import { Component, OnInit, Input } from '@angular/core';
import { Employee } from './../../../model/employee';

@Component({
  selector: 'app-employee-details',
  templateUrl: './employee-details.component.html',
  styleUrls: ['./employee-details.component.css']
})

export class EmployeeDetailsComponent implements OnInit {

  @Input() public employee: Employee;

  constructor() { }

  public closeMe() {
    //this.dialogRef.close();
  }

  public updateEmployee() {

  }

  ngOnInit() {
    console.log(this.employee);
  }

}
