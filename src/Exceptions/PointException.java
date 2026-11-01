package Exceptions;

public class PointException extends Exception {
    @Override public String getMessage(){
        return "Объект не может быть создан без координат или с отрицательными координатами";
    }
    
}
