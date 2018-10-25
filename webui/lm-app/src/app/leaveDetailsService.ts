import {HttpClient} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import {LeaveDetails} from './LeaveDetails';

@Injectable()
export class LeaveDetailsService {
    constructor(private httpClient:HttpClient) {}
    
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
}