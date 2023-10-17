package principalDAO;

import java.sql.*;



import java.util.ArrayList;
import java.util.List;

import principal.Passagem;

public class PassagemDAO {
    private Connection connection;

    public PassagemDAO(Connection connection) {
        this.connection = connection;
    }

    public void inserirPassagem(Passagem passagem) throws SQLException {
        String insertQuery = "INSERT INTO Passagem (id_clien, nome_clien, data_compra, qtd_passagens, preco_passagem, preco_total) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            preparedStatement.setString(1, passagem.getId_clien());
            preparedStatement.setString(2, passagem.getNome_clien());
            preparedStatement.setDate(3, new java.sql.Date(passagem.getData_compra().getTime()));
            preparedStatement.setInt(4, passagem.getQtd_passagens());
            preparedStatement.setDouble(5, passagem.getPreco_passagem());
            preparedStatement.setDouble(6, passagem.getPreco_total());

            preparedStatement.executeUpdate();
        }
    }

    public List<Passagem> consultarPassagens() throws SQLException {
        List<Passagem> passagens = new ArrayList<>();
        String selectQuery = "SELECT * FROM Passagem";

        try (Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(selectQuery)) {
            while (resultSet.next()) {
                Passagem passagem = new Passagem();
                passagem.setPassagem_id(resultSet.getInt("passagem_id"));
                passagem.setId_clien(resultSet.getString("id_clien"));
                passagem.setNome_clien(resultSet.getString("nome_clien"));
                passagem.setData_compra(resultSet.getDate("data_compra"));
                passagem.setQtd_passagens(resultSet.getInt("qtd_passagens"));
                passagem.setPreco_passagem(resultSet.getDouble("preco_passagem"));
                passagem.setPreco_total(resultSet.getDouble("preco_total"));
                passagens.add(passagem);
            }
        }
        return passagens;
    }

    public void atualizarPassagem(Passagem passagem) throws SQLException {
        String updateQuery = "UPDATE Passagem SET id_clien = ?, nome_clien = ?, data_compra = ?, qtd_passagens = ?, preco_passagem = ?, preco_total = ? WHERE passagem_id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
            preparedStatement.setString(1, passagem.getId_clien());
            preparedStatement.setString(2, passagem.getNome_clien());
            preparedStatement.setDate(3, new java.sql.Date(passagem.getData_compra().getTime()));
            preparedStatement.setInt(4, passagem.getQtd_passagens());
            preparedStatement.setDouble(5, passagem.getPreco_passagem());
            preparedStatement.setDouble(6, passagem.getPreco_total());
            preparedStatement.setInt(7, passagem.getPassagem_id());

            preparedStatement.executeUpdate();
        }
    }

    public void excluirPassagem(int passagemId) throws SQLException {
        String deleteQuery = "DELETE FROM Passagem WHERE passagem_id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
            preparedStatement.setInt(1, passagemId);
            preparedStatement.executeUpdate();
        }
    }
}
