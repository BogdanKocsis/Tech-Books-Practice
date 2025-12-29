package Chapter_4_Core_APIs;


import java.util.Arrays;

/***********************************************************************************
 * Methods          When arrays contain same data        When arrays are different *
 ***********************************************************************************
 *  equals                        true                         false               *
 *  compare                        0                        positive or negative   *
 *  mismatch                      -1                        Zero or positive index *
 ***********************************************************************************
 */

public class Arrays_Examples {
    public static void main(String[] args) {

        String[] strings = {"10", "9", "100"};

        Arrays.sort(strings);

        System.out.println(Arrays.toString(strings));

        System.out.println("--------------");
        System.out.println(strings.length);
        System.out.println(strings[2]);

        System.out.println("--------------");

        System.out.println(Arrays.equals(new String[]{"a"}, new String[]{"A"}));
        // compare 2 arrays to determine if they are equal

        System.out.println(Arrays.compare(new String[]{"a"}, new String[]{"A"}));
        // compare 2 arrays to determine which is "smaller"

        System.out.println(Arrays.mismatch(new String[]{"a"}, new String[]{"A"}));
        // compare 2 arrays and return the index of the first mismatch
    }
}
