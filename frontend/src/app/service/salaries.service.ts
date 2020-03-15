import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs'
import { Salaries } from '../model/salaries';

@Injectable()

export class SalariesService {

  private salariesUrl: string = 'https://localhost:8443/';

  constructor(private http: HttpClient) {

  }

  public findAll(): Observable<Salaries[]> {
    return this.http.get<Salaries[]>(this.salariesUrl);
  }

}