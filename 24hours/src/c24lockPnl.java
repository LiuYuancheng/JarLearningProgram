import javax.swing.*;
import java.awt.*;
import java.util.*;

public class c24lockPnl extends JPanel{
    public c24lockPnl(){
        super();
        String crtTime = getTime(); 
        FlowLayout flo = new FlowLayout();
        setLayout(flo);
        JLabel timeL = new JLabel("Time: ");
        add(timeL);
        JLabel crtL = new JLabel(crtTime);
        add(crtL);
    }

    String getTime() {
        Calendar now = Calendar.getInstance();
        int hour = now.get(Calendar.HOUR_OF_DAY);
        int mins = now.get(Calendar.MINUTE);
        int month = now.get(Calendar.MONTH);
        int day = now.get(Calendar.DAY_OF_MONTH);
        int year = now.get(Calendar.YEAR);
        String[] monthList = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
                "October", "November", "December" };
        return monthList[month] + " " + day + " " + year + " " + hour + ":" + mins;
    }
}



