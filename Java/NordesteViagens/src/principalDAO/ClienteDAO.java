package principalDAO;

import java.sql.*;



import java.util.ArrayList;
import java.util.List;



import principal.Cliente;

public class ClienteDAO {
    private Connection connection;

    public ClienteDAO(Connection connection) {
        this.connection = connection;
    }

    public void inserirCliente(Cliente cliente) throws SQLException {
        String insertQuery = "INSERT INTO Cliente (cpf, nome_clien, end_clien, telefone_clien, email_clien) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            preparedStatement.setString(1, cliente.getCpf());
            preparedStatement.setString(2, cliente.getEmail_clien());
            preparedStatement.setString(3, cliente.getEnd_clien());
            preparedStatement.setString(4, cliente.getTelefone_clien());
            preparedStatement.setString(5, cliente.getEmail_clien());

            preparedStatement.executeUpdate();
        }
    }

    public List<Cliente> consultarClientes() throws SQLException {
        List<Cliente> clientes = new ArrayList<>();
        String selectQuery = "SELECT * FROM Cliente";

        try (Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(selectQuery)) {
            while (resultSet.next()) {
                Cliente cliente = new Cliente();
                cliente.setCpf(resultSet.getString("cpf"));
                cliente.setNome_clien(resultSet.getString("nome_clien"));
                cliente.setEnd_clien(resultSet.getString("end_clien"));
                cliente.setTelefone_clien(resultSet.getString("telefone_clien"));
                cliente.setEmail_clien(resultSet.getString("email_clien"));
                clientes.add(cliente);
            }
        }
        return clientes;
    }

    public void atualizarCliente(Cliente cliente) throws SQLException {
        String updateQuery = "UPDATE Cliente SET nome_clien = ?, end_clien = ?, telefone_clien = ?, email_clien = ? WHERE cpf = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
            preparedStatement.setString(1, cliente.getEmail_clien());
            preparedStatement.setString(2, cliente.getEnd_clien());
            preparedStatement.setString(3, cliente.getTelefone_clien());
            preparedStatement.setString(4, cliente.getEmail_clien());
            preparedStatement.setString(5, cliente.getCpf());

            preparedStatement.executeUpdate();
        }
    }

    public void excluirCliente(String cpf) throws SQLException {
        String deleteQuery = "DELETE FROM Cliente WHERE cpf = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
            preparedStatement.setString(1, cpf);
            preparedStatement.executeUpdate();
        }
    }
}
