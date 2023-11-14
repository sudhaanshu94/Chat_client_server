import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        int port = 888;

        try{
            ServerSocket ss = new ServerSocket(port);
            System.out.println("Server listening on port " + port);

            Socket cs = ss.accept();
            System.out.println("Client Connected from " + cs.getInetAddress().getHostAddress());

            BufferedReader in = new BufferedReader(new InputStreamReader(cs.getInputStream()));
            PrintWriter out = new PrintWriter(cs.getOutputStream(), true);

            BufferedReader ci = new BufferedReader(new InputStreamReader(System.in));
            String clientMsg;
            String serverMsg;

            while(true){
                clientMsg = in.readLine();
                if(clientMsg == null){
                    break;
                }
                System.out.println("Shradhha: " + clientMsg);

                System.out.print("Sudhanshu: ");
                serverMsg = ci.readLine();
                out.println(serverMsg);
            }
            in.close();
            out.close();
            cs.close();
            ss.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
