package java_class.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class test1 {
    public static void main(String[] args) throws IOException {
        File f = new File("test1.txt");
        OutputStream in = new FileOutputStream(f);
        in.write('a');
        in.write('b');
        in.write('c');
        in.close();

    }

}
