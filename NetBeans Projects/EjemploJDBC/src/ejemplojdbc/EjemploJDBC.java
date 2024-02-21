package ejemplojdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Diego Valenzuela Parra
 */
public class EjemploJDBC {
    public static void main(String[] args) {
        // Se define la url para la conexión con la base de datos. En mi caso, estoy usando la
        // base de la asignación 2.
        String url = "jdbc:mysql://localhost:3306/ecoActivistas";
        // Se define el nombre del usuario con el que se conectará con la base de datos.
        String user = "root";
        // Se define la contraseña de dicho usuario.
        String pass = "root";
        
        try {
            // Esto ya no es necesario en versiones de Java 6 en adelante.
            // Antes se usaba para cargar dinámicamente el controlador JDBC de la base de datos en memoria.
            // Class.forName("com.mysql.cj.jdbc.Driver");

            // Se crea un objeto de tipo Connection en el cual se guardan los datos de la conexión
            // al servidor usando el método getConnection, tomando como argumentos la url de la base
            // de datos, un usuario y contraseña.
            Connection connection = DriverManager.getConnection(url, user, pass);

            // Se crea un objeto de tipo Statement usando el objeto de conexión y el método
            // createStatement. Con este objeto será mediante el cual se ejecutarán las consultas
            // en la base de datos.
            Statement statement = connection.createStatement();

            // Se define la consulta a realizar. En este caso, será seleccionar todos los datos de
            // la tabla clientes.
            String query = "select * from clientes";
            
            // Se crea un objeto de tipo ResultSet para almacenar lo que se obtenga de la consulta
            // definida previamente. Nótese que la consulta se está realizando gracias al objeto
            // statement y el método executeQuery, al cual se le proporcionó la consulta ya mencionada.
            ResultSet resultSet = statement.executeQuery(query);
            
            System.out.println("- CLIENTES REGISTRADOS -");
            // Se itera sobre los resultados obtenidos de fila en fila utilizando el método next
            // de resultSet, el cual sólo es para saber si todavía hay registros.
            while (resultSet.next()) {
                // Para acceder a alguna columna, se debe de usar resultSet, el método para el
                // tipo de dato respectivo y el nombre de la columna. Por ejemplo, para obtener
                // el id, se debe usar getInt porque es un entero y se debe mandar como argumento
                // el nombre de la columna, que en este caso es "id".
                int id = resultSet.getInt("id");
                
                // Se obtiene el nombre del cliente.
                String nombre = resultSet.getString("nombre");
                // Se obtiene el apellido paterno del cliente.
                String apellidoP = resultSet.getString("apellidoPaterno");
                // Se obtiene el apellido materno del cliente. Aquí le estoy concatenando un espacio
                // al inicio para que se vea bien la salida si el cliente no tiene apellido materno.
                String apellidoM = " " + resultSet.getString("apellidoMaterno");
                // Si no llegase a tener apellido materno, se guardaría como " null", y si pasa eso,
                // modifico la variable para que sólo sea una cadena vacía para que cuando se concatene
                // luego no se genere un espacio de más.
                if (apellidoM.equals(" null")) apellidoM = "";
                // Se concatenan los elementos del nombre para formar el nombre completo del cliente.
                String nombreCompleto = nombre + " " + apellidoP + apellidoM;
                
                // Se obtiene el código postal del cliente.
                String cp = resultSet.getString("codigoPostal");
                // Se obtiene la colonia del cliente.
                String colonia = resultSet.getString("colonia");
                // Se obtiene la calle del cliente.
                String calle = resultSet.getString("calle");
                // Se obtiene el número exterior del cliente.
                String numExt = resultSet.getString("numExterior");
                // Se concatenan todos los datos de la dirección.
                String direccion = cp + ", " + colonia + ", " + calle + " #" + numExt;
                
                // Se muestran los datos del cliente de una manera presentable.
                System.out.println("ID: " + id + ", Nombre: " + nombreCompleto + ", Dirección: " + direccion);
            }

            // Se cierran los objetos creados anteriormente para liberar recursos y prevenir
            // la fuga de recursos.
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException sqle) {
            // Si se encontró alguna excepción relacionada con la base de datos, se manejará aquí.
            sqle.printStackTrace();
        }
    }
}
