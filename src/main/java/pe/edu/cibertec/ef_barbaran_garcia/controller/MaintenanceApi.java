package pe.edu.cibertec.ef_barbaran_garcia.controller;

import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.ef_barbaran_garcia.entity.Car;
import pe.edu.cibertec.ef_barbaran_garcia.repository.CarRepository;
import pe.edu.cibertec.ef_barbaran_garcia.response.DetailCarResponse;
import pe.edu.cibertec.ef_barbaran_garcia.service.MaintenanceService;

import java.util.Optional;

@RestController
@RequestMapping("/maintenance")
public class MaintenanceApi {
    private final CarRepository carRepository;
    private final MaintenanceService maintenanceService;

    public MaintenanceApi(CarRepository carRepository, MaintenanceService maintenanceService) {
        this.carRepository = carRepository;
        this.maintenanceService = maintenanceService;
    }

    // Obtener todos los autos
    @GetMapping("/all")
    public Iterable<Car> getAllCars() {
        return carRepository.findAll();
    }

    @GetMapping("/detail")
    public DetailCarResponse findCar(@RequestParam(value = "id", defaultValue = "0") String id) {

        try {
            Optional<Car> optional = maintenanceService.getCarById(Integer.parseInt(id));
            return optional.map(car ->
                    new DetailCarResponse("01", null, car)
            ).orElse(
                    new DetailCarResponse("02", "Car not found", null)
            );

        } catch (Exception e) {
            e.printStackTrace();
            return new DetailCarResponse("99", "An error ocurred, please try again", null);

        }

    }

















/*    // Obtener un auto por ID
    @GetMapping("/detail/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable Integer id) {
        return carRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    // Crear un nuevo auto
    @PostMapping("/create")
    public Car createCar(@RequestBody Car car) {
        return carRepository.save(car);
    }

    // Actualizar un auto
    @PutMapping("/update/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable Integer carId, @RequestBody Car carDetails) {
        return carRepository.findById(carId).map(car -> {
            car.setCarId(carDetails.getCarId());
            car.setMake(carDetails.getMake());
            car.setModel(carDetails.getModel());
            car.setYear(carDetails.getYear());
            car.setVin(carDetails.getVin());
            car.setLicensePlate(carDetails.getLicensePlate());
            car.setOwnerName(carDetails.getOwnerName());
            car.setOwnerContact(carDetails.getOwnerContact());
            car.setPurchaseDate(carDetails.getPurchaseDate());
            car.setMileage(carDetails.getMileage());
            car.setEngineType(carDetails.getEngineType());
            car.setColor(carDetails.getColor());
            car.setInsuranceCompany(carDetails.getInsuranceCompany());
            car.setInsurancePolicyNumber(carDetails.getInsurancePolicyNumber());
            car.setRegistrationExpirationDate(carDetails.getRegistrationExpirationDate());
            car.setServiceDueDate(carDetails.getServiceDueDate());

            carRepository.save(car);
            return ResponseEntity.ok(car);
        }).orElse(ResponseEntity.notFound().build());
    }

    // Eliminar un auto
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable Integer carId) {
        if (carRepository.existsById(carId)) {
            carRepository.deleteById(carId);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }*/

}
