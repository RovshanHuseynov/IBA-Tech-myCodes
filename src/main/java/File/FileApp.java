package file;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class FileApp {
    public static void main(String[] args) throws IOException {
        FileApp fa = new FileApp();
        ArrayList<String> al = fa.createArrayList();
        fa.writeFile(al, "firstFileApp.txt");
        ArrayList<String> contents = fa.readFile("firstFileApp.txt");
        ArrayList<String> alSorted = fa.sortArrayList(contents);
        fa.writeFile(alSorted, "secondFileApp.txt");
    }

    public ArrayList<String> createArrayList(){
        ArrayList<String> al = new ArrayList<String>();
        Random r = new Random();
        for(int i=0; i<33; i++){
            StringBuilder sb = new StringBuilder();
            int len = (int)r.nextInt(11) + 20;

            for(int j=0; j<len; j++) {
                int range = 'Z' - 'A' + 1;
                sb.append((char)(Math.random()*range + 'A'));
            }

            al.add(sb.toString());
        }
        return al;
    }

    public void writeFile(ArrayList<String> al, String fileName) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File(fileName)));

        for(String item : al) {
            bw.write(item);
            bw.newLine();
        }
        bw.close();
    }

    public ArrayList<String> readFile(String fileName) throws IOException {
        ArrayList<String> al = new ArrayList<String>();
        BufferedReader br = new BufferedReader(new FileReader(new File(fileName)));
        String line;
        while ((line = br.readLine()) != null) {
            al.add(line);
        }

        br.close();
        return al;
    }

    public ArrayList<String> sortArrayList(ArrayList<String> contents){
        Collections.sort(contents, (o1, o2) -> o1.length() - o2.length());
        return contents;
    }
}
