package sisboot.ms.evaluacion.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sisboot.ms.evaluacion.dto.EvaluacionRequest;
import sisboot.ms.evaluacion.model.Evaluacion;
import sisboot.ms.evaluacion.model.Pregunta;
import sisboot.ms.evaluacion.model.PreguntaOpcion;
import sisboot.ms.evaluacion.model.Test;
import sisboot.ms.evaluacion.repository.PreguntaRepository;
import sisboot.ms.evaluacion.service.EvaluacionService;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/evaluacion")
@CrossOrigin(origins = "http://localhost:4200")
public class EvaluacionController {

    @Autowired
    private PreguntaRepository preguntaRepository;

    @Autowired
    private EvaluacionService evaluacionService;

    @GetMapping("/test/listar")
    public Iterable<Test> listarTest(){
        return evaluacionService.listarTest();
    }

    @GetMapping("/pregunta/listar")
    public Iterable<Pregunta> listarPreguntas(){
        return evaluacionService.listarPreguntas();
    }

    @GetMapping("pregunta/buscar/{idTest}")
    public List<Pregunta> obtenerPreguntas(@PathVariable Long idTest) {
        return evaluacionService.obtenerPreguntasPorTest(idTest);
    }

    @GetMapping("opcion/buscar/{idTest}")
    public List<PreguntaOpcion> obtenerOpciones(@PathVariable Long idTest) {
        return evaluacionService.obtenerOpcionesPorTest(idTest);
    }

    @PostMapping("/guardar")
    public ResponseEntity<Evaluacion> guardarEvaluacion(@RequestBody EvaluacionRequest evaluacionRequest) {
        Evaluacion evaluacion = evaluacionService.guardarEvaluacion(evaluacionRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(evaluacion);
    }
}
