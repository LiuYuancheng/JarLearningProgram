import java.io.*;
import java.net.*;
import java.util.*;
import org.apache.xmlrpc.*;
import helma.xmlrpc.*;
import helma.xmlrpc.XmlRpcException;
import java.util.*;
import org.apache.xmlrpc.*;



public class LottoClient {
    XmlRpcClient client;
    String server = "http://localhost";
    int port = 4404;
    
    public LottoClient(){
        try{
            client = new XmlRpcClient("http://localhost:4404");

        }catch(MalformedURLException except){
            System.out.println("Error : "+ except.toString());
        }
    }

    public void send(int plays, int win3, int win4, int win5, int win6) throws IOException, XmlRpcException,
            helma.xmlrpc.XmlRpcException {
        Vector<Integer> params = new Vector<Integer>();
        params.add(plays);
        params.add(win3);
        params.add(win4);
        params.add(win5);
        params.add(win6);

        Boolean result = (Boolean)client.execute("lotto.sendResult", params);
    }

    public static void main(String[] args){
        try{
            System.out.println("Start....");;
            int plays = Integer.parseInt(args[0]);
            int win3 = Integer.parseInt(args[1]);
            int win4 = Integer.parseInt(args[2]);
            int win5 = Integer.parseInt(args[3]);
            int win6 = Integer.parseInt(args[4]);
            LottoClient lc = new LottoClient();
            lc.send(plays, win3, win4, win5, win6);

        }catch(IOException err){
            System.out.println("Error:" + err.toString());
            err.printStackTrace();
        }catch(XmlRpcException err2){
            System.out.println("Error:" + err2.toString());
            err2.printStackTrace();
        } 
    }
}
