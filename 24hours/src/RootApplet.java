import java.awt.*;

// java applet is not supported by most of the browser any more now.
public class RootApplet {
    int number; 
    public void init(){
        number = 225;
    }

    public void paint(Graphics screen){
        Graphics2D screen2d = (Graphics2D) screen;
        screen2d.drawString("The sequare of the number=225 is " + Math.sqrt(number) , 50, 50);
    }
}
