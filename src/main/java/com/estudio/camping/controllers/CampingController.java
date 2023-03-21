package com.estudio.camping.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudio.camping.entities.Camping;
import com.estudio.camping.response.ResponseHandler;
import com.estudio.camping.services.ICampingService;

@RestController
@RequestMapping("api/camping")
public class CampingController {

    @Autowired
    private ICampingService campingService;

    @GetMapping("")
    public ResponseEntity<Object> getCampings() {
        List<Camping> campings = campingService.getAllCampings();
        if (campings.isEmpty()) {
            return ResponseHandler.generateResponse("No existen campings en los registros", HttpStatus.NOT_FOUND,
                    campings);
        } else {
            return ResponseHandler.generateResponse(null, HttpStatus.OK, campings);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getCampingById(@PathVariable String id) {
        Camping camping = campingService.getCampingById(Long.parseLong(id));
        if (camping == null) {
            return ResponseHandler.generateResponse("No existe el camping solicitado", HttpStatus.NOT_FOUND,
                    camping);
        } else {
            return ResponseHandler.generateResponse(null, HttpStatus.OK, camping);
        }
    }

    @PostMapping("")
    public ResponseEntity<Object> postCamping(@RequestBody Camping requestCamping) {
        Camping camping = campingService.postCamping(requestCamping);
        if (camping == null) {
            return ResponseHandler.generateResponse("Error al guardar el camping", HttpStatus.INTERNAL_SERVER_ERROR,
                    camping);
        } else {
            return ResponseHandler.generateResponse("Camping guardado correctamente", HttpStatus.OK, camping);
        }
    }

    @PutMapping("")
    public ResponseEntity<Object> putCamping(@RequestBody Camping requestCamping) {
        Camping camping = campingService.putCamping(requestCamping);
        if (camping == null) {
            return ResponseHandler.generateResponse("Error al actualizar el camping", HttpStatus.INTERNAL_SERVER_ERROR,
                    camping);
        } else {
            return ResponseHandler.generateResponse("Camping actualizado correctamente", HttpStatus.OK, camping);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCamping(@PathVariable String id) {
        Boolean delete = campingService.deleteCamping(Long.parseLong(id));
        if (!delete) {
            return ResponseHandler.generateResponse("Error al eliminar el camping", HttpStatus.INTERNAL_SERVER_ERROR,
                    null);
        } else {
            return ResponseHandler.generateResponse("El camping a sido eliminado correctamente", HttpStatus.OK, null);
        }
    }

}
