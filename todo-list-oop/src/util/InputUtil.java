package util;

public class InputUtil {

    private static java.util.Scanner scanner = new java.util.Scanner(System.in);
    
    public static String input(String info){
        System.out.print(info +  " : ");
        String data =  scanner.nextLine();
        return data;
    }

}
