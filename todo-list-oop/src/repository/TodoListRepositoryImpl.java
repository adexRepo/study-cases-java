package repository;

import entities.TodoList;

public class TodoListRepositoryImpl implements TodoListRepository {

    public TodoList[] data = new TodoList[10];

    @Override
    public TodoList[] findAll() {
        return data;
    }

    public boolean isFull() {
        // check apakah mode penuh ?
        var isFull = true;
        for (var i = 0; i < data.length; i++) {
            if (data[i] == null) {
                isFull = false;
                break;
            }
        }

        return isFull;
    }

    public void resizeIsFull() {
        // jika penuh maka resize ukuran array 2x lipat
        if (isFull()) {
            var temp = data;
            data = new TodoList[data.length * 2];
            for (int i = 0; i < temp.length; i++) {
                data[i] = temp[i];
            }
        }
    }

    @Override
    public void add(TodoList todoList) {

        resizeIsFull();

        // tambahkan ke posisi yang data arr nya NULL
        for (var i = 0; i < data.length; i++) {
            if (data[i] == null) {
                data[i] = todoList;
                break;
            }
        }

    }

    @Override
    public boolean remove(Integer number) {
        var index =  number-1;
        if(index >= data.length){
            return false;
        } else if(data[index] == null){
            return false;
        }else{
            for(var i = index; i < data.length-1; i++){
                if(i == data.length-1){
                    data[i] = null;
                }else{
                    data[i] = data[i+1];
                }
            }
            return true;
        }        
    }

}
