import { Component, OnInit } from '@angular/core'
import { CommonModule } from '@angular/common';
import { Todo } from '../../models/Todo'

@Component({
  selector: 'app-todos',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './todos.component.html',
  styleUrl: './todos.component.css'
})
export class TodosComponent implements OnInit{
  todos:Todo[];

  ngOnInit(): void {
    this.todos = [
      {
        content: "First todo",
        completed:false
      },
      {
        content: "Second todo",
        completed:true
      }
    ]
  }
}
