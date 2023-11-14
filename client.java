import java.io.*;
import java.net.*;

public class client {
    public static void main(String[] args) {
        String serverAddress = "localhost";
        int serverPort = 888;

        try{
            Socket s = new Socket(serverAddress, serverPort);

            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintWriter out = new PrintWriter(s.getOutputStream(), true);

            BufferedReader ci = new BufferedReader(new InputStreamReader(System.in));
            String clientMsg;
            String serverMsg;

            while (true){
                System.out.print("Shradhha : ");
                clientMsg = ci.readLine();
                out.println(clientMsg);

                serverMsg = in.readLine();
                if(serverMsg == null){
                    break;
                }
                System.out.println("Sudhanshu: " + serverMsg);
            }
            in.close();
            out.close();
            s.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
