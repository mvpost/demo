package ru.mtsbank.figures;

import jakarta.persistence.*;
import java.util.List;

import jakarta.validation.constraints.*;

@Entity
@Table(name = "color", schema = "public")
public class Color {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    private int id;
    @Column(name = "name", nullable = false, length = 20)
    @NotNull
    @Size(min = 2)
    @Size(max = 20)
    private String name;
    @Column(name = "red_code", nullable = false)
    @NotNull
    @Min(value = 0)
    @Max(value = 255)
    private int redCode;
    @Column(name = "green_code", nullable = false)
    @NotNull
    @Min(value = 0)
    @Max(value = 255)
    private int greenCode;
    @Column(name = "blue_code", nullable = false)
    @NotNull
    @Min(value= 0)
    @Max(value = 255)
    private int blueCode;

    @OneToMany(targetEntity = Figure.class, mappedBy = "color")
    private List<Figure> figure;

    public Color() {}
    public Color(String name, int redCode, int greenCode, int blueCode) {
        this.name = name;
        this.redCode = redCode;
        this.greenCode = greenCode;
        this.blueCode = blueCode;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public int getRedCode() { return redCode; }

    public void setRedCode( int redCode ) {
        this.redCode = redCode;
    }

    public int getGreenCode() {
        return greenCode;
    }

    public void setGreenCode( int greenCode ) {
        this.greenCode = greenCode;
    }

    public int getBlueCode() {
        return blueCode;
    }

    public void setBlueCode( int blueCode ) {
        this.blueCode = blueCode;
    }

}

