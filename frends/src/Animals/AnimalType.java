package Animals;

public enum AnimalType {
    Cat(1),
    Dog(2),
    Hamster(3),
    Horse(4),
    Camel(5),
    Donkey(6);

    private final int animalType;
    AnimalType(int animalType) {
        this.animalType = animalType;
    }

    public int getAnimalType() {
        return animalType;
    }


    public static AnimalType setEnumType (int i) {
        switch (i) {
            case 1 -> {return AnimalType.Cat;}
            case 2 -> {return AnimalType.Dog;}
            case 3 -> {return AnimalType.Hamster;}
            case 4 -> {return AnimalType.Horse;}
            case 5 -> {return AnimalType.Camel;}
            case 6 -> {return AnimalType.Donkey;}
        }
        return null;
    }






    public static int getCountType() {
        int count = 0;
        for (AnimalType item : AnimalType.values()) {
            count++;
        }
        return count;
    }




    public static String AnimalTypeTostring() {
        int count = 1;
        StringBuilder res = new StringBuilder();
        for (AnimalType item : AnimalType.values()) {
            res.append(count).append(". ").append(item.name()).append("\n");
            count++;
        }
        return res.toString();
    }





}
