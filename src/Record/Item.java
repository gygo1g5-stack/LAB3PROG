package Record;
import Exceptions.*;
public record Item(String name)  {
    public Item {
        if (name==null || name.isEmpty()){
            throw new NameException();
        }
    }
}