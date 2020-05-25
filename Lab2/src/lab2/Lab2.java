/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

import static java.lang.Math.*;

public class Lab2 {
    interface Function {
        double calculate(double x);

        Function derivative();
    }

    static class ConstFunction implements Function {
        private final double value;

        public ConstFunction(double value) {
            this.value = value;
        }

        @Override
        public double calculate(double x) {
            return value;
        }

        @Override
        public Function derivative() {
            return ZERO;
        }

        public static final ConstFunction ZERO = new ConstFunction(0);
    }
    static class LinearFunction implements Function {
        public final double k;

        public LinearFunction(double k) {
            this.k = k;
        }

        @Override
        public double calculate(double x) {
            return k * x;
        }

        @Override
        public Function derivative() {
            return new ConstFunction(k);
        }
    }
    
    static class MultFunction implements Function {
        public final Function a,b;

        public MultFunction(Function a,Function b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public double calculate(double x) {
            return a.calculate(x)*b.calculate(x);
        }

        @Override
        public Function derivative() {
            return new SumFunction(new MultFunction(a,b.derivative()),new MultFunction(a.derivative(),b));
        }
    }
    static class FracFunction implements Function {
        public final Function a,b;

        public FracFunction(Function a,Function b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public double calculate(double x) {
            return a.calculate(x)/b.calculate(x);
        }

        @Override
        public Function derivative() {
            return (new MultFunction(a,new PowerFunction(-1,b))).derivative();
        }
    }
    static class PowerFunction implements Function {
        public final double r;
        public final Function f;

        public PowerFunction(double k, Function f) {
            this.r = k;
            this.f = f;
        }

        @Override
        public double calculate(double x) {
            return  pow(f.calculate(x),r);
        }

        @Override
        public Function derivative() {
            return new MultFunction(new ConstFunction(r),new MultFunction(f.derivative(),new PowerFunction(r-1,f)));
        }
    }
    static class SumFunction implements Function {
        private final Function a, b;

        public SumFunction(Function a, Function b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public double calculate(double x) {
            return a.calculate(x) + b.calculate(x);
        }

        @Override
        public Function derivative() {
            return new SumFunction(a.derivative(), b.derivative());
        }

    }
    static class DiffFunction implements Function {
        private final Function a, b;

        public DiffFunction(Function a, Function b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public double calculate(double x) {
            return a.calculate(x) - b.calculate(x);
        }

        @Override
        public Function derivative() {
            return new DiffFunction(a.derivative(), b.derivative());
        }

    }
    static class ModuleFunction implements Function {
        private final Function a;

        public ModuleFunction(Function a) {
            this.a = a;
        }

        @Override
        public double calculate(double x) {
            return abs(a.calculate(x));
        }

        @Override
        public Function derivative() {
            return new MultFunction(a.derivative(),new FracFunction(a, new ModuleFunction(a)));
        }

    }
    static class LnFunction implements Function {
        private final Function a;
        public LnFunction(Function a) {
            this.a = a;
        }

        @Override
        public double calculate(double x) {
            return log(a.calculate(x));
        }

        @Override
        public Function derivative() {
            return new FracFunction(a.derivative(), a);
        }

    }
static class FinFPowerFunction implements Function {
        private final Function f;
        private final Function power;
        public FinFPowerFunction(Function f, Function power) {
            this.f = f;
            this.power = power;
        }

        @Override
        public double calculate(double x) {
            return pow(f.calculate(x),power.calculate(x));
        }

        @Override
        public Function derivative() {
            return new MultFunction(new FinFPowerFunction(f,power),(new MultFunction(power,new LnFunction(f))).derivative());
        }

    }
    
    
    public static void main(String[] args) {
   // write your code here
        double y = 18.225;
        double z = -3.298;
        double x = 1.825;
        
        final Function expression = new ModuleFunction(new DiffFunction(new FinFPowerFunction(new LinearFunction(1),new FracFunction(new ConstFunction(y),new LinearFunction(1))),new PowerFunction(1.0/3,(new FracFunction(new ConstFunction(y),new LinearFunction(1))))));
        System.out.println("c(x) = " + expression.calculate(x));
        System.out.println("c'(x) = " + expression.derivative().calculate(x));
        
        final Function expression1 = new MultFunction(new DiffFunction(new ConstFunction(y),new LinearFunction(1)),new FracFunction(new DiffFunction(new ConstFunction(y),new FracFunction(new ConstFunction(z),new DiffFunction(new ConstFunction(y),new LinearFunction(1)))),new SumFunction(new ConstFunction(1),new PowerFunction(2,new DiffFunction(new ConstFunction(y),new LinearFunction(1))))));
        System.out.println("f(x) = " + expression1.calculate(x));
        System.out.println("f'(x) = " + expression1.derivative().calculate(x));
    }
}

 