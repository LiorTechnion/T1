import java.util.Arrays;
import java.util.Scanner;


public class T1 {
    public static void main(String[] args)
    {
//    collapseSequences();
//    test();
//    higherThanMean();
//    twoDimArr();
//    matrixMultiplication();
//    System.out.println(getIdxOfMax(new int[]{1, 8, 3, 9}));
//        System.out.println(getDuplication(new int[][]{{1, 2, 3, 4},
//                                                      {5, 6, 7, 8},
//                                                      {9, 1, 2, 3},
//                                                      {4, 5, 8, 8}}));
//        System.out.println(Arrays.deepToString(nullifyWhenZero(new int[][]{{21, 0, 3, 17},
//                {9, 5, 7, 8},
//                {0, 10, 0, 12},
//                {11, 2, 19, 16}})));  
    }

    public static void collapseSequences()
    {
        Scanner scanner = new Scanner(System.in);
        String strOfChars = scanner.nextLine();
        int count = 1;
        if (strOfChars.length() > 0) {
            for (int i = 0; i < strOfChars.length(); i++) {
                char chr = strOfChars.charAt(i);
                if (i < strOfChars.length() - 1) {
                    char followingChr = strOfChars.charAt(i + 1);
                    if (chr == followingChr) {
                        count += 1;
                    } else {
                        System.out.print(chr + "" + count);
                        count = 1;
                    }
                } else {
                    System.out.print(chr + "" + count);
                }
            }
        }
    }

    public static void test()
    {
        int[] arrayInt;
        arrayInt = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int value : arrayInt) {
            System.out.print(value + " ");
        }
    }

    public static void higherThanMean()
    /*
    כתבו תוכנית אשר קולטת מן המשתמש מספר טבעי n . לאחר מכן, יש לקלוט n מספרים
    שלמים נוספים. לבסוף, יש להדפיס את המספרים אשר גבוהים מן הממוצע.
    לדוגמה, עבור הקלט 5 וחמשת המספרים הנוספים 1 2 3 4 5 הממוצע הוא 3 ולכן נדפיס
    את 4 ו- 5
    */
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int sum = 0;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int number = scanner.nextInt();
            sum += number;
            arr[i] = number;
        }
        double mean = (double) sum / n;
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (arr[i] > mean) {
                output.append(arr[i]).append(" ");
            }

        }
        System.out.print(output);
    }

    public static void twoDimArr()
    /*
    כתבו קטע קוד אשר מדפיס את האלכסון הראשי, האלכסון המשני ואת המסגרת של מערך
    דו-מימדי ריבועי. את המסגרת יש להדפיס עם כיוון השעון החל מתא 0 0 .
    */
    {
        int[][] mat = new int[][]{{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 1, 2, 3},
                {4, 5, 8, 9}};

        StringBuilder mainDiagonal = new StringBuilder();
        StringBuilder secondDiagonal = new StringBuilder();
        StringBuilder clockWiseCeiling = new StringBuilder();
        StringBuilder clockWiseRight = new StringBuilder();
        int[] floor = new int[mat[0].length];
        StringBuilder clockWiseFloor = new StringBuilder();
        int[] left = new int[mat.length - 2];
        StringBuilder clockWiseLeft = new StringBuilder();

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (i == j) {
                    mainDiagonal.append(mat[i][j]);
                    if (i < mat.length - 1) {
                        mainDiagonal.append(", ");
                    }
                }
                if (j == mat[i].length - (1 + i)) {
                    secondDiagonal.append(mat[i][j]);
                    if (i < mat.length - 1) {
                        secondDiagonal.append(", ");
                    }
                }
                if (i == 0) {
                    clockWiseCeiling.append(mat[i][j]).append(", ");
                }
                if (i > 0 && i < mat.length - 1 && j == mat.length - 1) {
                    clockWiseRight.append(mat[i][j]).append(", ");
                }
                if (i == mat.length - 1) {
                    floor[mat.length - 1 - j] = mat[i][j];
                }
                if (i > 0 && i < mat.length - 1 && j == 0) {
                    left[left.length - i] = mat[i][j];
                }
            }
        }
        for (int i = 0; i < mat.length; i++) {
            clockWiseFloor.append(floor[i]).append(", ");
        }
        for (int j : left) {
            clockWiseLeft.append(j).append(", ");
        }
        System.out.println(mainDiagonal);
        System.out.println(secondDiagonal);
        System.out.print(clockWiseCeiling);
        System.out.print(clockWiseRight);
        System.out.print(clockWiseFloor);
        System.out.print(clockWiseLeft);
    }

    public static void matrixMultiplication()
    /*
    כתבו קטע קוד אשר כופל שני מערכים דו-מימדיים.
    הכפל מתבצע כפי שמתבצע כפל מטריצות.
    ניתן להניח שמימדי המערכים תואמים.
     */
    {
        final int[][] MAT_ONE = {{1, 1, 1},
                {2, 2, 2},
                {3, 3, 3}};

        final int[][] MAT_TWO = {{1, 1, 1},
                {2, 2, 2},
                {3, 3, 3}};

        int[][] matResOfMulti = new int[3][3];

        int i = 0;
        int j = 0;
        int k = 0;
        while (i < matResOfMulti.length) {
            while (j < matResOfMulti[0].length) {
                for (; k < matResOfMulti.length; k++) {
                    matResOfMulti[i][j] += (MAT_ONE[i][k] * MAT_TWO[k][i]);
                }
                j++;
                k = 0;
            }
            i++;
            j = 0;
        }
        System.out.print(Arrays.deepToString(matResOfMulti));
    }

    public static int getIdxOfMax(int[] arr)
    /*
כתבו פעולה אשר מקבלת מערך של מספרים שלמים ומחזירה את האינדקס של המספר
המקסימלי.
במידה והמספר המקסימלי מופיע כמה פעמים, יש להחזיר את האינדקס האחרון.
במידה והמערך ריק, יש להחזיר 1 .
    */
    {
        if (arr.length == 0) {
            return -1;
        }
        int idxOfMax = 0;
        int valMax = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= valMax) {
                idxOfMax = i;
                valMax = arr[i];
            }

        }
        return idxOfMax;
    }

    public static String getDuplication(int[][] arr)
    /*
    כתבו פעולה המקבלת מערך דו-מימדי של מספרים שלמים ומדפיסה את הכפילויות שבו.
במידה ויש מספרים אשר מופיעים יותר מפעמיים, יש להדפיס אותם כמה פעמים.
במידה וכל המספרים מופיעים פעם אחת בלבד, יש להדפיס כי אין כפילויות.
     */
    {
        int[] matInRow = new int[arr.length * arr.length];
        StringBuilder output = new StringBuilder();
        int k = 0;
        for (int[] ints : arr) {
            for (int anInt : ints) {
                matInRow[k] = anInt;
                k++;
            }
        }
        int valMax = Integer.MIN_VALUE;
        int valMin = Integer.MAX_VALUE;
        for (int item : matInRow) {
            if (item >= valMax) {
                valMax = item;
            }
            if (item <= valMin) {
                valMin = item;
            }
        }
        int m = (valMax - valMin) + 2;
        int[] hist = new int[m];
        for (int value : matInRow) {
            hist[value - valMin] += 1;
        }
        k = 0;
        int q = 0;
        boolean flagIfThereIsDuplicates = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < hist[i]; j++) {
                matInRow[k] = i + valMin;
                if (q < hist.length) {
                    if (hist[q] > 1) {
                        flagIfThereIsDuplicates = true;
                    }
                }
                k += 1;
                q += 1;
            }
        }
        if (!flagIfThereIsDuplicates) {
            return "There is no duplicates";
        }
        for (int i = 0; i < matInRow.length - 1; i++) {
            if (matInRow[i] == matInRow[i + 1]) {
                output.append(matInRow[i]).append(", ");
            } else {
                if (i > 2 && (matInRow[i] == matInRow[i - 2])) {
                    output.append(matInRow[i]).append(", ");
                }
            }
        }
        return String.valueOf(output);
    }

    public static int[][] nullifyWhenZero(int[][] arr)
    /*
    כתבו פעולה אשר מקבלת מערך דו-מימדי של מספרים שלמים ועבור כל תא בו מופיע המספר
    אפס, מאפסת את השורה והעמודה של תא זה במערך.
     */
    {
        int lenOfRow = arr.length;
        int lenOfCol = arr[0].length;
        int[][] nullifyRow = new int[lenOfRow][lenOfCol];
        int[][] nullifyCol = new int[lenOfRow][lenOfCol];
        for (int i = 0; i < lenOfRow; i++)
        {
            for (int j = 0; j < lenOfCol; j++)
            {
                nullifyRow[i][j] = arr[i][j];
                nullifyCol[i][j] = arr[i][j];
            }
        }
        for (int i = 0; i < lenOfRow; i++)
        {
            for (int j = 0; j < lenOfCol; j++)
            {
                if (arr[i][j] == 0)
                {
                    for (int k = 0; k < lenOfRow; k++)
                    {
                        nullifyRow[i][k] = 0;
                        nullifyCol[k][j] = 0;
                    }
                }

            }
        }
        for (int i = 0; i < lenOfRow; i++)
        {
            for (int j = 0; j < lenOfCol; j++)
            {
                if (nullifyRow[i][j] == 0 || nullifyCol[i][j] == 0)
                {
                    arr[i][j] = 0;
                }
            }
        }
        return arr;
    }
}