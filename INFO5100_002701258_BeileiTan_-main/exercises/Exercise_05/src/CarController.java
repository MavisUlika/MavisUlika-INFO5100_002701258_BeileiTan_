// 3rd step: create controller that is responsible for updating the model and/or view as a response
// from the user’s input
public class CarController {
    private CarModel model;
    private CarView view;

    public CarController(CarModel model, CarView view){
        this.model = model;
        this.view = view;
    }

    public void setCarName(String name){
        model.setName(name);
    }

    public String getCarName(){
        return model.getName();
    }

    public void setCarEngine(int speed){
        model.setSpeed(speed);
    }

    public int getCarEngine(){
        return model.getSpeed();
    }

    public void updateView(){
        view.printCarSpeedDetail(model.getSpeed(), model.getName());
    }
}
