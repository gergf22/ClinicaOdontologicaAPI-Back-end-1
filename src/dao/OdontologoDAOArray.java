package dao;

import model.Odontologo;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class OdontologoDAOArray implements iDao<Odontologo>{

    private static final Logger logger = Logger.getLogger(OdontologoDAOArray.class);
    private List<Odontologo> listaOdontologos = new ArrayList<>();
    @Override
    public Odontologo guardar(Odontologo odontologo) {
        logger.info("guardando el Odontologo en la lista de persistencia");

        listaOdontologos.add(odontologo);

        logger.info("Se ha agregado exitosamente el odontologo a la lista");

        return odontologo;
    }


    @Override
    public Odontologo mostrarPorId(int id) {
        return null;
    }

    @Override
    public List<Odontologo> mostrar() {
        return listaOdontologos;
    }
}
