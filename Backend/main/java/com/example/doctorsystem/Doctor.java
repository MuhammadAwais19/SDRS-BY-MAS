package com.example.doctorsystem;

import jakarta.persistence.*;

@Entity
@Table(name = "doctors")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String specialization;
    private int experience;
    private String location;
    private String hospital;
    private int fee; // Real-time updated financial parameter mapping

    // Standard Getters ONLY (Entities mapping parameters context safely)
    public int getId() { return id; }
    public String getName() { return name; }
    public String getSpecialization() { return specialization; }
    public int getExperience() { return experience; }
    public String getLocation() { return location; }
    public String getHospital() { return hospital; }
    public int getFee() { return fee; }
}