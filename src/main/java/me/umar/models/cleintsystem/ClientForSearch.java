package me.umar.models.cleintsystem;


public class ClientForSearch {
    public Integer id;
    public String name;
    public String surname;
    public Integer minAge;
    public Integer maxAge;
    public Integer minRank;
    public Integer maxRank;

    public ClientForSearch() {
    }

    public ClientForSearch(Integer id, String name, String surname, Integer minAge, Integer maxAge, Integer minRank, Integer maxRank) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.minAge = minAge;
        this.maxAge = maxAge;
        this.minRank = minRank;
        this.maxRank = maxRank;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getMinAge() {
        return minAge;
    }

    public void setMinAge(Integer minAge) {
        this.minAge = minAge;
    }

    public Integer getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(Integer maxAge) {
        this.maxAge = maxAge;
    }

    public Integer getMinRank() {
        return minRank;
    }

    public void setMinRank(Integer minRank) {
        this.minRank = minRank;
    }

    public Integer getMaxRank() {
        return maxRank;
    }

    public void setMaxRank(Integer maxRank) {
        this.maxRank = maxRank;
    }
}
