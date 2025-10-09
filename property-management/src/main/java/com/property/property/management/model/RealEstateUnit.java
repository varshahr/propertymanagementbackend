package com.property.property.management.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "real_estate_unit")
public class RealEstateUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;         // e.g., Greenwood Apartment
    private String location;
    private BigDecimal rent;

    @Enumerated(EnumType.STRING)
    private PropertyType type;   // HOUSE, SHOP, LAND

    private String ownerName;
    private boolean available;   // available for rent/sale
    private int bedrooms;        // only for HOUSE
    private int bathrooms;       // only for HOUSE
    private double area;         // in sq meters

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public BigDecimal getRent() { return rent; }
    public void setRent(BigDecimal rent) { this.rent = rent; }

    public PropertyType getType() { return type; }
    public void setType(PropertyType type) { this.type = type; }

    public String getOwnerName() { return ownerName; }
    public void setOwnerName(String ownerName) { this.ownerName = ownerName; }

    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }

    public int getBedrooms() { return bedrooms; }
    public void setBedrooms(int bedrooms) { this.bedrooms = bedrooms; }

    public int getBathrooms() { return bathrooms; }
    public void setBathrooms(int bathrooms) { this.bathrooms = bathrooms; }

    public double getArea() { return area; }
    public void setArea(double area) { this.area = area; }
}
