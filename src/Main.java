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
                    String username = c.nextLine().trim();

                    boolean gitrunning = true;

                    while (gitrunning) {

                        String subOption = c.nextLine().trim();
                        System.out.println("\nUser: " + username);
                        System.out.println("1) ~{Github+CLI}~ View commits");
                        System.out.println("2) ~{Github+CLI}~ View push");
                        System.out.println("3) ~{Github+CLI}~ Go back");
                        System.out.println("Choose your option:");

                        switch(subOption) {
                            case "1" :
                                System.out.println("here you get commits");
                                break;
                            case "2" :
                                System.out.println("here we get push");
                                break;
                            case "3":
                                gitrunning = false;
                                System.out.println("yep!");
                                break;
                            default:
                                System.out.println("Please select a valid option");
                        }
                    }
                 break;

                case "2":
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Please choose the valid option");
            }
        }
        c.close();
    }
}