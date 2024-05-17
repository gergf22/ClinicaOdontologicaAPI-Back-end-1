package service;

import dao.OdontoloDAOH2;
import dao.OdontologoDAOArray;
import dao.iDao;
import model.Odontologo;
import org.apache.log4j.Logger;

import java.util.List;

public class OdolontologoService {


    private static final Logger logger = Logger.getLogger(OdolontologoService.class);

    private iDao<Odontologo> odontologoiDao;
    private String tipoPersistencia;

    public OdolontologoService(String tipoPersistencia) {
        if (tipoPersistencia == "H2"){
            this.odontologoiDao = new OdontoloDAOH2();
            logger.info("creado el dao con h2");
        } else {
            this.odontologoiDao = new OdontologoDAOArray();
            logger.info("creado el dao array");
        }


    };


    public Odontologo guardarOdontologo (Odontologo odontologo){
        return odontologoiDao.guardar(odontologo);


    }

    public Odontologo mostrarPorId(int id){
        return odontologoiDao.mostrarPorId(id);
    }

    public List<Odontologo> listaOdontologos(){
        return odontologoiDao.mostrar();
    }







}
