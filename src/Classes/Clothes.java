package Classes;
import Enums.*;
import Exceptions.NameException;
public class Clothes {
    public Clothes(String name,Color color,boolean isStriped,String material){
        this.name=name;
        if(name.isEmpty()){
            throw new NameException();
        }
        this.color=color;
        this.isStriped=isStriped;
        this.material=material;
    }
    public Clothes(String name,Color color,boolean isStriped){
        this.name=name;
        this.color=color;
        this.isStriped=isStriped;
        
    }
    private String name;
    private Color color;
    private boolean isStriped;
    public String material;
    public String description(){
        if (isStriped){
            return  material+", "+color.Type() + " "+ name +" в полосочку, ";
        }else if (material==null){
            return color.Type()+ " " + name + ", ";
        }else{
            return material+", "+color.Type()+ " " + name + ", ";
        }

    }
    
}