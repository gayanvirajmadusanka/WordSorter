
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Acer
 */
class FileIO {

    private static int numberOfStringLoaded;

    static ArrayList<String> loadArrayListFromFile(File file) {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                arrayList.add(scanner.nextLine());
                numberOfStringLoaded++;
            }
        } catch (FileNotFoundException ex) {
            if (fileExists(file)) {
                arrayList = null;
                return arrayList;
            }
        }

        return arrayList;
    }

    static boolean fileExists(File f) {
        boolean notBeNull = f != null;
        boolean mustExist = f.exists();
        boolean beAFile = f.isFile();
        boolean beAReadable = f.canRead();

        return notBeNull & mustExist & beAFile & beAReadable;
    }

    static String toStringFromArrayList(ArrayList<String> listOfStrings) {
        String result = "";
        for (String listOfString : listOfStrings) {
            result += listOfString + "\n";
        }
        return result;
    }

    static String toStringFileIO(File f) {
        String fileInformation = f.toString(); //File path
        String fileName = f.getName(); //File name

        Path path = Paths.get(fileInformation);

        FileTime lastModified;
        String lastModifiedFormat = "";
        long size = 0;

        try {
            // size of a file (in bytes)
            size = Files.size(path);
            //get last modified time
            lastModified = Files.getLastModifiedTime(path);
            //Set date format
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy - hh:mm:ss");
            lastModifiedFormat = dateFormat.format(lastModified.toMillis());
        } catch (IOException ex) {
            Logger.getLogger(FileIO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "File Path: " + fileInformation + "\n"
                + "File Name: " + fileName + "\n"
                + "File Size: " + size + " bytes" + "\n"
                + "Last Modified: " + lastModifiedFormat + "\n"
                + "Number of Strings Loaded : " + numberOfStringLoaded;
    }
}
