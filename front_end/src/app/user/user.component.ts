import { Component, OnInit } from '@angular/core'
import { UserService } from './user.service'
import { User } from '../model/User'

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.scss']
})
export class UserComponent implements OnInit {
  users!: User[];
  checkedUsers: Set<number> = new Set<number>();
  newUsers: User[] = [];

  constructor(private userService: UserService) {}

  ngOnInit(): void {
    this.getAllUsers()
  }

  getAllUsers() {
    this.userService.getAllUsers().subscribe((response) => this.users = response.body);
  }

  submitPostRequest() {
    this.userService.createAllUsers(this.newUsers).subscribe(
      (response) => {
        console.log('POST request successful:', response);
      },
      (error) => {
        console.error('Error during POST request:', error);
      }
    );
  }


  submitPatchRequest() {
    this.userService.editAllUsers(this.users.filter((user) => this.checkedUsers.has(Number(user.id)))).subscribe(
      (response) => {
        console.log('PATCH request successful:', response);
      },
      (error) => {
        console.error('Error during PATCH request:', error);
      }
    );
  }

  submitDeleteRequest() {
    this.userService.deleteAllUsers(Array.from(this.checkedUsers)).subscribe(
      (response) => {
        console.log('DELETE request successful:', response);
      },
      (error) => {
        console.error('Error during DELETE request:', error);
      }
    );
  }

  isChecked(userId: number) {
    return this.checkedUsers.has(userId);
  }

  onCheckboxChange(userId: number) {
    if (this.checkedUsers.has(userId)) {
      this.checkedUsers.delete(userId)
    } else {
      this.checkedUsers.add(userId)
    }
  }

  reloadPage() {
    window.location.reload();
  }

  protected readonly Number = Number

  addNewUser() {
    this.newUsers.push(new User());
  }
}
