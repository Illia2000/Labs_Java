import java.util.Date;
import java.util.Scanner;

public class Main {
    double x, y, z, c, f;

    public static void main(String[] args) {
        Main prog = new Main();
        prog.run();
    }

    private void input(){
        Scanner s = new Scanner(System.in);
        System.out.print("Введите x: ");
        x = s.nextDouble();
        System.out.print("Введите y: ");
        y = s.nextDouble();
        System.out.print("Введите z: ");
        z = s.nextDouble();
    }

    private double calcul_c(double x, double y){
        return(Math.abs(Math.pow(x,y/x)-Math.cbrt(y/x)));
    }

    private double calcul_f(double x, double y, double z){
        return ((y-x)*(y-z/(y-x))/(1+Math.pow(y-x, 2)));
    }

    private void print(double x, double y, double z, double c, double f){
        System.out.println("x = " + x);
        System.out.println("y = " + y);
        System.out.println("z = " + z);

        System.out.println("c = "+ c);
        System.out.println("f = "+ f);
    }

    private void printDate(){
        Date d = new Date();
        System.out.printf("%1$tR %1$td-%1$tm-%1$ty\n",d);
    }

    private void run(){
        input();
        c = calcul_c(x,y);
        f = calcul_f(x, y, z);
        print(x,y,z,c,f);

        printDate();
    }
}
