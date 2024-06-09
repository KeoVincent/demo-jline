package quentin.m;

import java.io.IOException;
import java.util.Scanner;

import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;


/**
 * Hello world!
 *
 */
public class App 
{
    public static int sleepTime = 200;
    public static void main( String[] args ) throws IOException
    {
         // init reader for user prompt
        Scanner reader = new Scanner(System.in);

        clearScreen();
        System.out.println("Enter a string");
        String sentence = reader.nextLine();
        int[] terminalSize = getTerminalSize();


        printString(terminalSize, sentence);


        // close de prompt's reader
        reader.close();
    }


    //  get the width & the height of the terminal
    public static int[] getTerminalSize() throws IOException
    {
        Terminal terminal = TerminalBuilder.terminal();
        int terminalWidth = terminal.getWidth();
        int terminalHeight = terminal.getHeight();

        return new int[]{terminalWidth, terminalHeight};
    }


    // Print on the screen step by step the user's input
    public static boolean printString(int[] terminalSize, String sentence)
    {
        

        for(int i = 0; i<=sentence.length();i++){
            String newSentence = sentence.substring(0, i);
            printScreen(terminalSize, newSentence, sentence.length());
            try {
                Thread.sleep(App.sleepTime);
            } catch(InterruptedException e) {
                System.out.println("got interrupted:\n"+ e);
                return false;
            }
        }
        return true;

    }

    // Print a "frame" 
    public static boolean printScreen(int[] terminalSize, String sentence,  int sentenceLength) 
    {
        clearScreen();
        int terminalWidth = terminalSize[0];
        int terminalHeight = 7;
        for (int i=0; i < terminalHeight; i++){
            String strLine = "";
            // 

            for (int j=0; j < terminalWidth; j++){
                if (j == 0 && i ==0){
                    strLine += "╔";
                }
                else if (j == terminalWidth-1 && i ==0){
                    strLine += "╗";
                }
                else if (j == 0 && i ==terminalHeight-1){
                    strLine += "╚";
                }
                else if (j == terminalWidth-1 && i ==terminalHeight-1){
                    strLine += "╝";
                }
                else if (i==0 || i == terminalHeight-1){
                    strLine += "═";
                }
                else if (j==0 || j== terminalWidth-1) {
                    strLine += "║";
                }
                // print the sentence
                else if((j >= (terminalWidth/2)-(sentenceLength/2) && i == terminalHeight/2) && sentence.length()>0){
                    strLine += (sentenceLength-sentence.length()>0) ? sentence + "▒" : sentence + " ";
                    for(int index = 0; index < sentenceLength-sentence.length(); index++){
                        strLine += " ";
                    }
                    j+=sentenceLength;
                    sentence = "";
                }
                else{
                    strLine += " ";
                }
            }
            System.out.println(strLine);
        }
        return true;
    }

    public static boolean clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        return true;
    }
}
