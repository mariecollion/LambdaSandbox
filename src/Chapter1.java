// Copyright (c) 2017 Travelex Ltd

import java.io.File;
import java.io.FileFilter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class Chapter1 {


	/*
	 * 1) Using the listFiles(FileFilter) and isDirectory methods of the java.io.File class, write a method that returns all subdirectories of a given directory.
	 * Use a lambda expression instead of a FileFilter object. Repeat with a method expression.
	 *
	 * 2) Using the list(FilenameFilter) method of the java.io.File class, write a method that returns all files in a given directory
	 * with a given extension. Use a lambda expression, not a FilenameFilter. Which variables from the enclosing scope does it capture?
	 */


    private static final Path pathSubDir = Paths.get("D:\\developpement\\java");
    private static final Path pathAllFiles = Paths.get("D:\\developpement\\java\\workspace\\CertifJava");

    public static void main (String[] args) throws Exception {

        System.out.println("EXERCICE 1 \n");

        File file = pathSubDir.toFile();

		/*
		 * 1) Using the listFiles(FileFilter) and isDirectory methods of the java.io.File class, write a method that returns all subdirectories of a given directory.
		 * Use a lambda expression instead of a FileFilter object. Repeat with a method expression.
		 */

        // without lambda
        FileFilter fileFilter = new FileFilter() {

            @Override
            public boolean accept(File pathname) {
                return pathname != null && pathname.isDirectory();
            }
        };

        File[] subDirectories = file.listFiles(fileFilter);
        printSubDir(subDirectories);

        System.out.println("\n\n");

        // with lambda
        subDirectories = file.listFiles(pn -> pn != null && pn.isDirectory());
        //		subDirectories = file.listFiles((File pn) -> {return pn != null && pn.isDirectory();});
        printSubDir(subDirectories);



        System.out.println("\n\nEXERCICE 2 \n");

		/*
		 * 2) Using the list(FilenameFilter) method of the java.io.File class, write a method that returns all files in a given directory
		 * with a given extension. Use a lambda expression, not a FilenameFilter. Which variables from the enclosing scope does it capture?
		 */
        file = pathAllFiles.toFile();
        String[] filesName = file.list((f, name) -> f.isDirectory() && name.toLowerCase().endsWith(".txt"));
        printNameSubDir(filesName);




    }


    private static void printSubDir(File[] subDir) {
        Stream<File> s = Arrays.stream(subDir);
        s.forEach(System.out::println);
    }


    private static void printNameSubDir(String[] names) {
        Stream<String> s = Arrays.stream(names);
        s.forEach(System.out::println);
    }

}
