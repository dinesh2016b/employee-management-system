import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs'
import { Salaries } from '../model/salaries';

@Injectable()

export class SalariesService {

  private salariesUrl: string = 'http://localhost:8090/';

  constructor(private http: HttpClient) {

  }

  public findAll(): Observable<Salaries[]> {
    return this.http.get<Salaries[]>(this.salariesUrl);
  }

}