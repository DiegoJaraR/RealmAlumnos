package com.example.alumnoicin.realmalumnos.models;
import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

import com.example.alumnoicin.realmalumnos.application.MyApplication;

public class alumno extends RealmObject{
    @PrimaryKey
    private int id;
    private String rut;
    private String nombre;
    private String apellido;
    private int edad;
    private String carrera;
    private int ano;
    private String semestre;

    public  alumno(){}

    public alumno(String Rut, String name, String Apellido, int Edad, String Carrera, int ano, String Semestre){
        id = MyApplication.alumnoID.incrementAndGet();
        rut = Rut;
        nombre = name;
        apellido = Apellido;
        edad=Edad;
        this.ano = ano;
        carrera=Carrera;
        semestre=Semestre;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }
}
