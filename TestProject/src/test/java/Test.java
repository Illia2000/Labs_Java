import static org.junit.Assert.*;
import static java.lang.Math.*;

public class Test {
    @org.junit.Test
    public void TestConst(){
        Function a = new ConstFunction(10);
        Function b = new ConstFunction(20);

        assertEquals(a.calculate(14),10.0,0.0001);
        assertEquals(b.calculate(8),20.0,0.0001);

        assertEquals(a.derivative().calculate(14), 0,0.0001);
        assertEquals(b.derivative().calculate(8), 0,0.0001);

    }
    @org.junit.Test
    public void TestLinear(){
        Function a = new LinearFunction(6);
        Function b = new LinearFunction(3);

        assertEquals(a.calculate(10),60.0,0.0001);
        assertEquals(b.calculate(5),15.0,0.0001);

        assertEquals(a.derivative().calculate(10), 6.0,0.0001);
        assertEquals(b.derivative().calculate(20), 3.0,0.0001);

    }
    @org.junit.Test
    public void TestSin(){
        Function a = new ConstFunction(8);
        Function a1 = new LinearFunction(4);
        Function b = new SinFunction(a);
        Function b1 = new SinFunction(a1);

        assertEquals(b.calculate(10),sin(8),0.0001);
        assertEquals(b1.calculate(10),sin(40),0.0001);


        assertEquals(b.derivative().calculate(10), cos(8)*0,0.0001);
        assertEquals(b1.derivative().calculate(10), cos(40)*4,0.0001);
    }
    @org.junit.Test
    public void TestCos(){
        Function a = new ConstFunction(8);
        Function a1 = new LinearFunction(4);
        Function b = new CosFunction(a);
        Function b1 = new CosFunction(a1);

        assertEquals(b.calculate(10),cos(8),0.0001);
        assertEquals(b1.calculate(10),cos(40),0.0001);

        assertEquals(b.derivative().calculate(10), -sin(8)*0,0.0001);
        assertEquals(b1.derivative().calculate(10), -sin(40)*4,0.0001);
    }
    @org.junit.Test
    public void TestPower(){
        Function a = new ConstFunction(20);
        Function a1 = new LinearFunction(5);
        Function b = new PowerFunction(2, a);
        Function b1 = new PowerFunction(2, a1);

        assertEquals(b.calculate(10),400,0.0001);
        assertEquals(b1.calculate(10),2500,0.0001);

        assertEquals(b.derivative().calculate(10), 2*0*pow(20,1),0.0001);
        assertEquals(b1.derivative().calculate(10), 2*5*pow(50,1),0.0001);
    }
    @org.junit.Test
    public void TestMult(){
        Function a = new ConstFunction(8);
        Function c = new LinearFunction(4);
        Function b = new MultFunction(a, c);
        Function b1 = new MultFunction(c, c);

        assertEquals(b.calculate(10),320,0.0001);
        assertEquals(b1.calculate(10),1600,0.0001);

        assertEquals(b.derivative().calculate(10), 8*4,0.0001);
        assertEquals(b1.derivative().calculate(10), 4*40+40*4,0.0001);
    }
    @org.junit.Test
    public void TestSum(){
        Function a = new ConstFunction(8);
        Function c = new LinearFunction(4);
        Function b = new SumFunction(a, c);
        Function b1 = new SumFunction(c, c);

        assertEquals(b.calculate(10),48,0.0001);
        assertEquals(b1.calculate(10),80,0.0001);

        assertEquals(b.derivative().calculate(10), 4,0.0001);
        assertEquals(b1.derivative().calculate(10), 8,0.0001);
    }
    @org.junit.Test
    public void TestFrac(){
        Function a = new ConstFunction(8);
        Function c = new LinearFunction(4);
        Function b = new FracFunction(a, c);
        Function b1 = new FracFunction(c, c);

        assertEquals(b.calculate(10),8.0/40,0.0001);
        assertEquals(b1.calculate(10),40.0/40,0.0001);

        assertEquals(b.derivative().calculate(10), -8.0/400,0.0001);
        assertEquals(b1.derivative().calculate(10), 0,0.0001);
    }
    @org.junit.Test
    public void TestDiff(){
        Function a = new ConstFunction(8);
        Function c = new LinearFunction(5);
        Function c1 = new LinearFunction(4);
        Function b = new DiffFunction(a, c);
        Function b1 = new DiffFunction(c1, c);


        assertEquals(b.calculate(10),-42,0.0001);
        assertEquals(b1.calculate(10),-10,0.0001);

        assertEquals(b.derivative().calculate(10), -5,0.0001);
        assertEquals(b1.derivative().calculate(10), -1,0.0001);
    }
    @org.junit.Test
    public void TestModule(){
        Function a = new ConstFunction(-10);
        Function b = new LinearFunction(-20);
        Function a1 = new ModuleFunction(a);
        Function b1 = new ModuleFunction(b);;

        assertEquals(a1.calculate(10),10.0,0.0001);
        assertEquals(b1.calculate(10),200.0,0.0001);

        assertEquals(a1.derivative().calculate(10), 0,0.0001);
        assertEquals(b1.derivative().calculate(10), 20,0.0001);

    }
    @org.junit.Test
    public void TestLn(){
        Function a = new ConstFunction(1);
        Function b = new LinearFunction(10);
        Function a1 = new LnFunction(a);
        Function b1 = new LnFunction(b);

        assertEquals(a1.calculate(10),0,0.0001);
        assertEquals(b1.calculate(10),4.605170186,0.0001);

        assertEquals(a1.derivative().calculate(10), 0,0.0001);
        assertEquals(b1.derivative().calculate(10), 0.1,0.0001);

    }
    @org.junit.Test
    public void TestFinFPowerFunction(){
        Function a = new LinearFunction(3);
        Function b = new LinearFunction(2);
        Function c = new FinFPowerFunction(a,b);
        Function c1 = new FinFPowerFunction(b,b);

        assertEquals(c.calculate(2),1296,0.0001);
        assertEquals(c1.calculate(2),256,0.0001);

        assertEquals(c.derivative().calculate(2), 7236.24054,0.0001);
        assertEquals(c1.derivative().calculate(2), 1221.78271,0.0001);

    }
}
