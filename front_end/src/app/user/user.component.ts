import { Component, OnInit } from '@angular/core'
import { UserService } from './user.service'

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit{
  data: any;

  constructor(private userService: UserService) {}

  ngOnInit(): void {
    this.userService.getData().subscribe(
      (result) => {
      this.data = result;
      console.log(this.data);
    },
    (error) => {
      console.error('An error occurred:', error);
    }
      );
  }
}
