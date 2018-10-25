import { Employee } from './employee';
import { Observable } from 'rxjs';
import {HttpClient} from '@angular/common/http';
import { Injectable } from '@angular/core';


@Injectable()
export class EmployeeService {
    constructor(private http: HttpClient) {

    }
/*
    getEmployees(): Promise<Employee[]> {
        console.log('getEmployees called on employee.service');
        return this.http.get('/ftp82/api/employees')
        .toPromise()
        .then(response => response.json() as Employee[])
        .catch(this.handleError);
    }
*/

getEmployees(): Observable<Employee[]> {
    return this.http.get<Employee[]>('http://localhost:8080/ftp82/api/employees');
}

getdisplayEmployeeById(obj:any): Observable<Employee> {
    return this.http.get<Employee>('http://localhost:8080/ftp82/api/employees/'+obj.id);
}
    private handleError(error: any): Promise<any> {
        console.error('An error occurred', error); // for demo purposes only
        return Promise.reject(error.message || error);
    }
}
