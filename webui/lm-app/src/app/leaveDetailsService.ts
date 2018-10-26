import {HttpClient} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { LeaveDetails } from './LeaveDetails';

@Injectable()
export class LeaveDetailsService {
    constructor(private httpClient:HttpClient) {}
    
    load(empId):Observable<LeaveDetails[]>{
        console.log(empId+" in services");
        return this.httpClient.get<LeaveDetails[]>("http://localhost:8080/ftp82/api/LeaveDetails/history/"+empId);
    }

    getPendingById(obj:any): Observable<LeaveDetails[]> {

        console.log('pending called on leaveDetails.service');
        console.log(obj);
        return this.httpClient.get<LeaveDetails[]>("http://localhost:8080/ftp82/api/LeaveDetails/pending/"+obj.id);
 
    }
    getAppOrDeny(obj:any): Observable<string> {

        console.log('appOrDeny called on leaveDetails.service');
        console.log(obj);
        let url:string ='http://localhost:8080/ftp82/api/LeaveDetails/approve/'+obj.eid+"/"+obj.lid+"/"+obj.comments+"/"+obj.status;
        return this.httpClient.post(url ,{}, {responseType:'text'} );

    }
    getEdit(obj:any): Observable<LeaveDetails[]> {

        console.log('appOrDeny called on leaveDetails.service');
        console.log(obj);
        let url:string ='http://localhost:8080/ftp82/api/LeaveDetails/reedit/'+obj.eid;
        return this.httpClient.get<LeaveDetails[]>(url);

    }
    getEditPer(obj:any): Observable<string> {

        console.log('appOrDeny called on leaveDetails.service');
        console.log(obj);
        let url:string ='http://localhost:8080/ftp82/api/LeaveDetails/reedit/re/'+obj.eid+"/"+obj.lid+"/"+obj.comments+"/"+obj.status;
        return this.httpClient.post(url ,{}, {responseType:'text'} );
    }

    deleteLeaveDetails(obj:any): Observable<string> {
        console.log(obj)
        let url="http://localhost:8080/ftp82/api/LeaveDetails/delete/"+obj.lId+"/"+obj.empId;
        return this.httpClient.delete(url, {responseType:'text'} );   
    }
    leaveApply(apply:any):Observable<string> {
        let url = "http://localhost:8080/ftp82/api/LeaveDetails/applyleave/"+apply.empId+"/"+apply.type+"/"+apply.sDate+"/"+apply.eDate+"/"+apply.reason;
        return this.httpClient.post(url,{ },{responseType:'text'});
    }
    
    putUpdate(emp:any):Observable<String>{
        console.log(emp)
        let url="http://localhost:8080/ftp82/api/LeaveDetails/updateleave/"+emp.empid+"/"+emp.leaveType+"/"+emp.sdate+"/"+emp.edate+"/"+emp.lreason+"/"+emp.leaveid;
        return this.httpClient.put(url,{},{responseType:'text'});
    }

}
