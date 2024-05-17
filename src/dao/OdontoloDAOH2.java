package dao;

import model.Odontologo;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OdontoloDAOH2 implements iDao<Odontologo>{


    private static final Logger logger = Logger.getLogger(OdontoloDAOH2.class);
    private static final String SQL_INSERT = "INSERT INTO ODONTOLOGOS VALUES (?,?,?,?)";

    private static final String SQL_SELECT_BY_ID="SELECT * FROM ODONTOLOGOS WHERE ID=?";
    private static final String SQL_SELECT_ALL ="SELECT * FROM ODONTOLOGOS";

    @Override
    public Odontologo guardar(Odontologo odontologo) {

        Connection con = null;

        try{
            con = BD.getConnection();

            PreparedStatement psInsert = con.prepareStatement(SQL_INSERT);

            psInsert.setInt(1,odontologo.getId());
            psInsert.setString(2,odontologo.getMatricula());
            psInsert.setString(3,odontologo.getNombre());
            psInsert.setString(4,odontologo.getApellido());

            psInsert.execute();

            logger.info("Se guardo un odontologo");



        }catch (Exception e){
            logger.error(e.getMessage());
        }


        return odontologo;
    }

    @Override
    public Odontologo mostrarPorId(int id) {

        Connection con = null;
        Odontologo odontologo = null;

        try{

            con = BD.getConnection();

            PreparedStatement psSelectById = con.prepareStatement(SQL_SELECT_BY_ID);
            logger.info("buscando odontologo con id: "+id);

            psSelectById.setInt(1,id);

            ResultSet rs = psSelectById.executeQuery();

            while(rs.next()){
                odontologo = new Odontologo(rs.getInt(1),rs.getString(2),
                        rs.getString(3), rs.getString(4));
                return odontologo;
            }
            logger.info("Se trajo el odontologo con id: "+ id);

        }catch (Exception e){
            logger.error(e.getMessage());
        }

        return odontologo;
    }

    @Override
    public List<Odontologo> mostrar() {
        Connection con = null;
        Odontologo odontologo = null;
        List<Odontologo> listaOdontologos = new ArrayList<>();

        try{
            con = BD.getConnection();

            logger.info("Busconado los odontologos");

            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(SQL_SELECT_ALL);


            while(rs.next()){
                odontologo = new Odontologo(rs.getInt(1),rs.getString(2),
                        rs.getString(3), rs.getString(4));

                listaOdontologos.add(odontologo);
            }
            logger.info("odontologos traidos con exito");

        }catch (Exception e){
            logger.error(e.getMessage());
        }




        return listaOdontologos;
    }
}
