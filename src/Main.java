import Classes.*;
import Enums.Color;
import Enums.DopAction;
import Enums.EnergyState;
import Enums.PersonFeatures;
import Enums.PlanetsAndSatellites;
import Enums.Status;
import Record.*;
import java.awt.Point;
import Exceptions.*;
import java.util.Random;


public class Main {
    public static void main(String[] args)  {
        
        Person neznaika=new Person("Незнайка", new Point(1,1),Status.NOTHING,EnergyState.MIDDLE);
        Person fiks=new Person("Фикс",Status.NOTHING,EnergyState.READY);
        
        Person[] persons={new Person("Клопс",Status.SITING,choiceState(),150, new PersonFeatures[]{PersonFeatures.NARROWEYES,PersonFeatures.PINKBALDSPOT,PersonFeatures.REDCHEEKS,PersonFeatures.FUNNYFACE}, new Clothes("пижама",Color.BROWN,true,"шёлковая"), new Clothes("шлепанцы",Color.BLUE,false))
        ,neznaika, new Person("Коротышка",Status.NOTHING,choiceState(),120,new PersonFeatures[]{PersonFeatures.NOTHING} )
        };
        Hill hill=new Hill(new Point(3,3));
        // Person klops= new Person("Клопс",Status.SITING,choiceState(),150, new PersonFeatures[]{PersonFeatures.NARROWEYES,PersonFeatures.PINKBALDSPOT,PersonFeatures.REDCHEEKS,PersonFeatures.FUNNYFACE}, new Clothes("пижама",Color.BROWN,true,"шёлковая"), new Clothes("шлепанцы",Color.BLUE,false));
        Stage OneStage=new Stage(persons,neznaika,hill,choice());
        Flower[] flowers={new Flower("астра",OneStage),new Flower("настурции",OneStage),new Flower("маргаритки",OneStage)};
        Bushes[] bushes ={new Bushes("кусты сирени",OneStage,300),new Bushes("кусты малины", OneStage, 300)};
        OneStage.setBushes(bushes);
        OneStage.setFlowers(flowers);
        Item broom=new Item("метла",50);
        System.out.println();
    
    
        
        persons[2].convertCut();
        new Action(persons[2]).cut(bushes); 
        fiks.convertPoke();
        try{
        new Action(fiks).poke(neznaika, broom);}
        catch (PokeException e){
            System.out.println(e.getMessage());
        }
        neznaika.convertMove();
        new Action(neznaika).uphill(OneStage);
        neznaika.relax();
        neznaika.convertView();
        new Action(neznaika).view(OneStage);;
        neznaika.relax();
        neznaika.convertThink();
        try{
        new Action(neznaika).thinkFlowers(OneStage,flowers,DopAction.UNDERSTANDSPLACE,DopAction.COMPARESIZEFLOWERS,DopAction.HABITUATION);}
        catch (HillException e){
            System.out.println(e.getMessage());
        }
        neznaika.relax();
        neznaika.convertViewFeatures();
        new Action(neznaika).viewFeatures(persons[0]);
        choiceImpact().aply(neznaika,persons[0]);
        new Action(neznaika).influenceEmotion(persons[0]);
        
        
 

    }
    public static PlanetsAndSatellites choice(){
        if (new Random().nextBoolean()){
            return PlanetsAndSatellites.Earth;
        }
        return PlanetsAndSatellites.Moon;
    }
    public static Impact choiceImpact(){
        if (new Random().nextBoolean()){
            return new GoodImpact();
        }
        return new BadImpact();
    }
    public static EnergyState choiceState(){
        switch (new Random().nextInt(3)){
            case 0 -> {return EnergyState.SAVING;}
            case 1 -> {return  EnergyState.MIDDLE;}
            default -> {return EnergyState.READY;}
        }
    }
}
