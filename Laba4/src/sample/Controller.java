package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class Controller {
    public RadioButton function1;
    public RadioButton function2;
    public Label func;
    public TextField variable;
    public Label sol;
    public TextField xstart;
    public TextField xfinish;
    public LineChart<String, Double> chart;
    double x = 1.825;
    double y = 18.225;
    double z = -3.298;
    Function first = new ModuleFunction(new DiffFunction(new FinFPowerFunction(new LinearFunction(1),new FracFunction(new ConstFunction(y),new LinearFunction(1))),new PowerFunction(1.0/3,(new FracFunction(new ConstFunction(y),new LinearFunction(1))))));
    Function second = new MultFunction(new DiffFunction(new ConstFunction(y),new LinearFunction(1)),new FracFunction(new DiffFunction(new ConstFunction(y),new FracFunction(new ConstFunction(z),new DiffFunction(new ConstFunction(y),new LinearFunction(1)))),new SumFunction(new ConstFunction(1),new PowerFunction(2,new DiffFunction(new ConstFunction(y),new LinearFunction(1))))));

    Function general = new ConstFunction(0);

    public void initialize(){
        function1.setText(first.print());
        function2.setText(second.print());
    }

    @FXML
    void set(ActionEvent event){

        if(function1.isSelected()){
            general = first;
        }
        if(function2.isSelected()){
            general = second;
        }
        func.setText("y = "+general.print());
    }

    public void derivative(ActionEvent actionEvent) {
        general = general.derivative();
        func.setText("y = "+general.print());
    }

    public void calculate(ActionEvent actionEvent) {
        sol.setText("y = "+general.calculate(Double.parseDouble(variable.getText())));
    }

    public void drawchart(ActionEvent actionEvent) {
        final XYChart.Series<String, Double> series = new XYChart.Series<>();
        double x0 = Double.parseDouble(xstart.getText());
        double xn = Double.parseDouble(xfinish.getText());
        if(x0>xn){
            double x = x0;
            x0 = xn;
            xn = x;
        }
        for(double i = x0;i<xn;i+=(xn-x0)/20){
            double x = i;
            double y = general.calculate(x);
            series.getData().add(new XYChart.Data<>(String.format("%.2f",x),y));
        }
        chart.getData().clear();
        chart.getData().add(series);
    }
}
