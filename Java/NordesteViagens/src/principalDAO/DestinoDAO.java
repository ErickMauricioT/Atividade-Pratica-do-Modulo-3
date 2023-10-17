package principalDAO;

import java.sql.*;



import java.util.ArrayList;
import java.util.List;

import principal.Destino;

public class DestinoDAO {
    private Connection connection;

    public DestinoDAO(Connection connection) {
        this.connection = connection;
    }

    public void inserirDestino(Destino destino) throws SQLException {
        String insertQuery = "INSERT INTO Destino (local_destino, data_viagem) VALUES (?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            preparedStatement.setString(1, destino.getLocal_destino());
            preparedStatement.setDate(2, new java.sql.Date(destino.getData_viagem().getTime()));

            preparedStatement.executeUpdate();
        }
    }

    public List<Destino> consultarDestinos() throws SQLException {
        List<Destino> destinos = new ArrayList<>();
        String selectQuery = "SELECT * FROM Destino";

        try (Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(selectQuery)) {
            while (resultSet.next()) {
                Destino destino = new Destino();
                destino.setLocal_destino(resultSet.getString("local_destino"));
                destino.setData_viagem(resultSet.getDate("data_viagem"));
                destinos.add(destino);
            }
        }
        return destinos;
    }

    public void atualizarDestino(Destino destino) throws SQLException {
        String updateQuery = "UPDATE Destino SET local_destino = ?, data_viagem = ? WHERE cod_destino = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
            preparedStatement.setString(1, destino.getLocal_destino());
            preparedStatement.setDate(2, new java.sql.Date(destino.getData_viagem().getTime()));
            preparedStatement.setInt(3, destino.getCod_destino());

            preparedStatement.executeUpdate();
        }
    }

    public void excluirDestino(int codDestino) throws SQLException {
        String deleteQuery = "DELETE FROM Destino WHERE cod_destino = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
            preparedStatement.setInt(1, codDestino);
            preparedStatement.executeUpdate();
        }
    }
}
