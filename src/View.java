import javax.swing.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class View implements IUpdateView {
    private JFrame frame;
    private JPanel panel;
    private JTextField value, result;
    private JButton gramsVKilograms, gramsVUnce,celsiusToFahrenheits,kelvinsToCelsius,history;
    private JLabel historyText;
    IController controller;

    void createView(){
        frame = new JFrame();
        frame.setSize(400, 400);
        frame.setTitle("Конвертер");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel();
        frame.add(panel);

        panel.setLayout(null);
        value = new JTextField();
        value.setBounds(10,10,90,30);
        panel.add(value);
        frame.setVisible(true);
        result = new JTextField();
        result.setBounds(10,50,90,30);
        result.setEditable(false);
        panel.add(result);

        gramsVKilograms = new JButton("G to KG");
        gramsVKilograms.setName("gramsVKilograms");
        gramsVKilograms.setBounds(110, 10, 90, 30 );
        panel.add(gramsVKilograms);

        gramsVUnce = new JButton("G to Unce");
        gramsVUnce.setName("gramsVUnce");
        gramsVUnce.setBounds(210, 10, 90, 30 );
        panel.add(gramsVUnce);

        celsiusToFahrenheits = new JButton("C to F");
        celsiusToFahrenheits.setName("celsiusToFahrenheits");
        celsiusToFahrenheits.setBounds(110, 50, 90, 30 );
        panel.add(celsiusToFahrenheits);

        kelvinsToCelsius = new JButton("C to F");
        kelvinsToCelsius.setName("kelvinsToCelsius");
        kelvinsToCelsius.setBounds(210, 50, 90, 30 );
        panel.add(kelvinsToCelsius);

        history = new JButton("History");
        history.setName("history");
        history.setBounds(10, 90, 290, 30 );
        panel.add(history);

       // historyText.setLayoutOrientation(JList.VERTICAL);
//        historyText.setBounds(10, 130, 290, 100);
//        historyText.setVisible(false);
//        panel.add(historyText);
    }

    void listeners(){
        gramsVKilograms.addActionListener(e -> {
            controller.definedCallBack(this);
            controller.buttonPressed(Double.parseDouble(value.getText()), gramsVKilograms.getName());
        });

        gramsVUnce.addActionListener(e -> {
            controller.definedCallBack(this);
            controller.buttonPressed(Double.parseDouble(value.getText()), gramsVUnce.getName());
        });

        celsiusToFahrenheits.addActionListener(e -> {
            controller.definedCallBack(this);
            controller.buttonPressed(Double.parseDouble(value.getText()), celsiusToFahrenheits.getName());
        });

        kelvinsToCelsius.addActionListener(e -> {
            controller.definedCallBack(this);
            controller.buttonPressed(Double.parseDouble(value.getText()), kelvinsToCelsius.getName());
        });

//        history.addActionListener(e -> {
//            controller.definedCallBack(this);
//            controller.buttonPressed();
//        });

    }

    void defineControler (IController controller){
        this.controller = controller;
    }

    @Override
    public void updateView(Double result) {
        this.result.setText(Double.toString(result));
    }

//    @Override
//    public void showHistory (ArrayList<String> history){
//        historyText.setVisible(true);
//       // int i = 0;
//            historyText.setText("history");
//           // historyText.setText(history[0]);
//    }
}
