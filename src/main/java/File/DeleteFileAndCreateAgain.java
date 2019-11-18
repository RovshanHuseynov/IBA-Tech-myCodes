package file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DeleteFileAndCreateAgain {
    public static void main(String[] args) throws IOException {
        Create c = new Create();
        c.write("salam");
        c.write("salam azerbaycanlilar");
        c.deleteFile("C:\\Users\\PC\\Desktop\\myFile.txt");
        c.write("sagol");
    }
}

class Create {
    public void write(String s) throws IOException {
        String path =
                //"data/myFile.txt";
                "C:\\Users\\PC\\Desktop\\myFile.txt";
        File file = new File(path);
        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter fw = new FileWriter(file, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(s);
        bw.newLine();
        bw.close();
    }

    public void deleteFile(String path){
        File file = new File(path);
        System.out.println(file.delete());
    }
}
