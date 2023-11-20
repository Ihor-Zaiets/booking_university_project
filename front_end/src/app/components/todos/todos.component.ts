import { Component, OnInit } from '@angular/core'
import { CommonModule } from '@angular/common';
import { Todo } from '../../models/Todo'
import { FormsModule } from '@angular/forms'

@Component({
  selector: 'app-todos',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './todos.component.html',
  styleUrl: './todos.component.css'
})
export class TodosComponent implements OnInit{
  todos:Todo[];

  inputTodo:string = "";

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

  toggleDone (id:number) {
    this.todos.map((todo, index) => {
      if (id == index) todo.completed = !todo.completed;

      return todo;
    })
  }

  deleteTodo(id:number) {
    this.todos = this.todos.filter((todo, index) => index !== id);
  }

  addTodo () {
    this.todos.push({
       content:this.inputTodo,
       completed: false
    })

    this.inputTodo = "";
  }
}
