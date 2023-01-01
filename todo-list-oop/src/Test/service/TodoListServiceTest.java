package Test.service;

import entities.TodoList;
import repository.TodoListRepository;
import repository.TodoListRepositoryImpl;
import service.TodoListService;
import service.TodoListServiceImpl;

public class TodoListServiceTest {

    public static void main(String[] args) {
        // testShowTodoList();
        // testAddTodoList();
        testRemoveTodoList();
    }

    public static void testShowTodoList() {

        // TodoListRepository todoListRepository = new TodoListRepositoryImpl(); //
        TodoListRepositoryImpl todoListRepository = new TodoListRepositoryImpl(); // polymorpshm
        todoListRepository.data[0] = new TodoList("Makan Mie Ayam");
        todoListRepository.data[1] = new TodoList("Makan Mie Aceh");
        todoListRepository.data[2] = new TodoList("Makan Mie Padang");

        TodoListService todoListService = new TodoListServiceImpl(todoListRepository); // polymorpshm

        todoListService.showTodoList();

    }

    public static void testAddTodoList() {
        TodoListRepository todoListRepository = new TodoListRepositoryImpl(); // polymorpshm
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository); // polymorpshm

        todoListService.addTodoList("buy a Bo'oawwo'ah");
        todoListService.addTodoList("buy a Rocket");
        todoListService.addTodoList("buy a Towel");
    
        todoListService.showTodoList();
    }

    public static void testRemoveTodoList(){
        TodoListRepository todoListRepository = new TodoListRepositoryImpl(); // polymorpshm
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository); // polymorpshm

        todoListService.addTodoList("buy a Bo'oawwo'ah");
        todoListService.addTodoList("buy a Rocket");
        todoListService.addTodoList("buy a Towel");
    
        todoListService.removeTodoList(3); // success
        todoListService.showTodoList();
        todoListService.removeTodoList(3); // failed
        todoListService.showTodoList();
    }

}
