import {HttpClient} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import {LeaveDetails} from './LeaveDetails';

@Injectable()
export class LeaveDetailsService {
    constructor(private httpClient:HttpClient) {}
    
}