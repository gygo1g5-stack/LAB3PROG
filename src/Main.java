import Classes.*;
import Enums.Color;
import Enums.EnergyState;
import Enums.PersonFeatures;
import Enums.PlanetsAndSatellites;
import Enums.Status;
import Record.*;
import java.awt.Point;
import Exceptions.*;
public class Main {
    public static void main(String[] args)  {
        try{
        Person neznaika=new Person("Незнайка", new Point(1,1),Status.NOTHING,EnergyState.SAVING);
        Person fiks=new Person("Фикс",Status.NOTHING,EnergyState.READY);
        
        Person[] persons={new Person("Клопс",Status.SITING,EnergyState.SAVING,150, new PersonFeatures[]{PersonFeatures.NARROWEYES,PersonFeatures.PINKBALDSPOT,PersonFeatures.REDCHEEKS,PersonFeatures.FUNNYFACE}, new Clothes("пижама",Color.BROWN,true,"шёлковая"), new Clothes("шлепанцы",Color.BLUE,false))
        ,neznaika, new Person("Коротышки",Status.NOTHING,EnergyState.SAVING)
        };
        
        Hill hill=new Hill(new Point(3,4));
        Stage OneStage=new Stage(persons,neznaika,hill,PlanetsAndSatellites.Earth);
        Flower[] flowers={new Flower("астра",OneStage),new Flower("настурции",OneStage),new Flower("маргаритки",OneStage)};
        Bushes[] bushes ={new Bushes("кусты сирени",OneStage)};
        OneStage.setBushes(bushes);
        OneStage.setFlowers(flowers);
        Item broom=new Item("метла");
        
        
        
        fiks.convertPoke();
        fiks.poke(neznaika,broom);
        neznaika.convertMove();
        neznaika.uphill(OneStage);
        neznaika.convertView();
        neznaika.relax();
        neznaika.convertView();
        neznaika.view(OneStage);
        neznaika.convertThink();
        neznaika.relax();
        neznaika.convertThink();
        neznaika.think(OneStage,flowers);
        neznaika.relax();
        neznaika.convertViewFeatures();
        neznaika.viewFeatures(persons[0]);
        
        
    
    
    
    }
    
        
        catch (PointException e){
            System.out.println(e.getMessage());
        }
 

        
        
        

        


    }
}
