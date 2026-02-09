class Engine{
    private String type;
    private int horsepower;

    public Engine(String type,int horsepower){
        this.type =type;
        this.horsepower=horsepower;

    }
    public void displayEngineDetails(){
        System.out.println("Engine Type : "+ type);
        System.out.println("Horsepower : " + horsepower);
    }
}
class Car{
    private String model;
    private String color;
    private Engine engine;

    public Car(String model,String colour,Engine engine){
        this.model= model;
        this.color = colour;
        this.engine= engine;
    }
    public void displayCarDetails(){
        System.out.println("Car Model :" +model);
        System.out.println("Car Coour :" +color);
        engine.displayEngineDetails();
    }
}
public class CarAndEngine{
    public static void main(String[] args) {
        Engine egn =new Engine("Ta8",339);
        Car cr =new Car("Tata Puch","Black",egn);
        cr.displayCarDetails();
    }

}