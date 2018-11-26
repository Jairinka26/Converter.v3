public class Controller implements IModelChanged,IController {
    View view;
    Model model;

    Controller (){
        startView();
        startModel();
        view.defineControler(this);
        view.listeners();
    }

    // draw view
    void startView(){
        view = new View();
        view.createView();
    }

    void startModel(){
        model = new Model();
    }

    @Override
    public void buttonPressed(double value, String buttonName){
        model.devinedModelChanged(this);
        model.updateModel(value,buttonName);
    }
//    @Override
//    public void buttonPressed(){
//        model.hystory
//
//    }

    IUpdateView updateView;

    @Override
    public void definedCallBack(IUpdateView updateView){
        this.updateView = updateView;
    }

    @Override
    public void modelChanged(Double result) {
        updateView.updateView(result);
    }
}
