package Animals;

import java.time.LocalDate;
import java.util.ArrayList;

public class PackAnimal extends Animal {
    public PackAnimal(String name, LocalDate dataBirth, ArrayList<CommandsAnimal> commands) {
        super(name, dataBirth, commands);
    }

    public PackAnimal(String name, LocalDate dataBirth) {
        super(name, dataBirth);
    }


    public PackAnimal(String name, LocalDate dataBirth, CommandsAnimal command) {
        super(name, dataBirth, command);
    }

    @Override
    public String toString() {
        return "PackAnimal {id = " + super.getId() + ", name = " + name +
                ", dataBirth = " + dataBirth + ", commands = " + commands + '}';
    }

}
