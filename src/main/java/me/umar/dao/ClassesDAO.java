package me.umar.dao;

import me.umar.models.classes.Classe;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClassesDAO {
    List<Classe> classes = new ArrayList<>();

    ClassesDAO(){
        classes.add(new Classe(1, "Math", "math@yandex.ru", 15));
        classes.add(new Classe(2, "Geography", "geo@google.com", 8));
        classes.add(new Classe(3, "Physics", "phy@phy.hex", 52));
        classes.add(new Classe(4, "Biology", "lolkek@lol.kek", 45));
    }

    public void deleteClasse(int id){
        Classe remove = null;
        for (Classe cl: classes){
            if (cl.getId()==id){
                remove = cl;
                break;
            }
        }
        classes.remove(remove);
    }

    public void addClasse(Classe classe){
        classes.add(classe);
    }

    public Classe getClasse(int id){
        for (Classe cl: classes){
            if (cl.getId()==id){
                return cl;
            }
        }
        return null;
    }

    public List<Classe> getClasses(){
        return classes;
    }
}
