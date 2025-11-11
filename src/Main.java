import java.sql.SQLOutput;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.printf("\n%60s%s%n", "", "================================ Github user activity getter ===================================");
        Scanner c = new Scanner(System.in);
        boolean  running = true;
        while (running) {
            System.out.println("\nMenu");
            System.out.println("1)~{Github+CLI}~ Enter username");
            System.out.println("2)~{Github+CLI}~ Exit");
            System.out.println("Choose your option:");

            String option = c.nextLine().trim();
            switch (option) {
                case "1" :
                    System.out.println("Enter username here:");
                    String subOption = c.nextLine();
                    System.out.println("1) ~{Github+CLI}~ View commits");
                    System.out.println("2) ~{Github+CLI}~ View push");
                    break;
                case "2":
                    running = false;
                default:
                    System.out.println("Please choose the valid option");
            }
        }
    }
}