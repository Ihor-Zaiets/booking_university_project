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
      "id": 92,
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

  deleteData = [92];

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


  submitPatchRequest() {
    this.userService.patchData(this.postData).subscribe(
      (response) => {
        console.log('PATCH request successful:', response);
        this.postDataResponse = 'PATCH request successful';
        // Handle the response from the backend as needed
      },
      (error) => {
        console.error('Error during PATCH request:', error);
        this.postDataResponse = 'Error during PATCH request';
        // Handle errors, if any
      }
    );
  }

  submitDeleteRequest() {
    this.userService.deleteData(this.deleteData).subscribe(
      (response) => {
        console.log('DELETE request successful:', response);
        this.postDataResponse = 'DELETE request successful';
        // Handle the response from the backend as needed
      },
      (error) => {
        console.error('Error during DELETE request:', error);
        this.postDataResponse = 'Error during DELETE request';
        // Handle errors, if any
      }
    );
  }
}
