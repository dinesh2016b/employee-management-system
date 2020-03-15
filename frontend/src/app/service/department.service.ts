import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Departments } from '../model/departments';
import { Observable } from 'rxjs';

@Injectable()
export class DepartmentService {

    private departmentUrl: string = 'https://localhost:8443/';

    constructor(private http: HttpClient) {
        // this.departmentUrl = 'http://localhost:8080/departments';
    }

    public findById(departmentsId): Observable<Departments> {
        console.log(`${this.departmentUrl + 'departments'}/${departmentsId}`);
        return this.http.get<Departments>((`${this.departmentUrl + 'departments'}/${departmentsId}`),{ headers: { authorization: this.createBasicAuthToken("dinesh", "dinesh") }});
    }

    public findAll(): Observable<Departments[]> {
        console.log('----> departments');
        return this.http.get<Departments[]>((this.departmentUrl + 'departments'), { headers: { authorization: this.createBasicAuthToken("dinesh", "dinesh") }});
    }

    public save(department: Departments) {
        console.log('----> departments :' + department);
        return this.http.post<Departments>(this.departmentUrl, department);
    }


    createBasicAuthToken(username: String, password: String) {
        return 'Basic ' + window.btoa(username + ":" + password)
    }
}