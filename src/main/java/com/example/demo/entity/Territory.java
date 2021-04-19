package com.example.demo.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "territories")
public class Territory {

    @Id
    private String territoryid;
    private String territorydescription;
    private int regionid;

    @ManyToMany
    @JoinTable(name = "employeeterritories",
            joinColumns = @JoinColumn(name = "territoryid"),
            inverseJoinColumns = @JoinColumn(name = "employeeid"))
    private List<Employee> empleadosPorTerritorio;


    public void setTerritoryid(String territoryid) {
        this.territoryid = territoryid;
    }

    public String getTerritoryid() {
        return territoryid;
    }

    public String getTerritorydescription() {
        return territorydescription;
    }

    public void setTerritorydescription(String territorydescription) {
        this.territorydescription = territorydescription;
    }

    public int getRegionid() {
        return regionid;
    }

    public void setRegionid(int regionid) {
        this.regionid = regionid;
    }

    public List<Employee> getEmpleadosPorTerritorio() {
        return empleadosPorTerritorio;
    }

    public void setEmpleadosPorTerritorio(List<Employee> empleadosPorTerritorio) {
        this.empleadosPorTerritorio = empleadosPorTerritorio;
    }
}