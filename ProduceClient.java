import java.io.*;
import java.net.*;
import java.lang.*;
/**
 *
 * @author sparrow
 */
public class ProduceClient extends Thread {

    private Socket socket = null;
    private int portNo = 0;
    private PrintWriter out = null;
   
    private BufferedReader in = null;
    private String host = null;
    
    private int count = 0;
    
    
    
    
    // constructor
    public ProduceClient( String host, int portNo,int sizeofMsg) {
        //super( "ServerThread");
        this.host = host;
        this.portNo = portNo;
        this.sizeofMsg = sizeofMsg;
    }  // constructor
   
    
    public void run() {
        
        try {
            socket = new Socket(host,portNo);
            out  = new PrintWriter(socket.getOutputStream(),true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        }
        catch( UnknownHostException e)
        {
            System.err.println("Dnot't know host named: " + host);
            System.exit(1);
        }
        catch(IOException e)
        {
            System.err.println("Couldn't get I/O for " + "the connection to: " + host);
            System.exit(1);
        }
        
        try{
        
        BufferedReader stdIn = new BufferedReader( new InputStreamReader(System.in));
        String userInput;
        
        do {
            //System.out.print( "Enter some text to echo (END = exit): ");
            System.out.print( "Test the multi-thread methods (END = exit): ");
            //System.out.flush();
            //userInput = stdIn.readLine();
            userInput = "thread" + (count++);
            out.write(usrInput);
            //out.println(userInput);
            //System.out.println("\techo: " + in.readLine());
        } while( !userInput.equals( "END")); // while forever waiting for a client connection
        
        out.close();
        in.close();
        stdIn.close();
        socket.close();
            
        }
        catch(IOException ioE)
        {
            System.err.println("connection error, maybe cannot produce this client.");
        }
    }
}