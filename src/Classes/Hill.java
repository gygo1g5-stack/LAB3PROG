package Classes;
import Interfaces.Viewable;
import java.awt.Point;

import Exceptions.PointException;
public class Hill implements Viewable{
    public Hill( Point point)throws PointException{
        if  (point==null || point.x<0 || point.y<0){
            throw new PointException();
        }
        this.point=point;
    }
    private String name="Холм";
    private Point point;
    private String getName(){
        return name;
    }
    public Point getPoint(){
        return point;
    }
    @Override 
    public String viewable(){
        return this.getName() ;
    }
}
