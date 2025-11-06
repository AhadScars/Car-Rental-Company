package com.example.Car.Rental.service;

import com.example.Car.Rental.entity.VehicleEntity;
import com.example.Car.Rental.repository.VehicleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import java.util.List;

@Service
public class Vehicle_Service {

    @Autowired
    VehicleRepo repo;

    public Page<VehicleEntity> getAll(int page, int size, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase("desc")
                ? Sort.by(sortBy).descending()
                : Sort.by(sortBy).ascending();

        Pageable pageable = (Pageable) PageRequest.of(page, size);
        return repo.findAll(pageable);
    }



    public VehicleEntity addVehicle(VehicleEntity vehicleEntity){
        return repo.save(vehicleEntity);
    }
    public void deleteAll(){
        repo.deleteAll();
    }
    public VehicleEntity findBYid(Integer id){
        return repo.findByid(id);
    }
    public void deleteByid(Integer id){
        repo.deleteById(id);
    }
    public VehicleEntity editvehicle(Integer id , VehicleEntity entity){
        VehicleEntity edit = repo.findByid(id);

        edit.setBrand(entity.getBrand());
        edit.setAvailable(entity.getAvailable());
        edit.setName(entity.getName());
        edit.setVehicleType(entity.getVehicleType());
        edit.setPricePerDay(entity.getPricePerDay());

        return repo.save(edit);
    }
    public List<VehicleEntity> findByname(String name){
        return repo.findByNameContainingIgnoreCase(name);
    }

    public List<VehicleEntity> findByAvailable(Boolean available){
        return repo.findByAvailable(available);
    }

    public List<VehicleEntity> findByPriceLessthan(Double price){
        return repo.findByPricePerDayLessThan(price);
    }


}
