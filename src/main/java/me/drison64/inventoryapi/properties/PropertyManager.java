package me.drison64.inventoryapi.properties;

import java.util.ArrayList;
import java.util.List;

public class PropertyManager {

    private final List<Property> registeredProperties;

    public PropertyManager() {
        this.registeredProperties = new ArrayList<>();
    }

    public void register(Property property) {
        registeredProperties.add(property);
    }

}
