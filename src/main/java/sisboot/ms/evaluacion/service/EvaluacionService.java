package sisboot.ms.evaluacion.service;

import sisboot.ms.evaluacion.dto.EvaluacionRequest;
import sisboot.ms.evaluacion.model.Evaluacion;
import sisboot.ms.evaluacion.model.Pregunta;
import sisboot.ms.evaluacion.model.PreguntaOpcion;
import sisboot.ms.evaluacion.model.Test;

import java.util.List;

public interface EvaluacionService {
    Iterable<Pregunta> listarPreguntas();
    List<Pregunta> obtenerPreguntasPorTest(Long idTest);
    List<PreguntaOpcion> obtenerOpcionesPorTest(Long idTest);
    List<Test> listarTest();
    Evaluacion guardarEvaluacion(EvaluacionRequest evaluacionRequest);


}
