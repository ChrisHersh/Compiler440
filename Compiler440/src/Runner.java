import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This is the runner class
 * 
 * @author Chris Hersh
 *
 */
public class Runner
{

    /**
     * Entry point for the program, not used other than calling processFile which starts the tokenizing process
     * @param args
     * @throws FileNotFoundException
     * @throws UnsupportedEncodingException
     */
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException
    {
        processFile();
    }

    /**
     * This method will take input from the user and pass the filename to the tokenizeProgram method
     * After it gets the ArrayList back, it will print the output to a file in the same format as the assignment document
     * 
     * The output file is currently named tokenizer-output.txt
     * 
     * @throws FileNotFoundException
     * @throws UnsupportedEncodingException
     */
    public static void processFile() throws FileNotFoundException, UnsupportedEncodingException
    {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter a filename: ");
        ArrayList<Token> t = Tokenizer.tokenizeProgram(s.nextLine());
        s.close();

        PrintWriter writer = new PrintWriter("tokenizer-output.txt", "UTF-8");

        for (Token token : t)
        {
            writer.println("(" + token.token + ", " + token.tokenName + ", " + token.lineNumber + ")");
        }

        writer.close();

    }
}
