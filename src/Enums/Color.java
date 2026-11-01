package Enums;
public enum Color{
    RED("красный"),
    BLUE("голубой"),
    GREEN("зелёный"),
    PINK("розовый"),
    BROWN("тёмно-коричневый"),
    NOTHING("цвет неопознан");
    private String description;
    Color(String descr){
        description=descr;
    }
    public String Type(){
        return description;
    }
    
}