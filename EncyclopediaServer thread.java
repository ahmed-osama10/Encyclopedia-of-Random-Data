/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package encyclopedia;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class EncyclopediaServer {
    public static void main(String[] args) {
        try {
            String data = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed eget mauris justo. Sed posuere sapien a tortor venenatis tincidunt. Aliquam quis nibh felis. Phasellus at suscipit quam. Praesent malesuada, ipsum at tempor euismod, libero dolor posuere enim, vel bibendum augue nunc vel ex. Sed mollis ligula et velit rhoncus, id faucibus ipsum pulvinar. Nullam sed sem vel lacus feugiat congue ac in elit. Pellentesque viverra magna non semper congue. Nunc in dapibus nisi, eu commodo mi. Vestibulum interdum, risus vel blandit maximus, lectus lectus tincidunt lectus, eu sollicitudin elit neque at mauris. Sed quis enim ligula. Donec sed nisi vel lacus consectetur pellentesque.";

            Encyclopedia encyclopedia = new EncyclopediaImpl(data);
            // Create a registry and bind the remote object to it
            Registry registry = LocateRegistry.createRegistry(1099);
            
            Naming.rebind("Encyclopedia", (Remote) encyclopedia);

            System.out.println("Server ready.");
        } catch (MalformedURLException | RemoteException e) {
            System.err.println("Server exception: " + e.toString());
        }
    }
}