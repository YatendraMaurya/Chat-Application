/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatprog.networking;

import chatprog.gui.Client;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yatendra.maurya
 */
public class Messagelistener extends Thread  {
    ServerSocket server;
    int port=8877 ;
    WritableGUI gui;
    
    public Messagelistener(WritableGUI gui,int port) throws IOException{
    this.port=port;
    this.gui=gui;
    server =new ServerSocket(port);
}
    public Messagelistener(){
        try {
            server =new ServerSocket(port);
        } catch (IOException ex) {
            Logger.getLogger(Messagelistener.class.getName()).log(Level.SEVERE, null, ex);
        }
    
} 
    @Override
    public void run()
    {
         Socket clientSocket;
        try {
            while((clientSocket=server.accept())!=null) 
            {
                InputStream din =clientSocket.getInputStream();
                BufferedReader br =new BufferedReader(new InputStreamReader(din));
                String line=br.readLine();
                if(line!=null)
                {
                    gui.write(line);
                }
                
                      }}
        catch (IOException ex) {
            Logger.getLogger(Messagelistener.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    
}
