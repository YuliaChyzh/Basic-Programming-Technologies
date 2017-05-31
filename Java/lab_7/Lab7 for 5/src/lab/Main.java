package lab;

import java.util.ArrayList;
import java.util.Scanner;

// 14
public class Main {
    public static void sortSum(ArrayList<Tax> sum_mass) // Сортування
    {
        try {
            if (sum_mass.size()==0)  throw new MyException();
            for (int i = 0; i < sum_mass.size() - 1; i++) {
                for (int j = i + 1; j < sum_mass.size(); j++) {
                    if (sum_mass.get(i).getTax() > sum_mass.get(j).getTax()) {
                        Tax temp = sum_mass.get(i);
                        sum_mass.set(i, sum_mass.get(j));
                        sum_mass.set(j, temp);
                    }
                }
            }
        }

        catch (MyException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        try {
            ArrayList<Tax> taxes = new ArrayList<Tax>(); // Масив податків різних сум
            Scanner scanner = new Scanner(System.in);
            double temp1,temp2,temp3,temp4,temp5,temp6;
            double zarplata;

            System.out.println("Введіть 'чорну' зарплату");
            zarplata = scanner.nextDouble();

            System.out.println("Введіть податок на пільги дітей");
            temp1 = scanner.nextDouble();
            taxes.add(new Tax_child_benefits(temp1));

            System.out.println("Введіть податок на грошові пільги");
            temp2 = scanner.nextDouble();
            taxes.add(new Tax_money_benefits(temp2));

            System.out.println("Введіть податок на грошові подарунки");
            temp3 = scanner.nextDouble();
            taxes.add(new Tax_money_present(temp3));

            System.out.println("Введіть податок на продаж майна");
            temp4 = scanner.nextDouble();
            taxes.add(new Tax_property_sale(temp4));

            System.out.println("Введіть податок на перекази через кордон");
            temp5 = scanner.nextDouble();
            taxes.add(new Tax_transfers(temp5));

            System.out.println("Введіть податок зарплатню з основного місця роботи");
            temp6 = scanner.nextDouble();
            taxes.add(new Tax_work_place(temp6));

            if (taxes.size()!=6) throw new MyException();

            sortSum(taxes);
            double sum = 0.0;
            for (int i = 0; i < taxes.size(); i++) {
                sum += taxes.get(i).getTax();
                if (i != taxes.size() - 1)
                    System.out.print(taxes.get(i) + " , ");
                else
                    System.out.print(taxes.get(i));
            }
            System.out.println("\n");
            System.out.println("\nЗагальна сума податку становить " + sum+", з них: ");
            System.out.println(zarplata*0.01*temp1+" - податок на пільги дітей;\n");
            System.out.println(zarplata*0.01*temp2+" - податок на грошові пільги;\n");
            System.out.println(zarplata*0.01*temp3+" - податок на грошові подарунки;\n");
            System.out.println(zarplata*0.01*temp4+" - податок на продаж майна;\n");
            System.out.println(zarplata*0.01*temp5+" - податок на перекази через кордон;\n");
            System.out.println(zarplata*0.01*temp6+" - податок зарплатню з основного місця роботи;\n\n");

            System.out.println("'Чиста' зарплата становить " + zarplata*(1-0.01*sum));

        }
        catch(MyException e)
        {
            e.printStackTrace();
        }

        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
