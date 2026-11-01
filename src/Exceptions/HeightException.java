package Exceptions;

public class HeightException extends RuntimeException {
    @Override public String getMessage(){
        return "Объект не может быть создан без роста ";
    }
    
}