import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Employee } from './../../../model/employee';
import { EmployeeService } from './../../../service/employee.service';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-employee-details',
  templateUrl: './employee-details.component.html',
  styleUrls: ['./employee-details.component.css']
})

export class EmployeeDetailsComponent implements OnInit {

  @Input() public employee: Employee;
  @Output() passEntry: EventEmitter<any> = new EventEmitter();

  constructor(public activeModal: NgbActiveModal, private employeeService: EmployeeService) { }

  public closeMe() {
    this.activeModal.close(this.employee);
  }

  public updateEmployee() {

    this.passEntry.emit(this.employee);

    this.employeeService.save(this.employee).subscribe(res => {
      console.log('-------> employee.empNo      ----> ' + this.employee.empNo);
      console.log('-------> employee.firstName  ----> ' + this.employee.firstName);
      console.log('-------> employee.lastName   ----> ' + this.employee.lastName);
      console.log('-------> employee.brthDate   ----> ' + this.employee.birthDate);
    });
    this.activeModal.close(this.employee);
  }

  ngOnInit() {

  }

}
