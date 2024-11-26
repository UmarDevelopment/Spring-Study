package me.umar.services;

import me.umar.models.classes.Classe;
import me.umar.repositories.ClasseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ClasseService {

    ClasseRepository classeRepository;

    @Autowired
    public ClasseService(ClasseRepository classeRepository){
        this.classeRepository = classeRepository;
    }

    public List<Classe> findAll(){
        return classeRepository.findAll();
    }

    public Classe findOne(int id){
        return classeRepository.findById(id).orElse(null);
    }

    public void save(Classe classe){
        classeRepository.save(classe);
    }

    public void delete(int id){
        classeRepository.deleteById(id);
    }
}
