import {HttpClient} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { LeaveDetails } from './LeaveDetails';

@Injectable()
export class LeaveDetailsService {
    constructor(private httpClient:HttpClient) {}

    
    load(obj):Observable<LeaveDetails[]>{
        console.log(obj);
        return this.httpClient.get<LeaveDetails[]>("http://localhost:8080/ftp82/api/LeaveDetails/history/"+obj.empid);
    }

    getPendingById(obj:any): Observable<LeaveDetails[]> {

        console.log('getEmployees called on leaveDetails.service');
        console.log(obj);
        return this.httpClient.get<LeaveDetails[]>("http://localhost:8080/ftp82/api/LeaveDetails/pending/"+obj.id);
    }

    deleteLeaveDetails(obj:any): Observable<string> {
        console.log(obj)
        let url="http://localhost:8080/ftp82/api/LeaveDetails/delete/"+obj.lId+"/"+obj.empId;
        return this.httpClient.delete(url, {responseType:'text'} );   
    }
    
    putUpdate(emp:any):Observable<String>{
        console.log(emp)
        let url="http://localhost:8080/ftp82/api/LeaveDetails/updateleave/"+emp.empid+"/"+emp.leaveType+"/"+emp.sdate+"/"+emp.edate+"/"+emp.lreason+"/"+emp.leaveid;
        return this.httpClient.put(url,{},{responseType:'text'});
    }

}
