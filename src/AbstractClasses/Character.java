package AbstractClasses;
import java.util.Objects;

import Exceptions.NameException;

abstract public class Character{
    
    public Character (String name) {
        this.name=name;
        if(name==null ||name.isEmpty()){
            throw new NameException();
        }
        System.out.println(name + " создан");
    }
    private String name;
    public String getName(){
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    
    
    
    
    @Override 
    public boolean equals(Object o) {
    if (this==o) return true;
    if (o==null || getClass()!=o.getClass()) return false;
    Character character = (Character) o;
    return Objects.equals(name,character.name);
    }
    
    @Override 
    public int hashCode() {
        return Objects.hash(name);

    }
    @Override 
    public String toString(){
        return this.name;
    }
}