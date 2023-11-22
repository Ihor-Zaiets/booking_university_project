import { Component, OnInit } from '@angular/core'
import { UserService } from './user.service'

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  data: any;
  postData: any = [
    {
      "id": 1,
      "login": "admin2",
      "password": "$2a$12$AhQoDd2zsJOxI5Ub4gZnFeuDTQHsNIORIteHYn0yeYzFSugxsdsHu",
      "roles": [
        {
          "id": 1,
          "name": "ADMIN",
          "description": null
        }
      ],
      "firstname": "admin2",
      "email": "admin2@example.com",
      "phone": "+1234567890",
      "address": ""
    }
  ];

  postDataResponse = "Response from backend on POST"

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

  submitPostRequest() {
    this.userService.postData(this.postData).subscribe(
      (response) => {
        console.log('POST request successful:', response);
        this.postDataResponse = 'POST request successful';
        // Handle the response from the backend as needed
      },
      (error) => {
        console.error('Error during POST request:', error);
        this.postDataResponse = 'Error during POST request';
        // Handle errors, if any
      }
    );
  }
}
