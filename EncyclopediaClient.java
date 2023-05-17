package encyclopedia;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Map;

public class EncyclopediaClient {
    public static void main(String[] args) {
        try {
            // Lookup the remote Encyclopedia object using RMI naming
            Encyclopedia encyclopedia = (Encyclopedia) Naming.lookup("rmi://localhost/Encyclopedia");

            // Start measuring the execution time
            long startTime = System.currentTimeMillis();

            // Invoke the remote methods and retrieve the results
            int count = encyclopedia.count();
            System.out.println("Number of letters: " + count);

            String[] repeatedWords = encyclopedia.repeatedWords();
            System.out.println("Repeated words: " + String.join(", ", repeatedWords));

            String longest = encyclopedia.longest();
            System.out.println("Longest word: " + longest);

            String shortest = encyclopedia.shortest();
            System.out.println("Shortest word: " + shortest);

            Map<String, Integer> repeat = encyclopedia.repeat();
            System.out.println("Repeat count: ");
            repeat.forEach((key, value) -> System.out.println(key + " : " + value));

            // Measure the elapsed time
            long endTime = System.currentTimeMillis();
            long elapsedTime = endTime - startTime;
            System.out.println("Elapsed time: " + elapsedTime + " ms");
        } catch (MalformedURLException | NotBoundException | RemoteException e) {
            // Handle exceptions that can occur during the RMI communication
            System.err.println("Client exception: " + e.toString());
        }
    }
}
