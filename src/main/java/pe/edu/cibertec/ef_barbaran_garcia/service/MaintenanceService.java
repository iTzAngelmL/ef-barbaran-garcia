package pe.edu.cibertec.ef_barbaran_garcia.service;

import pe.edu.cibertec.ef_barbaran_garcia.dto.CarDto;
import pe.edu.cibertec.ef_barbaran_garcia.entity.Car;

import java.util.List;
import java.util.Optional;

public interface MaintenanceService {


    List<CarDto> getAllCars() throws Exception;

    Optional<Car> getCarById(int id) throws Exception;

    boolean updateCar(CarDto carDto) throws Exception;

    boolean deleteCarById(int id) throws Exception;

    boolean addCar(Car car) throws Exception;

}

