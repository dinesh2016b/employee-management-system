import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Employee } from '../model/employee';
import { Observable } from 'rxjs';

@Injectable()
export class EmployeeService {

    private employeeUrl: string = 'http://localhost:8090/';

    constructor(private http: HttpClient) {
        // this.employeeUrl = 'http://localhost:8080/employees';
    }

    public findById(employeesId): Observable<Employee[]> {
        console.log('----> employeesId :'+employeesId)
        console.log(`${this.employeeUrl + 'employees'}/${employeesId}`);
        return this.http.get<Employee[]>(`${this.employeeUrl + 'employees'}/${employeesId}`);
    }

    public findAll(): Observable<Employee[]> {
        return this.http.get<Employee[]>(this.employeeUrl + 'employees');
    }

    public save(employee: Employee) {
        return this.http.post<Employee>(this.employeeUrl, employee);
    }
}