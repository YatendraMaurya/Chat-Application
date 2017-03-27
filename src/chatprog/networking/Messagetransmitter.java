/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatprog.networking;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yatendra.maurya
 */
public class Messagetransmitter extends Thread{
    String message,hostname;
    int port;
    public Messagetransmitter()
    {
        
    }
    public Messagetransmitter(String message,String hostname,int port )
    {
        this.hostname=hostname;
        this.message=message;
        this.port=port;
        
    }
    @Override
    public void run(){
        try {
            Socket s=new Socket(hostname,port);
            s.getOutputStream().write(message.getBytes());
            s.close();
        } catch (IOException ex) {
            Logger.getLogger(Messagetransmitter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
