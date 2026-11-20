package Classes;
import AbstractClasses.Character;
import Enums.PlanetsAndSatellites;
import Interfaces.Viewable;

public class Bushes extends Character implements Viewable{
    
    public Bushes(String name,Stage stage,int numberOfLeaves){
        super(name);
        setCharacteristic(stage.getPlanet());
        this.numberOfLeaves=numberOfLeaves;
    }
    private String characteristic;

    private int numberOfLeaves;
    public void cutLeaves(Person p){
    
        switch (p.getMainState()){
        case SAVING -> {numberOfLeaves=numberOfLeaves-5;}
        case MIDDLE -> {numberOfLeaves=numberOfLeaves-10;}
        default -> {numberOfLeaves=numberOfLeaves-20;}
            }
        } 
    public int getNumberOfLeaves(){
        return this.numberOfLeaves;
    }
    
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

