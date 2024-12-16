package pe.edu.cibertec.ef_barbaran_garcia.response;

import pe.edu.cibertec.ef_barbaran_garcia.entity.Car;

public record DetailCarResponse(
        String code,
        String error,
        Car car) {
}
