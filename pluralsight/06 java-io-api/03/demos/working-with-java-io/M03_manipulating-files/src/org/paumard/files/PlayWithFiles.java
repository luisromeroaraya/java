package org.paumard.files;

import java.io.File;
import java.io.IOException;

public class PlayWithFiles {

    public static void main(String[] args) throws IOException {
        File file = new File("files/sonnet2.txt");

        boolean fileCreated = file.createNewFile();
        System.out.println("fileCreated = " + fileCreated);

        File dir = new File("files/data2/more-data");
        boolean dirCreated = dir.mkdir();
        System.out.println("dirCreated = " + dirCreated);
        boolean mkdirs = dir.mkdirs();
        System.out.println("mkdirs = " + mkdirs);

        boolean delete = dir.delete();
        System.out.println("delete = " + delete);

        dir = new File("images/.././././images/mountain.jpg");
        String name = dir.getName();
        String parent = dir.getParent();
        String path = dir.getPath();

        System.out.println("name = " + name);
        System.out.println("parent = " + parent);
        System.out.println("path = " + path);

        String absolutePath = dir.getAbsolutePath();
        String canonicalPath = dir.getCanonicalPath();
        System.out.println("absolutePath = " + absolutePath);
        System.out.println("canonicalPath = " + canonicalPath);
    }
}
