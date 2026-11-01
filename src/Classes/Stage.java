package Classes;
import Enums.PlanetsAndSatellites;
import java.awt.Point;
public class Stage  {
    public Stage(Person[] persons, Person MainCharacter , Hill hill,PlanetsAndSatellites Planet){
        this.persons=persons;
        this.Planet=Planet;
        this.MainCharacter=MainCharacter;
        this.hill=hill;
    }
    private Person MainCharacter;
    private Person[] persons;
    private Flower[] flowers;
    private Bushes[] bushes;
    private Hill hill;
    private PlanetsAndSatellites Planet;
    
    public PlanetsAndSatellites  getPlanet(){
        return this.Planet;
    }
    public Point getHillPoint(){
        return this.hill.getPoint();
    }
    public  Person getMainCharacter(){
        return this.MainCharacter;
    }
    public void setFlowers(Flower[] flowers) {
        this.flowers = flowers;
    }
    public void setBushes(Bushes[] bushes){
        this.bushes=bushes;
    }
    

    public String getStageContain(){
        StringBuilder contain=new StringBuilder();
        if (MainCharacter.getPoint().x>=hill.getPoint().x && MainCharacter.getPoint().y>=hill.getPoint().y ){

        
        if (flowers!=null){
        for (int i=0;i<flowers.length;i++){
            contain.append( flowers[i].viewable()+ ", ");
        }}
        if (bushes!=null){
        for (int i=0;i<bushes.length;i++){
            contain.append( bushes[i].viewable()+ ", ");
        }}
        for (int i=0;i<persons.length;i++){
            if (persons[i]!= MainCharacter){
                contain.append(persons[i].viewable()+ " " );
            }
        }
        
        }
        else{
            contain.append(hill.viewable()+" ");
        }
        return contain.toString();
    }
    
}
