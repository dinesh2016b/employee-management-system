import { Injectable } from '@angular/core';
import { Employee } from '../model/employee';
import { BehaviorSubject, Observable } from 'rxjs';
import { BackendApiService } from './backend-api.service';

@Injectable({ providedIn: 'root'})
export class EmployeeService {

    private employeeUrl: string = 'http://localhost:8080/employees';
    private employeeDataSubject: BehaviorSubject<Employee[]>;
    private employeeData: Observable<Employee[]>;
    private employees: Employee[];

    constructor(private backendAPISerivce: BackendApiService) {
        this.employeeDataSubject = new BehaviorSubject(this.employees);
        this.employeeData = this.employeeDataSubject.asObservable();

        this.employeeUrl = 'http://localhost:8095/ems-employees';
    }

    public findById(employeesId) {
        console.log('----> employeesId :' + employeesId);
        console.log(`${this.employeeUrl + 'employees'}/${employeesId}`);

        return this.backendAPISerivce.sendGetAPIRequest(`${this.employeeUrl}/${employeesId}`);
            
        //return this.http.get<Employee[]>(`${this.employeeUrl}/${employeesId}`);
        //return this.http.get<Employee[]>((`${this.employeeUrl}/${employeesId}`),{ headers: { authorization: this.createBasicAuthToken("dinesh", "dinesh") }});
    }

    public findAll(jwtToken: String) {
        return this.backendAPISerivce.sendPostRequest(this.employeeUrl + '/pageNo/0/size/10', {jwtToken});

        //return this.http.get<Employee[]>((this.employeeUrl + '/pageNo/0/size/10'));
        //return this.http.get<Employee[]>((this.employeeUrl + '/pageNo/0/size/10'), { headers: { authorization: this.createBasicAuthToken("dinesh", "dinesh") }});
    }

    public save(employee: Employee) {
        return this.backendAPISerivce.sendPostRequest(this.employeeUrl, employee);

        //return this.http.post<Employee>(this.employeeUrl, employee);
    }

    createBasicAuthToken(username: String, password: String) {
        return 'Basic ' + window.btoa(username + ":" + password)
    }
}