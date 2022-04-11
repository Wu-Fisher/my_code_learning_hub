package java_class.data;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd HH:mm");
        String s = sdf.format(d);
        System.out.println(s);
    }
}
