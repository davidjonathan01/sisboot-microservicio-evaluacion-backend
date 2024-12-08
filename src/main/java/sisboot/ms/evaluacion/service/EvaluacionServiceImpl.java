package sisboot.ms.evaluacion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sisboot.ms.evaluacion.dto.EvaluacionRequest;
import sisboot.ms.evaluacion.model.*;
import sisboot.ms.evaluacion.repository.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service

public class EvaluacionServiceImpl implements EvaluacionService {

    @Autowired
    private PreguntaRepository preguntaRepository;

    @Autowired
    private PreguntaOpcionRepository preguntaOpcionRepository;

    @Autowired
    private TestRepository testRepository;

    @Autowired
    private RangoRepository rangoRepository;

    @Autowired
    private EvaluacionRepository evaluacionRepository;

    @Override
    public Iterable<Pregunta> listarPreguntas() {
        return preguntaRepository.findAll();
    }

    @Override
    public List<Pregunta> obtenerPreguntasPorTest(Long idTest) {
        return preguntaRepository.findByTest_IdTest(idTest);
    }

    @Override
    public List<PreguntaOpcion> obtenerOpcionesPorTest(Long idTest) {
        return preguntaOpcionRepository.findByTest_IdTest(idTest);
    }

    @Override
    public List<Test> listarTest() {
        return testRepository.findAll();
    }

    @Override
    public Evaluacion guardarEvaluacion(EvaluacionRequest evaluacionRequest) {
        Long idTest = evaluacionRequest.getIdTest();
        List<Integer> respuestas = evaluacionRequest.getRespuestas();

        // 1. Calcular el puntaje total sumando los valores de las respuestas
        int puntajeTotal = calcularPuntajeTotal(respuestas);

        // 2. Determinar el rango en base al puntaje total
        Rango rango = obtenerRangoPorPuntaje(idTest, puntajeTotal);

        Test test = testRepository.findById(evaluacionRequest.getIdTest())
                .orElseThrow(() -> new IllegalArgumentException("Test no encontrado"));

        // 3. Crear la evaluación
        Evaluacion evaluacion = new Evaluacion();
        evaluacion.setIdPaciente(evaluacionRequest.getIdPaciente());
        evaluacion.setTest(test);  // Se asocia solo el ID del test
        evaluacion.setRango(rango);
        // Convertir la lista de respuestas a una cadena de valores separados por espacio
        String respuestasString = respuestas.stream()
                .map(String::valueOf)  // Convertir cada número a String
                .collect(Collectors.joining(" "));  // Unirlos con un espacio

        evaluacion.setRespuestas(respuestasString);  // Guardar como cadena sin comas, solo con espacios
        evaluacion.setPuntajeTotal(puntajeTotal);
        evaluacion.setFecha(LocalDate.now());  // Fecha actual

        // 4. Guardar la evaluación en la base de datos
        return evaluacionRepository.save(evaluacion);
    }

    private int calcularPuntajeTotal(List<Integer> respuestas) {
        // Simplemente sumamos los valores del arreglo respuestas
        return respuestas.stream().mapToInt(Integer::intValue).sum();
    }

    private Rango obtenerRangoPorPuntaje(Long idTest, int puntajeTotal) {
        // Obtener los rangos para el test especificado
        List<Rango> rangos = rangoRepository.findByTest_IdTest(idTest);

        // Buscar el rango correspondiente al puntaje total
        return rangos.stream()
                .filter(rango -> puntajeTotal >= rango.getPuntajeMin() && puntajeTotal <= rango.getPuntajeMax())
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Rango no encontrado para el puntaje"));
    }
}
