package Classes;

import java.awt.Point;
import java.util.Objects;
import AbstractClasses.Character;
import Enums.*;
import Exceptions.HeightException;
import Exceptions.PointException;
import Interfaces.*;


public class Person extends Character implements Viewable {
    public Person(String name, Point p, Status status, EnergyState state, Clothes... clothes) throws PointException {
        super(name);
        this.status = status;
        this.MainState = state;
        setClothes(clothes);
        if (p == null || p.x < 0 || p.y < 0) {
            throw new PointException();
        }
        point = p;
    }

    public Person(String name, Status status, EnergyState state) {
        super(name);
        this.status = status;
        this.MainState = state;
    }

    public Person(String name, Status status, EnergyState state, int height, PersonFeatures[] personFeatures,
            Clothes... clothes) {
        super(name);
        setClothes(clothes);
        this.status = status;
        this.height = height;
        this.MainState = state;
        if (personFeatures == null) {
            PersonFeatures[] p = new PersonFeatures[] { PersonFeatures.NOTHING };
            this.personFeatures = p;
        } else {
            this.personFeatures = personFeatures;
        }

    }

    private int height;
    private Status status;
    private Point point;
    private EnergyState MainState;
    private Clothes[] clothes;
    private PersonFeatures[] personFeatures;

    public EnergyState getMainState() {
        if (this.MainState == null) {
            return EnergyState.SAVING;
        }
        return this.MainState;
    }

    public void setMainState(EnergyState main) {
        this.MainState = main;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public void setClothes(Clothes[] clothes) {
        this.clothes = clothes;
    }

    public PersonFeatures[] getPersonFeatures() {
        if (personFeatures == null) {
            PersonFeatures[] p = new PersonFeatures[] { PersonFeatures.NOTHING };
            return p;
        }
        return personFeatures;
    }

    public String getHeight() {
        if (this.height <= 0) {
            throw new HeightException();
        }
        return " его рост:" + height;
    }

    public Point getPoint() {
        if (point == null) {
            return new Point(0, 0);
        }
        return point;
    }
    public Status getStatus() {
        return status;
    }

    public String printClothes() {
        if (clothes == null || clothes.length == 0) {
            return " одет ни во что,";
        }
        StringBuilder wear = new StringBuilder(" одет в ");
        for (int i = 0; i < clothes.length; i++) {
            wear.append(clothes[i].description());
        }
        return wear.toString();
    }

    @Override
    public String viewable() {
        return this.getName() + status.getDescription() + printClothes();
    }

    public void convertView() {
        switch (getMainState()) {
            case SAVING, MIDDLE -> {
                System.out.println("энергии " + getMainState().getEnergy() + getMainState().printDescription()+ getName()
                        + ": осмотр");
                setStatus(Status.NOTHING);
            }
            default -> {
                setStatus(Status.SEEING);
            }
        }
    }

    public void convertMove() {
        switch (getMainState()) {
            case SAVING, MIDDLE -> {
                System.out.println("энергии " + getMainState().getEnergy() + getMainState().printDescription() + getName()
                        + ": передвижение");
                setStatus(Status.NOTHING);
            }
            default -> {
                setStatus(Status.MOVING);
            }
        }
    }

    public void convertPoke() {
        switch (this.getMainState()) {
            case SAVING, MIDDLE -> {
                System.out.println("энергии " + getMainState().getEnergy() + getMainState().printDescription() + getName()
                        + ": тыкание");
                setStatus(Status.NOTHING);
            }
            default -> {
                setStatus(Status.POKING);
            }
        }
    }

    public void convertThink() {
        switch (this.getMainState()) {
            case SAVING, MIDDLE -> {
                System.out.println("энергии " + getMainState().getEnergy() + getMainState().printDescription() + getName()
                        + ": осмысление");
                setStatus(Status.NOTHING);
            }
            default -> {
                setStatus(Status.THINKING);
            }
        }
    }

    public void convertCut() {
        switch (this.getMainState()) {
            case SAVING -> {
                System.out.println("энергии " + getMainState().getEnergy() + getMainState().printDescription() + getName()
                        + ": стрижка");
                setStatus(Status.NOTHING);
            }
            default -> {
                setStatus(Status.CUT);
            }
        }
    }

    public void convertViewFeatures() {
        switch (getMainState()) {
            case SAVING, MIDDLE -> {
                System.out.println("энергии " + getMainState().getEnergy() + getMainState().printDescription() + getName()
                        + ": осмотр персонажа");
                setStatus(Status.NOTHING);
            }
            default -> {
                setStatus(Status.VIEWFEATURES);
            }
        }
    }

    
    public void relax() {
        int p = MainState.getEnergy();
        while (p != 100) {
            p += 35;
            System.out.println(getName() + Status.RELAX.getDescription() + "у него " + p + " энергии");

        }
        MainState = EnergyState.READY;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o))
            return false;
        Person person = (Person) o;
        return (Objects.equals(height, person.height) && Objects.equals(MainState, person.MainState)
                && Objects.equals(status, person.status) && Objects.equals(clothes, person.clothes)
                && Objects.equals(point, person.point));
    }

    @Override
    public int hashCode() {
        return Objects.hash(height * 123 + getPoint().x * 897 + getPoint().y * 763);

    }

    @Override
    public String toString() {
        return getName();
    }

}