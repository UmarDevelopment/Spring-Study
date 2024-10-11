package me.umar.util;

import me.umar.dao.ClassesDAO;
import me.umar.models.classes.Classe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ClasseValidator implements Validator {

    private ClassesDAO dao;

    @Autowired
    public ClasseValidator(ClassesDAO dao){
        this.dao = dao;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Classe.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Classe classe = (Classe) o;
        if (dao.getClasseByEmail(classe.getTeacherEmail()).isPresent()){
            errors.rejectValue("teacherEmail", "", "This email is already taken");
        }
    }
}
