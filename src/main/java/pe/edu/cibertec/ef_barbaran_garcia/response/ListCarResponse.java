package pe.edu.cibertec.ef_barbaran_garcia.response;

import pe.edu.cibertec.ef_barbaran_garcia.entity.Car;

public record ListCarResponse(
        String code,
        String error,
        Iterable<Car> cars) {
}