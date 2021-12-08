package utils;

import java.io.File; // Import the File class
import java.util.Scanner; // Import the Scanner class to read text files

public class Reader {
    public static String read(String src) {
        try {
            File file = new File(src);
            String data = "";
            Scanner myReader = new Scanner(file);

            while (myReader.hasNextLine()) {
                String currentLine = myReader.nextLine();
                data += currentLine;
            }

            myReader.close();

            return data;
        } catch (Exception e) {
            System.out.println("An error occurred.");
            throw new Error(e.getMessage());
        }
    }

    /*public List<String[]> readAndFilter(String src, Predicate<> condition) {
        try {
            File file = new File(src);
            Scanner myReader = new Scanner(file);
            List<String[]> occurrences = new ArrayList<String[]>();

            while (myReader.hasNextLine()) {
                String currentLine = myReader.nextLine();
                if (currentLine.contains(pattern)) {
                    occurrences.add(currentLine.split(","));
                }
            }

            myReader.close();

            return occurrences;
        } catch (Exception e) {
            System.out.println("An error occurred.");
            throw new Error(e.getMessage());
        }
    }*/

}