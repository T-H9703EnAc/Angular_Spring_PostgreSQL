import { Injectable } from '@angular/core';
import { User } from '../pages/page1/models/user.model';

@Injectable({
  providedIn: 'root'
})
export class MockDataService {
  users!: User[]

  constructor() { }
  getMockUsersData(){
    return this.users = [
      {id: "001",name: "Ichirou"},
      {id: "002",name: "Jirou"},
      {id: "003",name: "Sabuou"},
      {id: "004",name: "Sirou"},
      {id: "005",name: "Gorou"},
      {id: "006",name: "Ichiko"},
      {id: "007",name: "Hutaba"},
      {id: "008",name: "Mitsuki"},
      {id: "009",name: "Yotsuha"},
      {id: "010",name: "Satsuki"}
    ]
  }

}
