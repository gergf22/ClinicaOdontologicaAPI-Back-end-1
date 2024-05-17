package test;


import dao.BD;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import service.OdolontologoService;

public class TestOdontologosService {

    @Test
    public void mostrarOdontologosTestH2(){

        OdolontologoService odolontologoService = new OdolontologoService("H2");

        BD.crearTablas();

        odolontologoService.listaOdontologos();

        Assertions.assertTrue(odolontologoService.listaOdontologos().size()==2);
    }
}
