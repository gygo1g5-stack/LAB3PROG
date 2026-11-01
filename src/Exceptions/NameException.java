package Exceptions;

public class NameException extends RuntimeException {
    @Override public String getMessage(){
        return "Объект не может быть создан без имени ";
    }
    
}
