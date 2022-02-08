package modelo;

import java.util.List;

import Clases.Pizza;
import Clases.Usuario;

public interface IDAOPizzeria {
    boolean insertarUsuario(Usuario u);
    int modificarUsuario(Usuario u);
    Usuario sacarUsuario(String email);
    List<Usuario> listarUsuarios();

    Pizza sacarPizza(int idPizza);
    List<Pizza> listarPizzas();
}
