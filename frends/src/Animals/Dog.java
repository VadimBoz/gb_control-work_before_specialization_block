package Animals;

import java.time.LocalDate;
import java.util.ArrayList;

public class Dog extends  Pet {

    public Dog(String name, LocalDate dataBirth, ArrayList<CommandsAnimal> commands) {
        super(name, dataBirth, commands);
    }

    public Dog(String name, LocalDate dataBirth) {
        super(name, dataBirth);
    }

    public Dog(String name, LocalDate dataBirth, CommandsAnimal command) {
        super(name, dataBirth, command);
    }
    @Override
    public String toString() {
        return "\nDog {id = " + super.getId() + ", name = " + name +
                ", dataBirth = " + dataBirth + ", commands = " + commands + '}';
    }
}
