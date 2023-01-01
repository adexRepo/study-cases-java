public class AplikasiTodolist {

    public static String[] model = new String[10];
    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) throws Exception {
        // testShowTodolist();
        // testAddTodolist();
        // testDeleteTodolist();
        // testInput();
        // testViewTodoList();
        // testViewDeleteTodolist();

        viewShowTodolist();
    }

    // * menampilkan todo list
    public static void showTodolist(){
        for(var i=0; i<model.length; i++){
            var todo = model[i];
            var no = i+1;

            if(todo != null){
                System.out.println(no + ". " + todo);
            }
        }
    }
    
    // * menambahkan todo list
    public static void addTodolist(String todo){
        // check apakah mode penuh ?
        var isFull = true;
        for(var i=0; i<model.length; i++){
            if(model[i] == null){
                isFull = false;               
                break;
            }
        }

        // jika penuh maka resize ukuran array 2x lipat
        if(isFull){
            var temp = model;
            model = new String[model.length * 2];
            for(int i = 0; i < temp.length; i++){
                model[i] = temp[i];
            }
        }

        // tambahkan ke posisi yang data arr nya NULL
        for(var i=0; i<model.length; i++){
            if(model[i] == null){
                model[i] = todo;
                break;
            }
        }
    }

    // * menghapus todo list
    public static boolean deleteTodolist(Integer number){
        int index = number-1;

        if(index >= model.length){
            return false;
        } else if(model[index] == null){
            return false;
        }else{
            for(var i = index; i < model.length-1; i++){
                if(i == model.length-1){
                    model[i] = null;
                }else{
                    model[i] = model[i+1];
                }
            }
            return true;
        }
    }

    public static String input(String info){
        System.out.print(info +  " : ");
        String data =  scanner.nextLine();
        return data;
    }
    
    // * menampilan view todo list
    public static void viewShowTodolist(){
        while (true){
            System.out.println("Todo List");

            showTodolist();
            System.out.println(">>>>>COMMAND<<<<<");
            System.out.println("Menu :");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("x. Keluar");
            var input = input("Pilih");
            if(input.equals("1")){
                viewAddTodolist();
            }else if (input.equals("2")){
                viewDeleteTodolist();
            }else if (input.equals("x")){
                break;
            }else{
                System.out.println("Pilihan tidak dimengerti");
            }
        }
    }

    // * menampilan view menambah todo list
    public static void viewAddTodolist(){
        System.out.println("MENAMBAH TODOLIST");

        var todo = input("Todo (tekan x jika batal)");

        if(todo.equals("x")){
            // batal
        }else{
            addTodolist(todo);
        }
    }

    // * menampilan view menghapus todo list
    public static void viewDeleteTodolist(){
        System.out.println("MENGHAPUS TODOLIST");

        var number = input("Todo (tekan x jika batal)");

        if(number.equals("x")){
            // batal
        }else{
            Boolean isDelete = deleteTodolist(Integer.parseInt(number));
            if(isDelete){
                System.out.println("Todo ke: " + number + " berhasil dihapus");
            }else{
                System.out.println("Todo ke: " + number + " tidak ditemukan dihapus");
            }
        }
    }

          // ^^^^^^^^^^^^^^^^^^^^ TESTING METHOD ^^^^^^^^^^^^^^^^^^^^ //
          public static void testShowTodolist(){
            model[0] = "Belajar Java";
            model[1] = "Belajar Kotlin";
            model[2] = "Belajar Python";
            model[3] = "Belajar C++";
            model[4] = "Belajar C#";
            showTodolist();
        }
    
        public static void testAddTodolist(){
            for(int i=0; i<41; i++){
                addTodolist("todo ke. "+ i);
            }
            System.out.println(model.length);
            showTodolist();
        }
    
        public static void testDeleteTodolist(){
            addTodolist("joni ");
            addTodolist("dandang ");
            addTodolist("sudanto ");
    
            // check remove more than length of array
            var result = deleteTodolist(20);
            System.out.println("test 1 = "+result);
    
            // check remove not exist
             result = deleteTodolist(4);
            System.out.println("test 2 = "+result);
    
            // check remove exist
             result = deleteTodolist(2);
            System.out.println("test 3 = "+result);
    
            showTodolist();
        }
    
        public static void testInput(){
            var name = input("nama");
            System.out.println("Hi, " + name);
        }
    
        public static void testViewTodoList(){
            addTodolist("joni ");
            addTodolist("dandang ");
            addTodolist("sudanto ");
    
            viewAddTodolist();
    
            showTodolist();
        }
    
        public static void testViewDeleteTodolist(){
            addTodolist("joni ");
            addTodolist("dandang ");
            addTodolist("sudanto ");
            showTodolist();
    
            viewDeleteTodolist();
    
            showTodolist();
        }
}
