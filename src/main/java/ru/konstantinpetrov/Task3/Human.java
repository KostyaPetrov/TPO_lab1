package ru.konstantinpetrov.Task3;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Human {
    private Integer id;
    private String name;
    private Gender gender;
    private Boolean live;
    private Integer HP;
    private Integer power;
    

    public void closeDoor(Door door) throws Exception{
        if(door.getIsOpen()==true){
            if(this.power<=10){
                throw new Exception("У него не хватит сил открыть дверь");
            }
            door.setIsOpen(false);
            this.power=this.power-10;
        }else{
            door.setIsOpen(true);
        }
    }

    public void eatApple() throws Exception{
        if(this.HP>=100){
            throw new Exception("Этот человек находится в своей лучшей форме");
        }else{
            this.HP+=50;
            this.power+=50;
        }
    }

}
