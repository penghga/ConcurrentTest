import java.io.*;
import java.net.*;
import java.lang.*;
/**
 *
 * @author sparrow
 */
public class CSClientThread {

  
        
    public void CSClientThread(){};
      /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        String host = "127.0.0.1";
        int port = 3456;//port is 3456
        int sizeofMsg = 512;//bytes
        if( args.length != 0)
        {
            host = args[0];
            port = Integer.parseInt(args[1]);
            sizeofMsg = Integer.parseInt(args[2]);
            
        }
        
        try{
            for(int i =0 ; i<10;i++)
            {
            
                ProduceClient threadClient = new ProduceClient(host,port,sizeofMsg);
                threadClient.start();
                threadClient.sleep(2000);
            }
        }
        catch(InterruptedException ex)
        {
            ex.printStackTrace();
        }
           
    } // main
}