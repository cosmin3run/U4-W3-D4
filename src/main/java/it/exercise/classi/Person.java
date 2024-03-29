package it.exercise.classi;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue
    private long id;

    private String name;
    private String surname;
    private String email;
    private LocalDate dateOfBirth;
    private Gender gender;


    @OneToMany(mappedBy = "person")
    private List<Partecipation> partecipationList;


   @ManyToMany
   @JoinTable(name = "challenge_person", joinColumns = @JoinColumn(name = "person_id"), inverseJoinColumns = @JoinColumn(name ="competition_id"))
   private Set<AtlethicsCompetition> atlethicsCompetitions;



    //CONSTRUCTORS
    public Person() {
    }

    public Person( String name, String surname, String email, LocalDate dateOfBirth, Gender gender) {

        this.name = name;
        this.surname = surname;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;


    }

    public Set<AtlethicsCompetition> atlethicsCompetitions() {return atlethicsCompetitions;}
    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public List<Partecipation> getPartecipationList() {
        return partecipationList;
    }

    public void setPartecipationList(List<Partecipation> partecipationList) {
        this.partecipationList = partecipationList;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", gender=" + gender +
                ", partecipationList=" + partecipationList +
                '}';
    }
}
