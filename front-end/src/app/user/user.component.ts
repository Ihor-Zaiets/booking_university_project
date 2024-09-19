import { Component, OnInit } from '@angular/core'
import { UserService } from './user.service'
import { User } from '../model/User'
import { RouteService } from '../Service/route.service'
import { ToastrService } from 'ngx-toastr'

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.scss']
})
export class UserComponent implements OnInit {
  users!: User[];
  checkedUsers: Set<number> = new Set<number>();
  newUsers: User[] = [];

  constructor(private userService: UserService, private route: RouteService, private toastr: ToastrService) {}

  ngOnInit(): void {
    this.getAllUsers()
  }

  getAllUsers() {
    this.userService.getAllUsers().subscribe((response) => this.users = response.body);
  }

  saveUsers() {
    this.userService.createAllUsers(this.newUsers).subscribe(() => {
      this.route.reloadComponent(true);
      this.toastr.success('Zapisano')
    });
  }

  editUsers() {
    this.userService.editAllUsers(this.users.filter((user) => this.checkedUsers.has(Number(user.id)))).subscribe(() => {
      this.route.reloadComponent(true);
      this.toastr.success('Zapisano')
    });
  }

  deleteUsers() {
    this.userService.deleteAllUsers(Array.from(this.checkedUsers)).subscribe(() => {
      this.route.reloadComponent(true);
      this.toastr.success('Usunięto')
    });
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

  deleteNewUser(index: number) {
    this.newUsers.splice(index, 1);
  }
}
