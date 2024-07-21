package me.umar.models.second;

public class Word {
    String original;
    String translation;

    public Word() {
    }

    public Word(String original, String translation) {
        this.original = original;
        this.translation = translation;
    }

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public String getIntro(){
        return original+" : "+translation;
    }
}
