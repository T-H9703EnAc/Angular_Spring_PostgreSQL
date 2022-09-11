import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { MockDataService } from 'src/app/mocks/mock-data.service';
import { User } from './models/user.model';
import { FormControl, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-page1',
  templateUrl: './page1.component.html',
  styleUrls: ['./page1.component.css']
})
export class Page1Component implements OnInit {

  users!: User[]

  private url: string = "http://localhost:8080/api/get/getUserData";

  searchCondition = new FormGroup({
    id: new FormControl(''),
    name: new FormControl(''),
  });

  constructor(
    private mockDataService: MockDataService,
    private http: HttpClient) { }

  ngOnInit(): void {
  }

  onSearch(){
    let user: User = {
      id: String(this.searchCondition.value["id"]),
      name: String(this.searchCondition.value["name"])
    }

    this.users = this.mockDataService.getMockUsersData();
    console.log(user)

    this.http.get<User[]>(this.url)
    .subscribe(users => this.users = users);

  }

}
