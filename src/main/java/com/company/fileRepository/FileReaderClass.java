package com.company.fileRepository;

import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;
public class FileReaderClass {
    /**
     * The method reads the ID from student logged in from file
     * @return Student ID as string
     * @throws FileNotFoundException if the file doesn't exist
     */
    public static String idReader() throws FileNotFoundException{
        File myObj = new File("src/main/java/com/company/fileRepository/studentID.txt");
        Scanner fileReader = new Scanner(myObj);
        String data = fileReader.nextLine();
        fileReader.close();
        return data;
    }


    /**
     * Method that reads each line of the courses file
     * @return course list with students as string
     * @throws FileNotFoundException in case the file does't exist
     */
    public static String courseReader() throws FileNotFoundException{
        File myObj = new File("src/main/java/com/company/fileRepository/courses.txt");
        Scanner courseReader= new Scanner(myObj);
        StringBuilder infos = new StringBuilder();
        while (courseReader.hasNextLine()){
            String data = courseReader.nextLine();
            infos.append(data).append("\n");
        }
        courseReader.close();
        return infos.toString();
    }

}
