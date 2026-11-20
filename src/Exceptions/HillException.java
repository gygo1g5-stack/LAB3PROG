package Exceptions;

public class HillException extends RuntimeException {
    @Override public String getMessage(){
        return "Не поднялся, поэтому не может увидеть цветов";
    }
    
}
