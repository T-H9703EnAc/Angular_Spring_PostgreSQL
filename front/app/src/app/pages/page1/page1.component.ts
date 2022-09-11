import { Component, OnInit } from '@angular/core';
import { MockDataService } from 'src/app/mocks/mock-data.service';
import { User } from './models/user.model';

@Component({
  selector: 'app-page1',
  templateUrl: './page1.component.html',
  styleUrls: ['./page1.component.css']
})
export class Page1Component implements OnInit {

  users!: User[]

  constructor(private mockDataService: MockDataService) { }

  ngOnInit(): void {
  }

  onSearch(){
    this.users = this.mockDataService.getMockUsersData();
  }

}
