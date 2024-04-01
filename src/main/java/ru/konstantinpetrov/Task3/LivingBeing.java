package ru.konstantinpetrov.Task3;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class LivingBeing {//живое существо
    
    private List<Human> listHuman= new ArrayList<>();

    private List<Animal> listAnimal=new ArrayList<>();

    public void addHuman(Human human){
        if(listHuman.contains(human)){
            try {
                throw new Exception("Он уже здесь");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        listHuman.add(human);
    }
    
    public void addAnimal(Animal animal) throws Exception{
        if(listAnimal.contains(animal)){
            throw new Exception("Они уже здесь");
        }
        listAnimal.add(animal);
    }


}
