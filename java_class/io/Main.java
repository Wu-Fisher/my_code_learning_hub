package java_class.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.Buffer;

public class Main {
    public static void main(String[] args) throws IOException {

        FileWriter fw = new FileWriter("b.txt");
        // BufferedWriter bw = new BufferedWriter(fw);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("b.txt")));
        bw.write("Hello\n");
        bw.write("World\n");
        bw.flush();
        bw.close();
        FileReader fr = new FileReader("b.txt");
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();
    }
}
