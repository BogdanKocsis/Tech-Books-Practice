package Chapter_14_I_O;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;

public class Review_Questions {
    public static void main(String[] args) throws IOException {

        // Q14
        var p1 = Path.of("/zoo/./bear", "../food.txt");
        p1.normalize().relativize(Path.of("/lion"));
        System.out.println(p1);

        var p2 = Path.of("/zoo/animals/bear/koala/food.txt");
        System.out.println(p2.subpath(1, 3).getName(1));

        var p3 = Path.of("/pets/../cat.txt");
        var p4 = Path.of("./dog.txt");
        System.out.println(p4.resolve(p3));

    }
}
