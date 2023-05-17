package encyclopedia;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;

public interface Encyclopedia extends Remote {
    // Remote interface for the Encyclopedia

    // Method to count the number of characters in the encyclopedia
    int count() throws RemoteException;

    // Method to retrieve an array of repeated words in the encyclopedia
    String[] repeatedWords() throws RemoteException;

    // Method to retrieve the longest word in the encyclopedia
    String longest() throws RemoteException;

    // Method to retrieve the shortest word in the encyclopedia
    String shortest() throws RemoteException;

    // Method to retrieve a map of word counts in the encyclopedia
    Map<String, Integer> repeat() throws RemoteException;
}

