package Classes;
import java.util.Objects;

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
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clothes a = (Clothes) o;
        return this.name == a.name && this.color == a.color && this.material==a.material;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, color, material, isStriped);
    }
}
    
