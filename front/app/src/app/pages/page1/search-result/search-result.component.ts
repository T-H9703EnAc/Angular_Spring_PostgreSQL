import { Component, OnInit, Input} from '@angular/core';
import { User } from '../models/user.model';

@Component({
  selector: 'app-search-result',
  templateUrl: './search-result.component.html',
  styleUrls: ['./search-result.component.css']
})
export class SearchResultComponent implements OnInit {
  @Input() users?: User[];
  constructor() { }

  ngOnInit(): void {
  }

}
