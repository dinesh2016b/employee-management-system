import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs'
import { Salaries } from '../model/salaries';

@Injectable({
  providedIn: 'root'
})

export class SalariesService {

  private salariesUrl: string = 'http://localhost:8080/ems-salaries';

  constructor(private http: HttpClient) {

  }

  public findAll(): Observable<Salaries[]> {
    return this.http.get<Salaries[]>(this.salariesUrl + '/pageNo/0/size/10');
  }

}
