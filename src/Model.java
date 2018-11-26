import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Model {
    private double value;
    private double result;
    Controller controller;
    IModelChanged modelChanged;
    IOperation operation,gramsVKilograms;
    HashMap<String,IOperation> listOperation;
   // ArrayList<String> hystory = new ArrayList<>();

    Model(){
        createListOperation();
    }

    void updateModel(Double value, String operation){
        this.value = value;
        this.operation = listOperation.get(operation);
        result = this.operation.calculate(value);
        modelChanged.modelChanged(result);
  //      hystory.add(0,value+" to"+ result);
    }

    void devinedModelChanged(IModelChanged modelChanged){
        this.modelChanged = modelChanged;
    }

    double calculateResult (Double value){
        return value/1000 ;
    }
// правильно ли так создавать новые объекты?
    void createListOperation (){
        listOperation = new HashMap<>();
        listOperation.put("gramsVKilograms",new GramsVKilograms());
        listOperation.put("gramsVUnce",new GramsVUnce());
        listOperation.put("celsiusToFahrenheits",new CelsiusToFahrenheits());
        listOperation.put("kelvinsToCelsius",new KelvinsToCelsius());
    }
}
