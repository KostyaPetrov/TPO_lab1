package ru.konstantinpetrov.Task3;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BattleTest {
    private List<Human> listHuman;
    private List<Animal> listAnimal;
    private Animal griz, nasek;
    private Human tril, ford, zafod, artur;
    private Battlefield battlefield;
    private Door door;
    
    @BeforeEach
    void setUp(){
        listHuman=new ArrayList<>();
        tril=new Human(1,"Триллиана",Gender.FEMALE, true, 100, 100);
        ford=new Human(2, "Форд", Gender.MALE, true, 10, 10);
        zafod=new Human(3,"Зафод", Gender.MALE, true, 50,50);
        artur=new Human(4, "Артур", Gender.MALE, false, 0, 0);
        listHuman.add(tril);
        listHuman.add(ford);

        listAnimal=new ArrayList<>();
        griz=new Animal(1, "Грызуны", "воздухоплавающие", 50, 50);
        nasek=new Animal(2, "Насекомые", "ползующие", 100, 100 );
        listAnimal.add(griz);
        listAnimal.add(nasek);

        battlefield=new Battlefield();

        door = new Door(true);
    }

    @Test
    void testAnimal(){
        assertAll(
                    () -> {
                        griz.callFriends();
                        assertEquals(70,  griz.getQuantity());
                    },
                    () -> {
                        griz.relax();
                        assertEquals(80, griz.getSpeed());
                        assertEquals(70 , griz.getQuantity());
                        
                    }
            );
    }

    @Test
    void testHuman(){
        assertAll(
                    () -> {
                        zafod.closeDoor(door);
                        assertEquals(40,  zafod.getPower());
                    },
                    () -> {
                        zafod.eatApple();
                        assertEquals(100, zafod.getHP());
                        assertEquals(90 , zafod.getPower());
                    }
            );
    }

    @Test
    void testExceptionNoFriends(){
        Throwable exception = assertThrows(Exception.class, () -> nasek.callFriends());
        assertEquals("Больше звать некого, все рядом", exception.getMessage());
    }

    @Test
    void testExceptionAnimalRelax(){
        Throwable exception = assertThrows(Exception.class, () -> nasek.relax());
        assertEquals("Быстрее только свет", exception.getMessage());
    }

    @Test
    void testCloseDoor(){
        Throwable exception = assertThrows(Exception.class, () -> ford.closeDoor(door));
        assertEquals("У него не хватит сил открыть дверь", exception.getMessage());
    }

    @Test
    void testOpenDoor(){
        Throwable exception = assertThrows(Exception.class, () -> tril.eatApple());
        assertEquals("Этот человек находится в своей лучшей форме", exception.getMessage());
    }

    @Test
    void testButtlefield(){
        assertAll(
                () -> assertEquals("Животные победили!", battlefield.fight(zafod, griz)) 
        );
    }

    @Test
    void testExceptionFightDeadedHuman(){
        Throwable exception = assertThrows(Exception.class, () -> battlefield.fight(artur, griz));
        assertEquals("То что мертво, сражаться не может", exception.getMessage());
    }

}
