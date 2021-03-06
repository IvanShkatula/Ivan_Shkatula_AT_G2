package day7InputOutput.homework;

import java.io.File;
import java.util.ArrayList;

public class PrintFilesFolder {


    public static void main(String[] args) {

        String pathName = "D:\\Ivan\\courses it\\java basic\\Java_AT_G2\\src\\day7InputOutput\\homework\\";
        File myPackage = new File(pathName);
        ArrayList<String> arrayList = new ArrayList();

        File[] files = myPackage.listFiles();
        String[] array = new String[files.length];
        getDirectory(arrayList, files);

        for (String s1 : arrayList) {
            System.out.printf("%s ", s1);
        }

    }

    private static void getDirectory(ArrayList<String> arrayList, File[] files) {

        for (File file : files) {
                arrayList.add("file: " + file.getName());
        }
    }

}
