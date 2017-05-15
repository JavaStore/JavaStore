import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by SarahVillareal on 5/15/17.
 */
public class JavaStore {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        PrintStream output= System.out;
        int userInput;
        String list="", currentList;
        int $index;
        double total = 0;

        do {

            String menu= "(1) Sale \n(2) Print Receipt \n(3) Exit";
            output.println(menu);
            userInput = input.nextInt();

            if(userInput ==1){
                currentList = sale(output, input);
                list += currentList;
                $index = currentList.indexOf("$");
                total += Double.parseDouble(currentList.substring($index+1, currentList.length()));

            } else if (userInput==2){
                printReceipt(list, output);
            } else {
//            exit(output);
            }
        } while (userInput != 3);



    }

    public static String sale(PrintStream output, Scanner input){

        String item;
        int quantity;
        double price;
        String list;

        output.println("What item would you like?");
        item = input.next();
        output.println("Quantity");
        quantity=input.nextInt();
        output.println("Price");
        price=input.nextDouble();
        list = item + " " + quantity + " " + "$"+price + "\n";
        return list;
    }

    public static void printReceipt(String list, PrintStream output){
        output.println(list);


    }
}
