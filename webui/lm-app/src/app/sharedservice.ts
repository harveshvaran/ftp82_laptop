import { Injectable } from "@angular/core";

@Injectable()
export class SharedService {
    empId:number;
    setId(empId:number):void{
        this.empId=empId;
    }
    getId():number{
        return this.empId;
    }
}
