package repository;

import entities.TodoList;

public interface TodoListRepository {
    
    TodoList[] findAll();

    void add(TodoList todoList);

    boolean remove(Integer number);

}
