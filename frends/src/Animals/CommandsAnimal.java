package Animals;

import java.util.ArrayList;

public enum CommandsAnimal {
    Sit ("Сидеть", 1),
    Stay ("Стой", 2),
    Fetch ("Принеси", 3),
    Pounce ("Прыжок", 4),
    Roll ("Катайся", 5),
    Hide ("Прячься",6),
    Paw ("Дай лапу", 7),
    Bark ("Голос", 8),
    Scratch ("Царапать", 9),
    Spin ("Кружись", 10),
    Trot ("Рысь", 11),
    Canter ("Легкий галоп", 12),
    Gallop ("Галоп", 13),
    Carry_Load ("Неси", 14),
    Walk ("Гуляй", 14),
    Bray ("Толочь", 16),
    Kick ("Пинать", 17),
    Jump ("Прыгай", 18),
    Run ("Беги", 19),
    Meow ("Мяу", 20),
    Sleep ("Спать", 21);

    private String title;
    int num;
    CommandsAnimal (String title, int num) {
        this.title = title;
    }

    String getTitle() {
        return title;
    }

    public int getNum() {
        return num;
    }

    public static  ArrayList<CommandsAnimal> allCommandsAnimal() {
        ArrayList<CommandsAnimal> res = new ArrayList<>();
        for (CommandsAnimal item :  CommandsAnimal.values()) {
            res.add(item);
        }
        return  res;
    }



    public static String аnimalCommandsTostring() {
        int count = 1;
        StringBuilder res = new StringBuilder();
        for (CommandsAnimal item : CommandsAnimal.values()) {
            res.append(count).append(". ").append(item.name()).append("\n");
            count++;
        }
        return res.toString();
    }
}
