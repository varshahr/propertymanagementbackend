package com.property.property.management.Controller;

import com.property.property.management.model.RealEstateUnit;
import com.property.property.management.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/properties")
@CrossOrigin(origins = "http://localhost:5173") // allow frontend access
public class PropertyController {

    @Autowired
    private PropertyRepository repository;

    // Get all properties
    @GetMapping
    public List<RealEstateUnit> getAllProperties() {
        return repository.findAll();
    }

    // Get property by ID
    @GetMapping("/{id}")
    public RealEstateUnit getPropertyById(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    // Add new property
    @PostMapping
    public RealEstateUnit addProperty(@RequestBody RealEstateUnit property) {
        return repository.save(property);
    }

    // Delete property
    @DeleteMapping("/{id}")
    public void deleteProperty(@PathVariable Long id) {
        repository.deleteById(id);
    }

    // Update property
    @PutMapping("/{id}")
    public RealEstateUnit updateProperty(@PathVariable Long id, @RequestBody RealEstateUnit propertyDetails) {
        RealEstateUnit property = repository.findById(id).orElse(null);
        if (property != null) {
            property.setName(propertyDetails.getName());
            property.setLocation(propertyDetails.getLocation());
            property.setRent(propertyDetails.getRent());
            property.setOwnerName(propertyDetails.getOwnerName());
            property.setType(propertyDetails.getType());
            property.setAvailable(propertyDetails.isAvailable());
            property.setBedrooms(propertyDetails.getBedrooms());
            property.setBathrooms(propertyDetails.getBathrooms());
            property.setArea(propertyDetails.getArea());
            return repository.save(property);
        }
        return null;
    }
}
