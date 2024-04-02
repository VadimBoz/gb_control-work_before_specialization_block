package Animals;

import java.time.LocalDate;
import java.util.ArrayList;

public class Donkey extends PackAnimal {

    public Donkey(String name, LocalDate dataBirth, ArrayList<CommandsAnimal> commands) {
        super(name, dataBirth, commands);
    }

    public Donkey(String name, LocalDate dataBirth) {
        super(name, dataBirth);
    }

    public Donkey(String name, LocalDate dataBirth, CommandsAnimal command) {
        super(name, dataBirth, command);
    }


    @Override
    public String toString() {
        return "\nDonkey {id = " + super.getId() + ", name = " + name +
                ", dataBirth = " + dataBirth + ", commands = " + commands + '}';
    }
}
