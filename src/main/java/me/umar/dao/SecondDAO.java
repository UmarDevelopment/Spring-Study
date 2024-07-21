package me.umar.dao;

import me.umar.models.second.Word;

import java.util.ArrayList;
import java.util.List;

public class SecondDAO {
    List<Word> words = new ArrayList<Word>();

    public void save(Word word){
        words.add(word);
    }

    public List<Word> getWords(){
        return words;
    }
}
