package dao;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class BD {

    private static final Logger logger = Logger.getLogger(BD.class);
    private static final String SQL_DROP_CREATE_ODONTOLOGOS = "DROP TABLE IF EXISTS ODONTOLOGOS;" +
            " CREATE TABLE ODONTOLOGOS (ID INT PRIMARY KEY, MATICULA VARCHAR(100) NOT NULL, " +
            "NOMBRE VARCHAR(100) NOT NULL, APELLIDO VARCHAR(100) NOT NULL)";

    private static final String SQL_INSERTAR_EJEMPLO = "INSERT INTO ODONTOLOGOS VALUES (1,'123123','German','Fraire')," +
            "(2, '234324432','Fabricio','Acosta')";


    public static void crearTablas (){
        Connection con = null;

        try{
            con = getConnection();

            Statement statement = con.createStatement();

            statement.execute(SQL_DROP_CREATE_ODONTOLOGOS);


            logger.info("Tabla creada");


            statement.execute(SQL_INSERTAR_EJEMPLO);


            logger.info("inserciones creadas");


        }catch (Exception e){
            logger.error(e.getMessage());
        }
    }



    public static Connection getConnection() throws Exception{
        Class.forName("org.h2.Driver");

        return DriverManager.getConnection("jdbc:h2:mem:~/Clinica_Odontologica","sa","sa");

    }



}
