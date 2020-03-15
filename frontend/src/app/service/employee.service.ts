import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Employee } from '../model/employee';
import { Observable } from 'rxjs';

@Injectable()
export class EmployeeService {

    private employeeUrl: string = 'https://localhost:8443/';

    constructor(private http: HttpClient) {
        // this.employeeUrl = 'http://localhost:8080/employees';
    }

    public findById(employeesId): Observable<Employee[]> {
        console.log('----> employeesId :'+employeesId)
        console.log(`${this.employeeUrl + 'employees'}/${employeesId}`);
        //return this.http.get<Employee[]>(`${this.employeeUrl + 'employees'}/${employeesId}`);
        return this.http.get<Employee[]>((`${this.employeeUrl + 'employees'}/${employeesId}`),{ headers: { authorization: this.createBasicAuthToken("dinesh", "dinesh") }});
    }

    public findAll(): Observable<Employee[]> {
        return this.http.get<Employee[]>((this.employeeUrl + 'employees'), { headers: { authorization: this.createBasicAuthToken("dinesh", "dinesh") }});
    }

    public save(employee: Employee) {
        return this.http.post<Employee>(this.employeeUrl+ 'employees', employee);
    }

    createBasicAuthToken(username: String, password: String) {
        return 'Basic ' + window.btoa(username + ":" + password)
    }
}