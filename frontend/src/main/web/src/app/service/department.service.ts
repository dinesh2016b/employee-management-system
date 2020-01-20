import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Departments } from '../model/departments';
import { Observable } from 'rxjs';

@Injectable()
export class DepartmentService {

    private departmentUrl: string = 'http://localhost:8090/';

    constructor(private http: HttpClient) {
        // this.departmentUrl = 'http://localhost:8080/departments';
    }

    public findById(departmentsId): Observable<Departments[]> {
        console.log('----> departmentsId :'+departmentsId);
        console.log(`${this.departmentUrl + 'departments'}/${departmentsId}`);
        return this.http.get<Departments[]>(`${this.departmentUrl + 'departments'}/${departmentsId}`);
    }

    public findAll(): Observable<Departments[]> {
        console.log('----> departments');
        return this.http.get<Departments[]>(this.departmentUrl + 'departments');
    }

    public save(department: Departments) {
        return this.http.post<Departments>(this.departmentUrl, department);
    }
}