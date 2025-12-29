package Chapter_3_Making_Decisions;


/*
        Supported control statement features

        | Loop Type  | Labels  | break  | continue  | yield  | when |
        |------------|---------|--------|-----------|--------|-------|
        | while      | Yes     | Yes    | Yes       | No     | No    |
        | do/while   | Yes     | Yes    | Yes       | No     | No    |
        | for        | Yes     | Yes    | Yes       | No     | No    |
        | switch     | Yes     | Yes    | No        | Yes    | Yes   |
*/


public class Flow_With_Branching {

    private static int[] searchForValue(int[][] list, int v) {
        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list[i].length; j++) {
                if (list[i][j] == v) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        // Nested Loops

        int[][] myComplexArray = {{5, 2, 1, 3}, {3, 9, 8, 9}, {5, 7, 12, 7}};

        for (int[] mySimpleArray : myComplexArray) {
            for (int i = 0; i < mySimpleArray.length; i++) {
                System.out.print(mySimpleArray[i] + "\t");
            }
            System.out.println();
        }

        int hungryHippopotamus = 8;
        while (hungryHippopotamus > 0) {
            do {
                hungryHippopotamus -= 2;
            } while (hungryHippopotamus > 5);
            hungryHippopotamus--;
            System.out.print(hungryHippopotamus + ", ");
        }
        System.out.println();

        //Optional labels

        OUTER_LOOP:
        for (int[] mySimpleArray : myComplexArray) {
            INNER_LOOP:
            for (int i = 0; i < mySimpleArray.length; i++) {
                System.out.print(mySimpleArray[i] + "\t");
            }
            System.out.println();
        }

        // Return statement
        int[][] list = {{1, 13}, {5, 2}, {2, 2}};
        int searchValue = 2;
        int[] results = searchForValue(list, searchValue);

        if (results == null) {
            System.out.print("Value " + searchValue + " not found");
        } else {
            System.out.print("Value " + searchValue + " found at: " +
                    "(" + results[0] + "," + results[1] + ")");
        }

    }
}
