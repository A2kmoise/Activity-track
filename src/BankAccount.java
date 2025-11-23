import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

class Account{
    int balance = 0;
    int MAX_BALANCE;

    public Account(int maximumBalance){
        MAX_BALANCE = maximumBalance;
    }

    public synchronized  void deposit(int amount) throws  InterruptedException{
        while( balance + amount > MAX_BALANCE){
            wait();
        }
        balance = balance+amount;
        System.out.println("Thread: "+ Thread.currentThread().getName() + " deposited: "+ amount + " the current balance is: " + balance );

        notifyAll();
    }

    public synchronized void withDraw (int amount) throws InterruptedException{
        while( amount > balance){
            wait();
        }
        balance = balance-amount;
        System.out.println("Thread: " + Thread.currentThread().getName() + " withdrew: " + amount + " the current balance is: " + balance);

        notifyAll();
    }

    public synchronized int getBalance(){
        return balance;
    }
}


public class BankAccount {

    private static final AtomicInteger TOTAL_COUNT = new AtomicInteger(0);
    public static final int TOTAL_TRANSACTIONS = 50;

    public static void main(String[] args) {
        Account account = new Account(10000);
        Random random = new Random();  // for generating the number or amount of money to deposit

        Runnable depositor = () -> {
            try {
                while (TOTAL_COUNT.get() < TOTAL_TRANSACTIONS) {
                    int amount = 10 + random.nextInt(91); // formula : min + random.nextInt(max - min +1) so max = 100
                    account.deposit(amount);
                    TOTAL_COUNT.incrementAndGet();
                    Thread.sleep(10);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        };

        Runnable withDrawer = () -> {
            try {
                while (TOTAL_COUNT.get() < TOTAL_TRANSACTIONS) {
                    int amount = 10 + random.nextInt(81);
                    account.withDraw(amount);
                    Thread.sleep(10);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        //Creating 4 threads

        Thread t1 = new Thread(depositor, "depositor1");
        Thread t2 = new Thread(depositor, "depositor2");
        Thread t3 = new Thread(withDrawer, "withDrawer1");
        Thread t4 = new Thread(withDrawer, "withDrawer2");

        //starting the threads

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        //joining the child threads

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}