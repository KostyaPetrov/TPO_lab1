package ru.konstantinpetrov.Task3;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Animal {
    private Integer id;
    private String species;
    private String ability; //способность(летать, ползать)
    private Integer quantity;
    private Integer speed;

    public void callFriends() throws Exception{
        if(this.quantity>=100){
            throw new Exception("Больше звать некого, все рядом");
        }else{
            this.quantity+=20;
        }
    }

    public void relax() throws Exception{
        if(this.speed>=100){
            throw new Exception("Быстрее только свет");
        }else if(this.quantity<=10){
            throw new Exception("Больше звать некого, все рядом");
        }else{
            this.speed+=30;
            this.quantity-=10;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    
            this.quantity+=10;
        }
        
    }
}
