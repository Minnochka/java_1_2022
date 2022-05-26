package ru.geekbrains.bogachevaks;

public class Task1 {
    public static void main(String[] args) {
        Cat cat = new Cat.Builder().name("Барсик").height_max(2).length_max(100).build();
        Human man = new Human.Builder().age(20).name("Андрей").height_max(3).length_max(1000).build();
        Robot robot = new Robot.Builder().model("VM-300").height_max(1).length_max(20).build();

        Treadmill treadmill = new Treadmill.Builder().length(300).build();
        Wall wall = new Wall.Builder().length(1).build();

        cat.jump(wall.getLength());
        man.jump(wall.getLength());
        robot.jump(wall.getLength());

        cat.run(treadmill.getLength());
        man.run(treadmill.getLength());
        robot.run(treadmill.getLength());

        Action[] team = {cat, man, robot};

        Let[] lets = {
                new Treadmill.Builder().length(10).build(),
                new Wall.Builder().length(1).build(),
                new Treadmill.Builder().length(100).build(),
                new Wall.Builder().length(2).build(),
                new Treadmill.Builder().length(1000).build(),
                new Wall.Builder().length(3).build()
        };

        System.out.println("Команда начинает прохождение препятствий");
        for (Action a: team) {
            System.out.println("------------------------");
            boolean res;
            for (Let let: lets) {
                if (let instanceof Treadmill){
                    res = a.run(let.getLength());
                }
                else{
                    res = a.jump(let.getLength());
                }
                if (!res){
                    break;
                }
            }
        }
    }
}
