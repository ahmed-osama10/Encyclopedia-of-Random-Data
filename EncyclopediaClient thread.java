package encyclopedia;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.Map;

public class EncyclopediaClient {
    public static void main(String[] args) {
        try {
            Encyclopedia encyclopedia = (Encyclopedia) Naming.lookup("rmi://localhost/Encyclopedia");

            Thread countThread = new Thread(() -> {
                try {
                    long startTime = System.currentTimeMillis();
                    int count = encyclopedia.count();
                    long endTime = System.currentTimeMillis();
                    long elapsedTime = endTime - startTime;
                    double speed = (double) count / elapsedTime;
                    System.out.println("Thread: " + Thread.currentThread().getName() + " | Count: " + count + " | Time: " + elapsedTime + "ms | Speed: " + speed);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            });

            Thread repeatedWordsThread = new Thread(() -> {
                try {
                    long startTime = System.currentTimeMillis();
                    String[] repeatedWords = encyclopedia.repeatedWords();
                    long endTime = System.currentTimeMillis();
                    long elapsedTime = endTime - startTime;
                    System.out.println("Thread: " + Thread.currentThread().getName() + " | Repeated Words: " + Arrays.toString(repeatedWords) + " | Time: " + elapsedTime + "ms");
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            });

            Thread longestThread = new Thread(() -> {
                try {
                    long startTime = System.currentTimeMillis();
                    String longestWord = encyclopedia.longest();
                    long endTime = System.currentTimeMillis();
                    long elapsedTime = endTime - startTime;
                    System.out.println("Thread: " + Thread.currentThread().getName() + " | Longest Word: " + longestWord + " | Time: " + elapsedTime + "ms");
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            });

            Thread shortestThread = new Thread(() -> {
                try {
                    long startTime = System.currentTimeMillis();
                    String shortestWord = encyclopedia.shortest();
                    long endTime = System.currentTimeMillis();
                    long elapsedTime = endTime - startTime;
                    System.out.println("Thread: " + Thread.currentThread().getName() + " | Shortest Word: " + shortestWord + " | Time: " + elapsedTime + "ms");
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            });

            Thread repeatThread;
            repeatThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        long startTime = System.currentTimeMillis();
                        Map<String, Integer> wordCounts = encyclopedia.repeat();
                        long endTime = System.currentTimeMillis();
                        long elapsedTime = endTime - startTime;
                        System.out.println("Thread: " + Thread.currentThread().getName() + " | Word Counts: " + wordCounts + " | Time: " + elapsedTime + "ms");
                    } catch (RemoteException e) {
                    }
                }
            });

            // Start the threads
            countThread.start();
            repeatedWordsThread.start();
            longestThread.start();
            shortestThread.start();
            repeatThread.start();

            // Wait for all threads to complete
            countThread.join();
            repeatedWordsThread.join();
            longestThread.join();
            shortestThread.join();
            repeatThread.join();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
