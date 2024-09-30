package me.umar.dao;

import me.umar.models.classes.Classe;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClassesDAO {
    List<Classe> classes = new ArrayList<>();

    ClassesDAO(){
        classes.add(new Classe(1, "Math"));
        classes.add(new Classe(2, "Geography"));
        classes.add(new Classe(3, "Physics"));
        classes.add(new Classe(4, "Biology"));
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
