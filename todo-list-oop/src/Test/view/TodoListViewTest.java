package Test.view;

import repository.TodoListRepository;
import repository.TodoListRepositoryImpl;
import service.TodoListService;
import service.TodoListServiceImpl;
import view.TodoListView;

public class TodoListViewTest {
    
    public static void main(String[] args) {
        // testShowTodoList();
        // testAddTodoList();
        testRemoveTodoList();
    }

    public static void testShowTodoList(){
        TodoListRepository todoListRepository = new TodoListRepositoryImpl(); // polymorpshm
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository); // polymorpshm
        TodoListView todoListView = new TodoListView(todoListService);

        todoListService.addTodoList("buy a Bo'o'awwo'ah");
        todoListService.addTodoList("buy a Rocket");
        todoListService.addTodoList("buy a Towel");
    
        todoListView.showTodoList();
    }

    public static void testAddTodoList(){
        TodoListRepository todoListRepository = new TodoListRepositoryImpl(); // polymorpshm
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository); // polymorpshm
        TodoListView todoListView = new TodoListView(todoListService);

        todoListView.addTodoList();
        todoListView.showTodoList();

    }

    public static void testRemoveTodoList(){
        TodoListRepository todoListRepository = new TodoListRepositoryImpl(); // polymorpshm
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository); // polymorpshm
        TodoListView todoListView = new TodoListView(todoListService);

        todoListService.addTodoList("buy a Bo'o'awwo'ah");
        todoListService.addTodoList("buy a Rocket");
        todoListService.addTodoList("buy a Towel");
    
        todoListView.removeTodoList();
        todoListView.showTodoList();
    }

}
