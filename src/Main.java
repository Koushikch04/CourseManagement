
import CommandLine.*;
public class Main {

    public static void main(String[] args) {
        if(args.length==2) {
            if(args[0].equals("-add")) {
                AddCommand.add(args);
            }
        }
    }
}