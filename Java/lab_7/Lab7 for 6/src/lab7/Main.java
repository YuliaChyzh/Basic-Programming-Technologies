package lab7;


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

            if (s.size()==0) throw new MyException();
            s.printColl();

        }
        catch (MyException e) {
            e.printStackTrace();
        }

        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
