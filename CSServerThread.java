import java.io.*;
import java.net.*;
import java.lang.*;
/**
 *
 * @author sparrow
 */
public class CSServerThread {

  
    /** default port number
     */
    public final static int DEFAULT_PORT = 3456;//
    
    /*
     * number of clients
     */
    public final static int qLen = 3;
    
    
    public void CSServerThread(){};
      /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        ServerSocket listenSocket = null;
        OutputStreamWriter osw = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        int portNum = DEFAULT_PORT;
        int clientNo = 0;

        if( args.length != 0) 
        {
            try {
                    // count clients serviced
                    portNum = Integer.parseInt( args[ 0]);
                    // put some test here to allow for port number not in range
                }
            catch( NumberFormatException nfE) {
                System.err.println( "Illegal port number: " + args[ 0]);
                System.err.println( "\tUsing the default: " + DEFAULT_PORT);
            }
        }
    
        try {
                 listenSocket = new ServerSocket(portNum,qLen);
            }
        catch( IOException ioE)
        {
            System.err.println("Could not bind to port: " + portNum);
            System.err.println( "\tIs it already in use?");
            System.err.println( "\tIs it a reserved port number?");
            System.exit(1);
        }

        while( true) { 
            // loop forever accepting clients 
            Socket clientSocket = null;
            clientSocket = listenSocket.accept();
            ++clientNo;                 // count clients serviced
            new HandleClient( clientSocket, clientNo).start();  // a new thread
            
            
            
            //new HandleClient( listenSocket.accept(), ++clientNo).start();
            // try changing for isr rather than br
           // end of finally
            } // while forever waiting for a client connection 
    } // main
}