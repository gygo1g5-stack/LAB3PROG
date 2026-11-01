package Classes;
import java.awt.Point;
import java.util.Objects;
import AbstractClasses.Character;
import Enums.*;
import Exceptions.HeightException;
import Exceptions.PointException;
import Interfaces.*;
import Record.*;
public class Person extends Character implements Viewable  {
    public Person (String name,Point p,Status status,EnergyState state,Clothes... clothes)throws PointException{
        super(name);
        this.status=status;
        this.MainState=state;
        setClothes(clothes);
        if  (p==null || p.x<0 || p.y<0){
            throw new PointException();
        }
        point=p;
    }
    public Person(String name,Status status,EnergyState state){
        super(name);
        this.status=status;
        this.MainState=state;
    }
    public Person(String name,Status status,EnergyState state,int height, PersonFeatures[] personFeatures, Clothes... clothes){
        super(name);
        setClothes(clothes);
        this.status=status;
        this.height=height;
        this.MainState=state;
        if (personFeatures==null){
            PersonFeatures[] p= new PersonFeatures[]{PersonFeatures.NOTHING};
            this.personFeatures=p;
        }else{
            this.personFeatures=personFeatures;
        }
        
    }
    private int height;
    private Status status;
    private Point point;
    private EnergyState MainState;
    private Clothes[] clothes;
    private PersonFeatures[] personFeatures;
    public EnergyState getMainState(){
        if (this.MainState==null){
            return EnergyState.SAVING;
        }
        return this.MainState;
    }
    private void setMainState(EnergyState main){
        this.MainState=main;
    }
    private void setStatus (Status status){
        this.status= status;
    }
    private void setPoint(Point point) {
        this.point = point;
    }
    public void setClothes(Clothes[] clothes){
        this.clothes=clothes;
    }
    
    public PersonFeatures[] getPersonFeatures() {
        if (personFeatures==null){
            PersonFeatures[] p= new PersonFeatures[]{PersonFeatures.NOTHING};
            return p;}
        return personFeatures;
    }
    private int getHeight() {
        if (this.height<=0){
            throw new HeightException();
        }
        return height;
    }
    public Point getPoint(){
        if (point==null){
            return new Point(0,0);
        }
        return point;
    }
    public String printClothes(){
        if (clothes==null){
            return " одет ни во что,";
        }
        StringBuilder wear = new StringBuilder(" одет в ");
        for (int i=0;i<clothes.length;i++){
            wear.append( clothes[i].description() );
        }
        return wear.toString();
    } 

    @Override 
    public String viewable  ( ){
        return this.getName() + status.getDescription() + printClothes();
    }



    
    public void convertView(){
        switch (getMainState()) {
            case SAVING , MIDDLE -> {System.out.println("энергии " + getMainState().getEnergy()+" не достаточно для действия " + getName()+": осмотр");
            setStatus(Status.NOTHING);}
            default -> {setStatus(Status.SEEING); }
        }
    }

    public void convertMove(){
        switch (getMainState()) {
            case SAVING , MIDDLE -> {System.out.println("энергии " + getMainState().getEnergy()+" не достаточно для действия " + getName()+": передвижение");
            setStatus(Status.NOTHING);}
            default-> {setStatus(Status.MOVING); }
        }
    }
    public void convertPoke(){
        switch (this.getMainState()) {
            case SAVING , MIDDLE -> {System.out.println("энергии " + getMainState().getEnergy()+" не достаточно для действия " + getName()+": тыкание");
            setStatus(Status.NOTHING);}
            default-> {setStatus(Status.POKING); }
        }
    }
    public void convertThink(){
        switch (this.getMainState()) {
            case SAVING , MIDDLE -> {System.out.println("энергии " + getMainState().getEnergy()+" не достаточно для действия " + getName()+": осмысление");
            setStatus(Status.NOTHING);}
            default-> {setStatus(Status.THINKING); }
        }
    }
    public void convertViewFeatures(){
        switch (getMainState()) {
            case SAVING , MIDDLE -> {System.out.println("энергии " + getMainState().getEnergy()+" не достаточно для действия " + getName()+": осмотр персонажа");
            setStatus(Status.NOTHING);}
            default-> {setStatus(Status.VIEWFEATURES); }
        }
    }

    public void view (Stage stage ){
        if (this==stage.getMainCharacter()){
        if (status==Status.SEEING){
        System.out.println(getName() +" осматривает " + stage.getStageContain());
        MainState=EnergyState.MIDDLE;
        setStatus(Status.NOTHING);
        }else{
            System.out.println(getName()+ " ничего не осматривает");
        }}
        else{
        System.out.println(getName() + " ничего не осматривает, ведь не главный персонаж");
        }
    }

    public void uphill (Stage stage){
        if (status==Status.MOVING){
            
        while (getPoint().x< stage.getHillPoint().x || getPoint().y< stage.getHillPoint().y){
                setPoint(new Point(++getPoint().x,++getPoint().y));
                System.out.println(getName()+" поднялся на " + this.point.y+" метра ");

            }
            System.out.println("Поднялся на холм");
            MainState=EnergyState.SAVING;
            setStatus(Status.NOTHING);
        }
        else {
            System.out.println(getName()+" не в состоянии подняться");
        }
    }
    
    public void poke(Person b, Item c){
        if (status==Status.POKING ){
            System.out.println(getName() + " тыкает " + b.getName() + " в спину предметом " + c.name()+", "+b.getName()+" готов к действию");
            b.setMainState(EnergyState.READY);
            MainState=EnergyState.SAVING;
            setStatus(Status.NOTHING);
        }else{
            System.out.println(getName()+" не готов тыкать");
        }
    } 
    public void think(Stage stage,Flower[] flowers){
        if (status==Status.THINKING && stage.getMainCharacter().getPoint().x>=stage.getHillPoint().x && stage.getMainCharacter().getPoint().y>=stage.getHillPoint().y ){
            if (stage.getPlanet().getGravity()<9.8){
                System.out.println(getName()+" понимает, что находится на " + stage.getPlanet().getTitle());
                System.out.println("сравнивает размеры цветов: " + flowers[0].getLength().getSizeInSm()+ " cm"+ " все они такие же как на Земле,только во много раз меньше");
                System.out.println("начинает привыкать, что на "+stage.getPlanet().getTitle()+ " растения маленькие, это уже не удивляет");
            } else{
                System.out.println(getName()+" понимает, что находится на " + stage.getPlanet().getTitle());
                System.out.println("сравнивает размеры цветов: " + flowers[0].getLength().getSizeInSm()+" cm - это обычные цветы" );
                System.out.println("привык к таким размерам цветов");
            }
            MainState=EnergyState.MIDDLE;
            setStatus(Status.NOTHING);
        }else if (stage.getMainCharacter().getPoint().x<stage.getHillPoint().x || stage.getMainCharacter().getPoint().y<stage.getHillPoint().y){
            System.out.println(getName()+" не видит цветов");
        }else{
            System.out.println(getName()+" не готов думать");
        }
    }

        public void viewFeatures(Person p){
            if (status==Status.VIEWFEATURES){
                StringBuilder s=new StringBuilder();
                for (PersonFeatures i : p.getPersonFeatures()){
                    s.append(i.getDescription());
                }
                System.out.println(getName()+ " осматривает "+p.getName()+" его рост "+p.getHeight()+" cm, у него: "+s);
                setStatus(Status.NOTHING);
            }else{
                System.out.println(getName()+" не готов осматривать");
            }
        }
    
    
    public void relax(){
        int p=MainState.getEnergy();
        while (p!=100){
            p+=35;
            System.out.println(getName()+" отдохнул, у него "+p+" энергии");
            
        }
        MainState=EnergyState.READY;
    }
    
    
    @Override 
    public boolean equals(Object o) {
    if (!super.equals(o) ) return false;
    Person person = (Person) o;
    return (Objects.equals(height,person.height) && Objects.equals(MainState,person.MainState) && Objects.equals(status,person.status) && Objects.equals(clothes,person.clothes)&& Objects.equals(point,person.point));
    }
    
    @Override 
    public int hashCode() {
        return Objects.hash(height*123+getPoint().x*897+getPoint().y*763);

    }
    @Override 
    public String toString(){
        return getName();
    }

}