package ru.konstantinpetrov.Task3;

public class Battlefield {

    public String fight(Human human, Animal animal) throws Exception{
        if(human.getLive()==false){
            throw new Exception("То что мертво, сражаться не может");
        }else{
            Integer hp=human.getHP();
            Integer  quantity=animal.getQuantity();
            Integer power = human.getPower();
            Integer speed = animal.getSpeed();
            human.eatApple();
            animal.relax();
            if(hp>quantity || power>speed){
                human.setHP(hp-3);
                
                animal.setQuantity(quantity-30);
                animal.setSpeed(speed-15);
                human.setPower(power+20);

                return("Люди победили!");
            }else{
                human.setLive(false);
                animal.setQuantity(quantity+10);
                animal.setSpeed(speed+15);
                return("Животные победили!");
            }
        }
    }
}
