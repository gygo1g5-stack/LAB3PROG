package Exceptions;

public class HillException extends Exception {
    @Override public String getMessage(){
        return "Не поднялся, поэтому не может увидеть цветов";
    }
    
}
