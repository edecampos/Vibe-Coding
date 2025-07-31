package com.example.houses;

import com.example.houses.api.RentCastApiClient;
import com.example.houses.model.House;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HouseService {

    private final RentCastApiClient apiClient;

    public HouseService(RentCastApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public List<House> getTop10CheapestPerSqFt(String address, int radiusMiles) {
        List<House> houses = apiClient.fetchHousesForSale(address, radiusMiles);

        if (houses == null) {
            System.out.println("fetchHousesForSale returned null for address: " + address + ", radius: " + radiusMiles);
            return List.of();
        }
        System.out.println("Fetched " + houses.size() + " houses from API for address: " + address + ", radius: " + radiusMiles);

        // Print a few sample houses for debugging
        System.out.println("Sample house data:");
        houses.stream().limit(3).forEach(h -> 
            System.out.println(
                "Price: " + h.getPrice() + 
                ", SqFt: " + h.getSquareFootage() + 
                ", Full: " + h
            )
        );

        List<House> validHouses = houses.stream()
                .filter(h -> h.getSquareFootage() != null && h.getSquareFootage() > 0 && h.getPrice() != null)
                .collect(Collectors.toList());
        System.out.println("Valid houses with sqft and price: " + validHouses.size());

        List<House> result = validHouses.stream()
                .sorted(Comparator.comparingDouble(House::getCostPerSquareFoot))
                .limit(10)
                .collect(Collectors.toList());
        System.out.println("Returning " + result.size() + " houses after sorting and limiting.");

        return result;
    }
}