// step 1: create a model that contains some kind of database, or just raw data.
public class CarModel {
    private int engine_speed;
    private String car_name;

    public int getSpeed(){
        return engine_speed;
    }
    public void setSpeed(int engine_speed){
        this.engine_speed = engine_speed;
    }
    public String getName(){
        return car_name;
    }
    public void setName(String car_name){
        this.car_name = car_name;
    }
}
