import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private baseUrl = 'http://localhost:8080/api/v1/employees';

  constructor(private http: HttpClient) { }

  getEmployee(empId: number): Observable<Object> {
    return this.http.get(`${this.baseUrl}/${empId}`);
  }

  createEmployee(employee: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, employee);
  }

  updateEmployee(empId: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${empId}`, value);
  }

  deleteEmployee(empId: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${empId}`, { responseType: 'text' });
  }

  getEmployeesList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }
}