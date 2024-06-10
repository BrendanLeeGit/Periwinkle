package filereadingandmanipulation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MyFileReader {
    private File file;
    private Scanner scanner;

    public MyFileReader(String fileName){
        file = new File(fileName);
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Returns the first line of the intended file, which happens to be the key in the key.txt file.
     * @return  the first line of the file
     */
    public String getKeyFromFile(){
        return scanner.nextLine();
    }
}
