import java.util.ArrayList;
import java.util.Scanner;


public class Main {


    public static void main(String[] args) {
        try {
            Coll<Tax> s = new Coll<Tax>() {};


            s.add(new Tax(12));
            s.add(new Tax(13));
            s.add(new Tax(14));
            s.add(new Tax(14));
            s.add(new Tax(13));
            s.add(new Tax(14));

            s.printColl();

        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
