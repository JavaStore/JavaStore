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
        String list="", currentList, exitProgram = "";
        double total = 0;

        do {

            userInput = getUserInput(input, output);

            if(userInput ==1){
                currentList = sale(output, input);
                list += currentList;
                
                total = getTotal(currentList, total);
                
                exitProgram = exit(input, output);

            } else if (userInput==2) {
                printReceipt(list, output, total);
            } else {
                break;
            }
            
        } while (!exitProgram.equalsIgnoreCase("n") );



    }

    private static double getTotal(String currentList, double total) {
        int $index;
        $index = currentList.indexOf("$");
        total += Double.parseDouble(currentList.substring($index+1, currentList.length()));
        return total;
    }

    private static int getUserInput(Scanner input, PrintStream output) {
        int userInput;
        String menu= "(1) Sale \n(2) Print Receipt \n(3) Exit";
        output.println(menu);
        userInput = input.nextInt();
        return userInput;
    }

    private static String exit(Scanner input, PrintStream output) {
        String exitProgram;
        output.println ("Do you want to exit? (y/n)");
        input.nextLine();
        exitProgram=input.next();
        return exitProgram;
    }

    public static String sale(PrintStream output, Scanner input){

        String item;
        int quantity;
        double price;
        String list;

        output.println("What item would you like?");
        input.nextLine();
        item = input.nextLine();
        output.println("Quantity");
        quantity=input.nextInt();
        output.println("Price");
        price=input.nextDouble();
        list = item + " " + quantity + " " + "$"+price + "\n";
        return list;
    }

    public static void printReceipt(String list, PrintStream output, double total){
        output.println(list);
        output.printf("Total " + "$%.2f\n\n", total);
    }
}
