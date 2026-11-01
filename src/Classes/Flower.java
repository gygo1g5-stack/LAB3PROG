package Classes;
import AbstractClasses.Character;
import Enums.*;
import Interfaces.Viewable;

public class Flower extends Character implements Viewable{
    public Flower(String name,Stage stage){
        super(name);
        setCharacteristic(stage.getPlanet());
    }
    private String characteristic;
    private Size length;
    @Override 
    public String viewable(){
        return  this.characteristic + " " + this.getName() ;

    }
    public Size getLength() {
        return length;
    }
    private void setCharacteristic(PlanetsAndSatellites Planet){
        if (Planet==PlanetsAndSatellites.Earth){
            characteristic="земная";
            length=Size.MEDIUM;
        }
        else{
            characteristic="лунная";
            length=Size.SMALL;
        }
    }
    

}