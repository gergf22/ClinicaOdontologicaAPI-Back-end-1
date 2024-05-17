package dao;

import java.util.List;

public interface iDao <T>{


    T guardar (T t);

    T mostrarPorId (int id);
    List<T> mostrar();
}
