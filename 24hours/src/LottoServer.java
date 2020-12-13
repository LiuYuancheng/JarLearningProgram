import java.io.*;
import nu.xom.*;
import org.apache.xmlrpc.*;
import helma.xmlrpc.*; // Solve the problem function "addHandler" not define.


public class LottoServer {
    int port = 4404;
    WebServer server;

    public LottoServer() throws IOException, ParsingException {
        System.out.println("Creating server to listen port:" + port);
        server = new WebServer(port);

        LottoCounter counter = new LottoCounter();
        server.addHandler("Lotto", counter);
    }

    public void start() {
        System.out.println("Now accepting requests");
        server.start();
    }

    public static void main(String[] args) {
        try {
            LottoServer lotto = new LottoServer();
            lotto.start();
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
    }
}
