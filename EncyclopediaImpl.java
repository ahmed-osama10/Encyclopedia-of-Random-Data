/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encyclopedia;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Implementation class for the Encyclopedia remote interface.
 */
public class EncyclopediaImpl extends UnicastRemoteObject implements Encyclopedia {
    private static final long serialVersionUID = 1L;
    private final String data;

    /**
     * Constructor for the Encyclopedia implementation.
     * @param data The data representing the encyclopedia.
     * @throws RemoteException If a remote communication error occurs.
     */
    public EncyclopediaImpl(String data) throws RemoteException {
        super();
        this.data = data;
    }

    /**
     * Calculates and returns the number of characters in the encyclopedia.
     * @return The count of characters.
     * @throws RemoteException If a remote communication error occurs.
     */
    @Override
    public int count() throws RemoteException {
        return data.length();
    }

    /**
     * Retrieves an array of repeated words in the encyclopedia.
     * @return An array of repeated words.
     * @throws RemoteException If a remote communication error occurs.
     */
    @Override
    public String[] repeatedWords() throws RemoteException {
        String[] words = data.split("\\s+");
        Map<String, Integer> wordCounts = new HashMap<>();
        for (String word : words) {
            if (wordCounts.containsKey(word)) {
                wordCounts.put(word, wordCounts.get(word) + 1);
            } else {
                wordCounts.put(word, 1);
            }
        }
        return wordCounts.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(entry -> entry.getKey())
                .toArray(String[]::new);
    }

    /**
     * Retrieves the longest word in the encyclopedia.
     * @return The longest word.
     * @throws RemoteException If a remote communication error occurs.
     */
    @Override
    public String longest() throws RemoteException {
        String[] words = data.split("\\s+");
        return Arrays.stream(words)
                .max((a, b) -> a.length() - b.length())
                .orElse("");
    }

    /**
     * Retrieves the shortest word in the encyclopedia.
     * @return The shortest word.
     * @throws RemoteException If a remote communication error occurs.
     */
    @Override
    public String shortest() throws RemoteException {
        String[] words = data.split("\\s+");
        return Arrays.stream(words)
                .min((a, b) -> a.length() - b.length())
                .orElse("");
    }

    /**
     * Retrieves a map of word counts in the encyclopedia.
     * @return A map of word counts.
     * @throws RemoteException If a remote communication error occurs.
     */
    @Override
    public Map<String, Integer> repeat() throws RemoteException {
        String[] words = data.split("\\s+");
        Map<String, Integer> wordCounts = new HashMap<>();
        for (String word : words) {
            if (wordCounts.containsKey(word)) {
                wordCounts.put(word, wordCounts.get(word) + 1);
            } else {
                wordCounts.put(word, 1);
            }
        }
        return wordCounts;
    }
}
