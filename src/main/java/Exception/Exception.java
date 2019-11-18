package Exception;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Exception {
    public static void main(String[] args) throws IOException {
        File f = new File("1.text");
        FileReader reader = new FileReader(f);
        reader.read();
    }
}
