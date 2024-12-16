package pe.edu.cibertec.ef_barbaran_garcia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.edu.cibertec.ef_barbaran_garcia.entity.Car;

import java.util.List;

@Controller
@RequestMapping("/maintenance")
public class MaintenanceControllerr {

    @Autowired
    MaintenanceControllerr maintenanceControllerr;

    @GetMapping("/start")
    public String start(Model model) {
        return null;
    }

}
