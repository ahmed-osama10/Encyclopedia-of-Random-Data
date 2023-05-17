package encyclopedia;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;

// The "Encyclopedia" interface extends the Remote interface, indicating that it's a remote interface.
public interface Encyclopedia extends Remote {
    // The "count" method returns the count of something and may throw a RemoteException.
    int count() throws RemoteException;

    // The "repeatedWords" method returns an array of strings representing repeated words and may throw a RemoteException.
    String[] repeatedWords() throws RemoteException;

    // The "longest" method returns the longest string and may throw a RemoteException.
    String longest() throws RemoteException;

    // The "shortest" method returns the shortest string and may throw a RemoteException.
    String shortest() throws RemoteException;

    // The "repeat" method returns a Map containing strings and their corresponding counts, and may throw a RemoteException.
    Map<String, Integer> repeat() throws RemoteException;
}
