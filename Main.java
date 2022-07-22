import java.io.*;
import java.net.URL;
import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int count=0;

        System.out.println("Enter a search string: ");
        String pattern = scanner.nextLine();

        File file = new File("/home/karththi/Documents/Assignment/DSA3/modules.txt");

        BufferedReader bufferedReader
                = new BufferedReader(new FileReader(file));              //fileReader open

        String line;          // it is a single line

        while ((line = bufferedReader.readLine()) != null) {

            count+= stringMatchAlgorithm(line, pattern);   // calling stringMatchAlgorithm and count how many lines have that pattern.

        }

        System.out.println("Number of matches: "+count);
        bufferedReader.close();                                        // fileReader close
    }

    public static int stringMatchAlgorithm(String text, String pattern)
    {

        int lengthOfText = text.length();         // length of Text
        int lengthOfPat = pattern.length();       // Length of pattern

        int k = 0, i = 0, j = 0;

        for (i = 0; i <= (lengthOfText - lengthOfPat); i++) {

            for (j = 0; j < lengthOfPat; j++)
            {
                if (text.charAt(i + j) != pattern.charAt(j))
                    break;
            }

            if (j == lengthOfPat)
            {
                k++;
                System.out.println(text);
                return 1;
            }
        }

        return 0;
    }
}
