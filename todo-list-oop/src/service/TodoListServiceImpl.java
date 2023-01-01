package service;

import entities.TodoList;
import repository.TodoListRepository;

public class TodoListServiceImpl implements TodoListService {

    private TodoListRepository todoListRepository;

    public TodoListServiceImpl(TodoListRepository todoListRepository){
        this.todoListRepository = todoListRepository;
    }


    @Override
    public void showTodoList() {
        TodoList[] model = todoListRepository.findAll();

        System.out.println("TODO-LIST");

        for(var i=0; i<model.length; i++){
            var todo = model[i];
            var no = i+1;

            if(todo != null){
                System.out.println(no + ". " + todo.getTodo());
            }
        }        
    }

    @Override
    public void addTodoList(String todo) {
        TodoList newTodo = new TodoList(todo);
        todoListRepository.add(newTodo);
        System.out.println("Success Add New todo : " + todo);
    }

    @Override
    public void removeTodoList(Integer number) {
        boolean isSuccess = todoListRepository.remove(number);

        if(isSuccess){
            System.out.println("Success Remove Todo : "+ number);
        }else{
            System.out.println("Failed Remove Todo : "+ number);
        }

    }
    
}
