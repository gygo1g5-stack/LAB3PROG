package Classes;

import java.util.Random;
import  java.awt.Point;

import Exceptions.HillException;
import Exceptions.PokeException;
import Record.Item;
import Enums.*;

public class Action {
    public Action(Person person){
        p=person;
    }
    Person p;

    public void view(Stage stage) {
        if (p == stage.getMainCharacter()) {
            if (p.getStatus() == Status.SEEING ) {
                System.out.println(p.getName() + Status.SEEING.getDescription()+ stage.getStageContain());
                p.setMainState(EnergyState.MIDDLE);
                p.setStatus(Status.NOTHING);
            } else {
                System.out.println(p.getName() + " не " +Status.SEEING.getDescription());
            }
        } else {
            System.out.println(p.getName() + " ничего не осматривает, ведь не главный персонаж");
        }
    }

    public void uphill(Stage stage) {
        if (p.getStatus() == Status.MOVING && new Random().nextBoolean()) {

            while (p.getPoint().x < stage.getHillPoint().x || p.getPoint().y < stage.getHillPoint().y) {
                p.setPoint(new Point(++p.getPoint().x, ++p.getPoint().y));
                System.out.println(p.getName() + Status.MOVING.getDescription() + p.getPoint().y + " метра ");

            }
            System.out.println("Поднялся на холм");
            p.setMainState(EnergyState.SAVING);
            p.setStatus(Status.NOTHING);
        } else {
            System.out.println(p.getName() + " не в состоянии " + Status.MOVING.getDescription());
        }
    }

    public void poke(Person b, Item c) {
        if (p.getStatus() == Status.POKING && new Random().nextBoolean()) {
            System.out.println(p.getName() + Status.POKING.getDescription() + b.getName() + " в спину предметом "
                    + c.name() + " длины " + c.lengthInCm()+"cm ,"+ b.getName() + EnergyState.READY.printDescription());
            b.setMainState(EnergyState.READY);
            p.setMainState(EnergyState.SAVING);
            p.setStatus(Status.NOTHING);
        } else {
            System.out.println(p.getName() + " не готов "+Status.POKING.getDescription()+" "+b.getName());
            throw new PokeException(b.getName()+" не знает, что делать");
        }
    }

    public void thinkFlowers(Stage stage, Flower[] flowers, DopAction... dopActions) {
        if (p.getStatus() == Status.THINKING && stage.getMainCharacter().getPoint().x >= stage.getHillPoint().x
                && stage.getMainCharacter().getPoint().y >= stage.getHillPoint().y) {
            StringBuilder s =new StringBuilder();
            for (int i=0; i<dopActions.length;i++){
                switch (dopActions[i]) {
                    case UNDERSTANDSPLACE -> {s.append(p.getName() + dopActions[i].getDescription() + stage.getPlanet().getTitle()+"\n");}
                    case COMPARESIZEFLOWERS->{s.append(dopActions[i].getDescription() + flowers[0].getLength().getSizeInSm()+ "-- cm "+"\n");}
                    default ->{s.append(dopActions[i].getDescription());}
            }
        }
            if (stage.getPlanet().getGravity() < 9.8) {
                s.append("на " + stage.getPlanet().getTitle());
            } else {
                s.append("к таким размерам цветов");
            }
            p.setMainState(EnergyState.MIDDLE);
            p.setStatus(Status.NOTHING);
            System.out.println(s);
        } else if (stage.getMainCharacter().getPoint().x < stage.getHillPoint().x
                || stage.getMainCharacter().getPoint().y < stage.getHillPoint().y) {
            throw new HillException();
        } else {
            System.out.println(p.getName() + " не готов" + Status.THINKING.getDescription());
        }
    }

    public void viewFeatures(Person p2) {
        if (p.getStatus() == Status.VIEWFEATURES ) {
            StringBuilder s = new StringBuilder();
            for (PersonFeatures i : p2.getPersonFeatures()) {
                s.append(i.getDescription());
            }
            System.out.println(p.getName() + Status.VIEWFEATURES.getDescription() + p2.getName() 
                    + p2.getHeight() + " cm, у него: " + s);
            p.setStatus(Status.NOTHING); 
        } else {
            System.out.println(p.getName() + " не готов " + Status.VIEWFEATURES.getDescription());
        }
    }

    public void cut (Bushes[] bushes){
        if (p.getStatus()==Status.CUT){
        for (int i=0; i<bushes.length;i++){
            int numbeforecut=bushes[i].getNumberOfLeaves();
            if (numbeforecut>=10){
            bushes[i].cutLeaves(p);
            System.out.println(p.getName()+Status.CUT.getDescription()+(numbeforecut-bushes[i].getNumberOfLeaves())+" листьев "+ bushes[i].getName());
            p.setMainState(EnergyState.MIDDLE);
            p.setStatus(Status.NOTHING);}
            else{
            System.out.println(p.getName() + " не может " + Status.CUT.getDescription()+" так как всего "+ bushes[i].getNumberOfLeaves() + " листьев " + bushes[i].getName());
            }}
        }else{
            System.out.println(p.getName() + " не готов " + Status.CUT.getDescription());
        }

    }
    public void influenceEmotion(Person p2){
        if (p.getStatus()==Status.FEELGOOD){
            System.out.println(p.getName()+" хочет познакомиться с " + p2.getName());
            p.setStatus(Status.NOTHING);
        }else if(p.getStatus()==Status.FEELPITY){
            System.out.println(p.getName()+" хочет помочь " + p2.getName());
            p.setStatus(Status.NOTHING);
        }else if (p.getStatus()==Status.FEELJEALOUS){
            System.out.println(p.getName()+" хочет уйти ");
            p.setStatus(Status.NOTHING);
            p.convertMove();
        }else{
            System.out.println(p.getName()+ " " + Status.NOTHING.getDescription());
        }
    }
    
}
