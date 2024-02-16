
class SynchronizedDemo {
    public synchronized void printWithDelay(String text, long delayMillis) {
        for (int i =  0; i < text.length(); i++) {
            System.out.print(text.charAt(i));
            try {
                Thread.sleep(delayMillis);
            } catch (InterruptedException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }
    public void printWithoutDelay(String string) {
        System.out.print(string);
    }
}
public class Main {
    public static void main(String[] args) throws InterruptedException {
        SynchronizedDemo synchronizedDemo = new SynchronizedDemo();
        Thread thread1 = new Thread(() -> synchronizedDemo.printWithDelay("WELCOME TO CSTAD!\n",  500));
        Thread thread2 = new Thread(() -> synchronizedDemo.printWithDelay("******************************************************\n",  500));
        Thread thread3 = new Thread(() -> synchronizedDemo.printWithDelay("Don't give up on this opportunity, do your best first. \n",  500));
        Thread thread4 = new Thread(() -> synchronizedDemo.printWithDelay("-----------------------------------------------------\n",  500));
        Thread thread5 = new Thread(() -> {
            synchronizedDemo.printWithoutDelay("Downloading");
            synchronizedDemo.printWithDelay("............",500);
            synchronizedDemo.printWithoutDelay("completed  100%. \n");
        });
        thread1.start();
        thread1.join();
        thread2.start();
        thread2.join();
        thread3.start();
        thread3.join();
        thread4.start();
        thread4.join();
        thread5.start();
        thread5.join();
    }
}