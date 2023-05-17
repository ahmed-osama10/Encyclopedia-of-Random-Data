package encyclopedia;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.Map;

public class EncyclopediaClient {
    public static void main(String[] args) {
        try {
            // Lookup the remote Encyclopedia object using RMI naming
            Encyclopedia encyclopedia = (Encyclopedia) Naming.lookup("rmi://localhost/Encyclopedia");

            // Thread for counting
            Thread countThread = new Thread(() -> {
                try {
                    // Measure execution time
                    long startTime = System.currentTimeMillis();
                    int count = encyclopedia.count();
                    long endTime = System.currentTimeMillis();
                    long elapsedTime = endTime - startTime;
                    double speed = (double) count / elapsedTime;

                    // Print thread information and count result
                    System.out.println("Thread: " + Thread.currentThread().getName() + " | Count: " + count + " | Time: " + elapsedTime + "ms | Speed: " + speed);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            });

            // Thread for retrieving repeated words
            Thread repeatedWordsThread = new Thread(() -> {
                try {
                    // Measure execution time
                    long startTime = System.currentTimeMillis();
                    String[] repeatedWords = encyclopedia.repeatedWords();
                    long endTime = System.currentTimeMillis();
                    long elapsedTime = endTime - startTime;

                    // Print thread information and repeated words
                    System.out.println("Thread: " + Thread.currentThread().getName() + " | Repeated Words: " + Arrays.toString(repeatedWords) + " | Time: " + elapsedTime + "ms");
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            });

            // Thread for finding the longest word
            Thread longestThread = new Thread(() -> {
                try {
                    // Measure execution time
                    long startTime = System.currentTimeMillis();
                    String longestWord = encyclopedia.longest();
                    long endTime = System.currentTimeMillis();
                    long elapsedTime = endTime - startTime;

                    // Print thread information and the longest word
                    System.out.println("Thread: " + Thread.currentThread().getName() + " | Longest Word: " + longestWord + " | Time: " + elapsedTime + "ms");
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            });

            // Thread for finding the shortest word
            Thread shortestThread = new Thread(() -> {
                try {
                    // Measure execution time
                    long startTime = System.currentTimeMillis();
                    String shortestWord = encyclopedia.shortest();
                    long endTime = System.currentTimeMillis();
                    long elapsedTime = endTime - startTime;

                    // Print thread information and the shortest word
                    System.out.println("Thread: " + Thread.currentThread().getName() + " | Shortest Word: " + shortestWord + " | Time: " + elapsedTime + "ms");
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            });

            // Thread for retrieving word counts
            Thread repeatThread = new Thread(() -> {
                try {
                    // Measure execution time
                    long startTime = System.currentTimeMillis();
                    Map<String, Integer> wordCounts = encyclopedia.repeat();
                    long endTime = System.currentTimeMillis();
                    long elapsedTime = endTime - startTime;

                    // Print thread information and word counts
                    System.out.println("Thread: " + Thread.currentThread().getName() + " | Word Counts: " + wordCounts + " | Time: " + elapsedTime + "ms");
                } catch (RemoteException e) {
                    e.printStackTrace();
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
 
