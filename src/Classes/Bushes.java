package Classes;
import AbstractClasses.Character;
import Enums.PlanetsAndSatellites;
import Interfaces.Viewable;

public class Bushes extends Character implements Viewable{
    
    public Bushes(String name,Stage stage){
        super(name);
        setCharacteristic(stage.getPlanet());
        System.out.println();
    }
    private String characteristic;


    @Override 
    public String viewable(){
        return  this.characteristic + " " + this.getName() ;

    }
    private void setCharacteristic(PlanetsAndSatellites Planet){
        if (Planet==PlanetsAndSatellites.Earth){
            characteristic="земные";
        }
        else{
            characteristic="лунные";
        }
    }
    
}

