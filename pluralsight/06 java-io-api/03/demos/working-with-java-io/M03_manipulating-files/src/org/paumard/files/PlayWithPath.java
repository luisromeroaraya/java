package org.paumard.files;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PlayWithPath {

    public static void main(String[] args) {

        Path path1 = Paths.get("/../data/videos/");
        Path path2 = Path.of("images/");

        System.out.println("path1 = " + path1);
        System.out.println("path2 = " + path2);
        System.out.println("path1 = " + path1.getClass());
        System.out.println("path1.isAbsolute() = " + path1.isAbsolute());
        System.out.println("path1.getRoot() = " + path1.getRoot());

        Path resolve = path1.resolve(path2);
        System.out.println("resolve = " + resolve); // concatenates path1 + path2 if they make sense

        Path resolveSibling = path1.resolveSibling(path2);
        System.out.println("resolveSibling = " + resolveSibling);

        Path normalize = path1.normalize();
        System.out.println("normalize = " + normalize);

        Path relativize = path1.relativize(path2);
        System.out.println("relativize = " + relativize); // shows you how to go from path1 to path2. both paths must be relative or absolute
    }
}
