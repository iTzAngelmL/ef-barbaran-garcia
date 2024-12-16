package pe.edu.cibertec.ef_barbaran_garcia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.ef_barbaran_garcia.dto.CarDto;
import pe.edu.cibertec.ef_barbaran_garcia.entity.Car;
import pe.edu.cibertec.ef_barbaran_garcia.repository.CarRepository;
import pe.edu.cibertec.ef_barbaran_garcia.service.MaintenanceService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MaintenanceServiceImpl implements MaintenanceService {

    @Autowired
    CarRepository carRepository;

    @Override
    public Optional<CarDto> getCar(int id) {

        Optional<Car> optional = carRepository.findById(id);
        return optional.map(lang -> new CarDto(
            lang.getCarId(),
            lang.getMake(),
            lang.getModel(),
            lang.getYear(),
            lang.getVin(),
            lang.getLicensePlate(),
            lang.getOwnerName(),
            lang.getOwnerContact(),
            lang.getPurchaseDate(),
            lang.getMileage(),
            lang.getEngineType(),
            lang.getColor(),
            lang.getInsuranceCompany(),
            lang.getInsurancePolicyNumber(),
            lang.getRegistrationExpirationDate(),
            lang.getServiceDueDate()));
    }

    @Autowired
    CarRepository carRepository;

    @Override
    public List<CarDto> getAllCars() throws Exception {

        List<CarDto> cars = new ArrayList<CarDto>();
        Iterable<Car> iterable = carRepository.findAll();
        iterable.forEach(car -> {
            cars.add(new CarDto(car.getCarId(),
                    car.getMake(),
                    car.getModel(),
                    car.getYear(),
                    car.getColor()));
        });
        return cars;

    }

    @Override
    public Optional<Car> getCarById(int id) throws Exception {

        Optional<Car> optional = carRepository.findById(id);
        return optional.map(car -> new Car(car.getCarId(),
                car.getMake(),
                car.getModel(),
                car.getYear(),
                car.getVin(),
                car.getLicensePlate(),
                car.getOwnerName(),
                car.getOwnerContact(),
                car.getPurchaseDate(),
                car.getMileage(),
                car.getEngineType(),
                car.getColor(),
                car.getInsuranceCompany(),
                car.getInsurancePolicyNumber(),
                car.getRegistrationExpirationDate(),
                car.getServiceDueDate()));

    }

    @Override
    public boolean updateCar(CarDto carDto) throws Exception {
        return false;
    }

    @Override
    public boolean updateCar(Car car) throws Exception {

        Optional<Car> optional = carRepository.findById(car.carId());
        return optional.map(Car -> {
            car.setMake(car.make());
            car.setModel(car.model());
            car.setYear(car.year());
            car.setColor(car.color());
            carRepository.save(car);

            return true;
        }).orElse(false);

    }

    @Override
    public boolean deleteCarById(int id) throws Exception {

        Optional<Car> optional = carRepository.findById(id);
        return optional.map(car -> {
            carRepository.delete(car);
            return true;
        }).orElse(false);

    }

    @Override
    public boolean addCar(Car carDetail) throws Exception {

        Optional<Car> optional = carRepository.findById(Car.carId());
        if (optional.isEmpty()) {
            Car car = new Car();
            car.setMake(car.make());
            car.setModel(carDetail.model());
            car.setYear(carDetail.year());
            car.setVin(carDetail.vin());
            car.setLicensePlate(carDetail.licensePlate());
            car.setOwnerName(carDetail.ownerName());
            car.setOwnerContact(carDetail.ownerContact());
            car.setPurchaseDate(carDetail.purchaseDate());
            car.setMileage(carDetail.mileage());
            car.setEngineType(carDetail.engineType());
            car.setColor(carDetail.color());
            car.setInsuranceCompany(carDetail.insuranceCompany());
            car.setInsurancePolicyNumber(carDetail.insurancePolicyNumber());
            car.setRegistrationExpirationDate(carDetail.registrationExpirationDate());
            car.setServiceDueDate(carDetail.serviceDueDate());
            carRepository.save(car);
            return true;
        }
        return false;

    }
}
