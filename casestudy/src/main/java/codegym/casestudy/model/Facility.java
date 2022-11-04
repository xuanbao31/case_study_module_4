package codegym.casestudy.model;

import javax.persistence.*;

@Entity
@Table(name = "facility")
public class Facility {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "name_facility")
    private String name;
    private int are;
    private double cost;
    private String standardRoom;
    private String descriptionConvenience;
    private double poolArea;
    private int numberFloors;
    @Column(columnDefinition = "text")
    private String facilityFree;

    @ManyToOne
    @JoinColumn(name = "facility_type", referencedColumnName = "id")
    private FacilityType facilityType;
    @ManyToOne
    @JoinColumn(name = "rent_type", referencedColumnName = "id")
    private RentType rentType;

    public Facility(int id, String name, int are, double cost, String standardRoom, String descriptionConvenience, double poolArea, int numberFloors, String facilityFree, FacilityType facilityType, RentType rentType) {
        this.id = id;
        this.name = name;
        this.are = are;
        this.cost = cost;
        this.standardRoom = standardRoom;
        this.descriptionConvenience = descriptionConvenience;
        this.poolArea = poolArea;
        this.numberFloors = numberFloors;
        this.facilityFree = facilityFree;
        this.facilityType = facilityType;
        this.rentType = rentType;
    }

    public Facility() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAre() {
        return are;
    }

    public void setAre(int are) {
        this.are = are;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionConvenience() {
        return descriptionConvenience;
    }

    public void setDescriptionConvenience(String descriptionConvenience) {
        this.descriptionConvenience = descriptionConvenience;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumberFloors() {
        return numberFloors;
    }

    public void setNumberFloors(int numberFloors) {
        this.numberFloors = numberFloors;
    }

    public String getFacilityFree() {
        return facilityFree;
    }

    public void setFacilityFree(String facilityFree) {
        this.facilityFree = facilityFree;
    }

    public FacilityType getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(FacilityType facilityType) {
        this.facilityType = facilityType;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }
}
