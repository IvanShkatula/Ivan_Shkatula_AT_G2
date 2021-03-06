package day7InputOutput.homework;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

public class FoldersFilesCreater {

    String dir = "/folder1/folder2/folder3/folder4/";

    public static void main(String[] args) {

        FoldersFilesCreater foldersFilesCreater = new FoldersFilesCreater();
        foldersFilesCreater.createDirectory(foldersFilesCreater.dir);

    }

    private void createDirectory(String dir) {

        File file = new File(dir);

        if (file.mkdirs()) {
            try {
                writer(dir, "file1.txt", "1 2 3 4 5 6 7 8 9 10");
                writer(dir, "file2.txt", "3 6 9 8 77 45 58 87 12 32");
                System.out.println("Directory and files created");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Directory was not created!");
        }
    }

    private void writer(String dir, String fileName, String content) throws IOException {
        BufferedWriter out = new BufferedWriter(new FileWriter(dir + fileName));
        out.write(content);
        out.close();
    }


}
