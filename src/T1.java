import java.util.Scanner;

public class T1
{
    public static void main(String[] args)
    {
        //collapseSequences();
        //test();
        //higherThanMean();
        twoDimArr();
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
        for (int value: arrayInt)
        {
            System.out.print(value + " ");
        }
    }
    public static void higherThanMean()
    //כתבו תוכנית אשר קולטת מן המשתמש מספר טבעי n . לאחר מכן, יש לקלוט n מספרים
    //שלמים נוספים. לבסוף, יש להדפיס את המספרים אשר גבוהים מן הממוצע.
    //לדוגמה, עבור הקלט 5 וחמשת המספרים הנוספים 1 2 3 4 5 הממוצע הוא 3 ולכן נדפיס
    //את 4 ו- 5
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int sum = 0;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
        {
            int number = scanner.nextInt();
            sum += number;
            arr[i] = number;
        }
        double mean = (double) sum / n;
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < n; i++)
        {
            if (arr[i] > mean)
            {
                output.append(arr[i] + " ");
            }

        }
        System.out.print(output);
    }
    public static void twoDimArr()
    //כתבו קטע קוד אשר מדפיס את האלכסון הראשי, האלכסון המשני ואת המסגרת של מערך
    //דו-מימדי ריבועי. את המסגרת יש להדפיס עם כיוון השעון החל מתא 0 0 .
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

        for (int i = 0; i < mat.length; i++)
        {
            for (int j = 0; j < mat[i].length; j++)
            {
                if (i == j)
                {
                    mainDiagonal.append(mat[i][j]);
                    if (i < mat.length - 1)
                    {
                        mainDiagonal.append(", ");
                    }
                }
                if (j == mat[i].length - (1 + i))
                {
                    secondDiagonal.append(mat[i][j]);
                    if (i < mat.length - 1)
                    {
                        secondDiagonal.append(", ");
                    }
                }
                if (i == 0)
                {
                    clockWiseCeiling.append(mat[i][j]).append(", ");
                }
                if (i > 0 && i < mat.length -1 && j == mat.length - 1)
                {
                    clockWiseRight.append(mat[i][j]).append(", ");
                }
                if (i == mat.length -1)
                {
                    floor[mat.length - 1 - j] = mat[i][j];
                }
                if (i >0 && i < mat.length -1 && j == 0)
                {
                    left[left.length - i] = mat[i][j];
                }
            }
        }
        for (int i = 0; i < mat.length; i++)
        {
            clockWiseFloor.append(floor[i]).append(", ");
        }
        for (int i = 0; i < left.length; i++)
        {
            clockWiseLeft.append(left[i]).append(", ");
        }
        System.out.println(mainDiagonal);
        System.out.println(secondDiagonal);
        System.out.print(clockWiseCeiling);
        System.out.print(clockWiseRight);
        System.out.print(clockWiseFloor);
        System.out.print(clockWiseLeft);
    }
}