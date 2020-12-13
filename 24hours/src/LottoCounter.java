import java.io.*;
import java.util.*;
import nu.xom.*;

public class LottoCounter {
    Document doc;
    Element root;
    File logf;
    public LottoCounter() throws IOException, ParsingException{
        Builder builder = new Builder();
        logf = new File("lotto.log");
        if(!logf.exists()){
            root = new Element("log");
            doc = new Document(root);
            writeDocument();
        }
        doc = builder.build(logf);
        root = doc.getRootElement();
    }

    public boolean sendResult(int plays, int win3, int win4, int win5, int win6) throws IOException, ParsingException{
        Element result = new Element("reuslt");
        
        Element playElement= new Element("plays");
        playElement.appendChild(""+plays);

        Element win3Element= new Element("win3");
        win3Element.appendChild(""+win3);

        Element win4Element= new Element("win4");
        win4Element.appendChild(""+win4);

        Element win5Element= new Element("win5");
        win5Element.appendChild(""+win4);

        Element win6Element= new Element("win6");
        win6Element.appendChild(""+win4);

        Element dateElement= new Element("date");
        Date now = new Date();
        dateElement.appendChild(""+now.toString());

        result.appendChild(playElement);
        result.appendChild(win3Element);
        result.appendChild(win4Element);
        result.appendChild(win5Element);
        result.appendChild(win6Element);
        result.appendChild(dateElement);
        
        
        root.appendChild(result);
        return true;
    }

    private void writeDocument() throws IOException{
        FileOutputStream fileStream = new FileOutputStream(logf);
        Serializer writer = new Serializer(fileStream);
        writer.setIndent(2);
        writer.write(doc);
    }
}
