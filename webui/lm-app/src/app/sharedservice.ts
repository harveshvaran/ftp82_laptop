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
    empName:String;
    setName(empName:String):void{
        this.empName=empName;
    }
    getName():String{
        return this.empName;
    }
    empPh:number;
    setPh(empPh:number):void{
        this.empPh=empPh;
    }
    getPh():number{
        return this.empPh;
    }
    empEmail:String;
    setEmail(empEmail:String):void{
        this.empEmail=empEmail;
    }
    getEmail():String{
        return this.empEmail;
    }
    empDept:String;
    setDept(empDept:String):void{
        this.empDept=empDept;
    }
    getDept():String{
        return this.empDept;
    }
    empManagerId:String;
    setManagerId(empManagerId:String):void{
        this.empManagerId=empManagerId;
    }
    getManagerId():String{
        return this.empManagerId;
    }
    empDoj:Date;
    setDoj(empDoj:Date):void{
        this.empDoj=empDoj;
    }
    getDoj():Date{
        return this.empDoj;
    }
}
