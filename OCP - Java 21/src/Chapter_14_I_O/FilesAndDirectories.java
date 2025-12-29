package Chapter_14_I_O;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.*;

public class FilesAndDirectories {
    public static void main(String[] args) throws IOException {

        //Creating a File
        File file1 = new File("src/Chapter_14_I_O/stripes.txt");
        File file2 = new File("src/Chapter_14_I_O/", "stripes.txt");

        File parent = new File("src/Chapter_14_I_O/");
        File file3 = new File(parent, "stripes.txt");

        //All the four files created point for the same location on disk
        System.out.println(file1.exists());

        //Creating a Path
        Path path1 = Path.of("src/Chapter_14_I_O/stripes.txt");
        Path path2 = Path.of("src", "Chapter_14_I_O", "stripes.txt");

        System.out.println(Files.exists(path1));

        //Switching between File and Path
        File rabbit = new File("rabbit");
        Path rabbitPath = rabbit.toPath();

        //Obtaining a Path from the FileSystems Class
        Path path5 = FileSystems.getDefault()
                .getPath("src/Chapter_14_I_O//stripes.txt");
        Path path6 = FileSystems.getDefault()
                .getPath("src", "Chapter_14_I_O", "stripes.txt");

        //Testing the method printPathInformation
        FilesAndDirectories filesAndDirectories = new FilesAndDirectories();
        filesAndDirectories.printPathInformation(
                Path.of("src/Chapter_14_I_O//stripes.txt"));
        filesAndDirectories.printPathInformation(
                Path.of("./file/.././file/stripes.txt"));

        //Resolving Paths (concatenation)
        System.out.println("Resolve: " +
                parent.toPath().resolve(file3.toPath())); // src/Chapter_14_I_O/src/Chapter_14_I_O/stripes.txt
        //Since the argument for the resolve method was an absolute path provided, that is the value returned:
        System.out.println("Resolve: " +
                parent.toPath().resolve("/absolute/prevails/got it.txt")); // /absolute/prevails/got it.txt

        //Relativizing a Path
        var way = Path.of("fish.txt"); //relative
        var way2 = Path.of("friendly/birds.txt"); //relative

        //relative.relativize(relative) works fine
        System.out.println(way.relativize(way2));
        System.out.println(way2.relativize(way));

        var way3 = Path.of("/fish.txt"); //absolute
        var way4 = Path.of("/friendly/birds.txt"); //absolute

        //absolute.relativize(absolute) works fine
        System.out.println(way3.relativize(way4));
        System.out.println(way4.relativize(way3));

        var way5 = Path.of("/fish.txt"); //absolute
        var way6 = Path.of("friendly/birds.txt"); //relative

        //absolute.relativize(relative) - throws an exception (IllegalArgumentException)
        //System.out.println(way5.relativize(way6));
        //System.out.println(way6.relativize(way5));


        //var way5 = Path.of("C:\\primate\\chimpanzee"); //absolute
        //var way6 = Path.of("D:\\storage\\bananas.txt"); //absolute
        //Different root drives also throws IllegalArgumentException

        //Normalizing a Path (remove the redundancies)
        System.out.println("\nNormalize: " + Path.of("./file/.././file/stripes.txt").normalize());
        //file/stripes.txt


        //Making Directories
        System.out.println("\n------------- Making Directories -------------");
        Files.createDirectories(rabbitPath); //rabbit directoryS created
        if (Files.isDirectory(rabbitPath)) System.out.println(rabbitPath.normalize() + " directory created");
        //createDirectory - Throw an exception if a directory already exist! In other way, use createDirectories

        //copy throws exception if file already exist
        Path anotherRabbit = Paths.get("./another-rabbit");
//        if(!Files.isDirectory(anotherRabbit)) Files.copy(rabbitPath, anotherRabbit);
//                else System.out.println(anotherRabbit.normalize()+" directory already created");
        Files.copy(rabbitPath, anotherRabbit, StandardCopyOption.REPLACE_EXISTING);//Don't  throw exception

        //Copying files with I/O Streams
        try (var is = new FileInputStream("zebra.txt")) {
            //Write IO Stream Data to a file
            Files.copy(is, Paths.get("wolf.txt"), StandardCopyOption.REPLACE_EXISTING);
        }
        Files.copy(Paths.get("clown.xsl"), System.out); //linha 1

        //Copying Files into a Directory
        var file = Paths.get("wolf.txt");
        var directory = Paths.get("./file/wolf.txt");
        Files.copy(file, directory, StandardCopyOption.REPLACE_EXISTING);


        //Deleting a File with delete() and deleteIfExists()
        if (Files.isDirectory(rabbitPath)) Files.delete(rabbitPath); //throws an exception (IOException)
        if (Files.deleteIfExists(rabbitPath)) System.out.println("True - Just deleted!");
        else System.out.println("False - Already deleted!");

        //Comparing file uniqueness
        System.out.println("Its the same file? " +
                Files.isSameFile(Path.of("food.txt"), Path.of("zebra.txt"))); //symbolic link

        //Comparing file with mismatch
        System.out.print("Its the same content? ");
        long mismatch = Files.mismatch(Path.of("wolf.txt"), Path.of("zebra.txt"));
        if (mismatch == -1)
            System.out.println("YES");
        else if (mismatch == 1) {
            System.out.println("NO");
        }

    }
    public void printPathInformation(Path path) {
        System.out.println("Filename is: " + path.getFileName());
        System.out.println(" Root is: " + path.getRoot());
        Path currentParent = path;
        while ((currentParent = currentParent.getParent()) != null)
            System.out.println("   Current parent is: " + currentParent);
        System.out.println();
    }

}