package principal;

import java.sql.*;

import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String jdbcUrl = "jdbc:mysql://localhost:3306/nordeste_viagens";
        String username = "root";
        String password = "1234";

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            
            
            while (true) {
                System.out.println("Escolha uma opção e Pressione Enter.");
                System.out.println("Digite 1 Para == Cliente ==");
                System.out.println("Digite 2 Para == Destino ==");
                System.out.println("Digite 3 Para == Passagem ==");
                System.out.println("Digite 0 Para  == Sair ==");

                int choice = scanner.nextInt();
                scanner.nextLine();

                if (choice == 0) {
                    break;
                }

                switch (choice) {
                    case 1:
                        menuCliente(connection, scanner);
                        break;
                    case 2:
                        menuDestino(connection, scanner);
                        break;
                    case 3:
                        menuPassagem(connection, scanner);
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
            }

            connection.close();
            System.out.println("Conexão com o banco de dados fechada.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void menuCliente(Connection connection, Scanner scanner) {
        while (true) {
            System.out.println("Opções Para Cliente:");
            System.out.println("1. Inserir novo cliente");
            System.out.println("2. Consultar clientes");
            System.out.println("3. Atualizar cliente");
            System.out.println("4. Excluir cliente");
            System.out.println("0. Voltar");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 0) {
                break;
            }

            switch (choice) {
                case 1:
                    insertCliente(connection, scanner);
                    break;
                case 2:
                    consultarClientes(connection);
                    break;
                case 3:
                    atualizarCliente(connection, scanner);
                    break;
                case 4:
                    excluirCliente(connection, scanner);
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private static void insertCliente(Connection connection, Scanner scanner) {
        System.out.println("Inserir um novo cliente:");

        try {
            System.out.print("CPF do cliente: ");
            String cpf = scanner.nextLine();

            System.out.print("Nome do cliente: ");
            String nomeCliente = scanner.nextLine();

            System.out.print("Endereço do cliente: ");
            String endereco = scanner.nextLine();

            System.out.print("Telefone do cliente: ");
            String telefone = scanner.nextLine();

            System.out.print("Email do cliente: ");
            String email = scanner.nextLine();

            
            String insertQuery = "INSERT INTO Cliente (cpf, nome_clien, end_clien, telefone_clien, email_clien) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, cpf);
            preparedStatement.setString(2, nomeCliente);
            preparedStatement.setString(3, endereco);
            preparedStatement.setString(4, telefone);
            preparedStatement.setString(5, email);

            int rowsInserted = preparedStatement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("Cliente inserido com sucesso!");
            } else {
                System.out.println("Falha ao inserir o cliente.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void consultarClientes(Connection connection) {
        System.out.println("Consultar clientes:");
        try {
            Statement statement = connection.createStatement();
            String selectQuery = "SELECT * FROM Cliente";
            ResultSet resultSet = statement.executeQuery(selectQuery);

            while (resultSet.next()) {
                String cpf = resultSet.getString("cpf");
                String nomeCliente = resultSet.getString("nome_clien");
                String endereco = resultSet.getString("end_clien");
                String telefone = resultSet.getString("telefone_clien");
                String email = resultSet.getString("email_clien");

                System.out.println("CPF: " + cpf);
                System.out.println("Nome do Cliente: " + nomeCliente);
                System.out.println("Endereço: " + endereco);
                System.out.println("Telefone: " + telefone);
                System.out.println("Email: " + email);
                System.out.println("----------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void atualizarCliente(Connection connection, Scanner scanner) {
        System.out.println("Atualizar cliente:");

        System.out.print("CPF do cliente a ser atualizado: ");
        String cpf = scanner.nextLine();

        try {
            System.out.print("Novo nome do cliente: ");
            String novoNome = scanner.nextLine();

            String updateQuery = "UPDATE Cliente SET nome_clien = ? WHERE cpf = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
            preparedStatement.setString(1, novoNome);
            preparedStatement.setString(2, cpf);

            int rowsUpdated = preparedStatement.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Cliente atualizado com sucesso!");
            } else {
                System.out.println("CPF Invalido ou Inexistente");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void excluirCliente(Connection connection, Scanner scanner) {
        System.out.println("Excluir cliente:");

        System.out.print("CPF do cliente a ser excluído: ");
        String cpf = scanner.nextLine();

        try {
            String deleteQuery = "DELETE FROM Cliente WHERE cpf = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.setString(1, cpf);

            int rowsDeleted = preparedStatement.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("Cliente excluído com sucesso!");
            } else {
                System.out.println("Nenhum CPF encontrado com o ID especificado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void menuDestino(Connection connection, Scanner scanner) {
        while (true) {
            System.out.println("Opções para Destino:");
            System.out.println("1. Inserir novo destino");
            System.out.println("2. Consultar destinos");
            System.out.println("3. Atualizar destino");
            System.out.println("4. Excluir destino");
            System.out.println("0. Voltar");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 0) {
                break;
            }

            switch (choice) {
                case 1:
                    insertDestino(connection, scanner);
                    break;
                case 2:
                    consultarDestinos(connection);
                    break;
                case 3:
                    atualizarDestino(connection, scanner);
                    break;
                case 4:
                    excluirDestino(connection, scanner);
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private static void insertDestino(Connection connection, Scanner scanner) {
        System.out.println("Inserir um novo destino:");

        try {
            System.out.print("Nome do destino: ");
            String nomeDestino = scanner.nextLine();

            System.out.print("Descrição do destino: ");
            String descricaoDestino = scanner.nextLine();

            System.out.print("Preço do destino: ");
            double precoDestino = scanner.nextDouble();

            
            String insertQuery = "INSERT INTO Destino (nome_destino, descricao_destino, preco_destino) VALUES (?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, nomeDestino);
            preparedStatement.setString(2, descricaoDestino);
            preparedStatement.setDouble(3, precoDestino);

            int rowsInserted = preparedStatement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("Destino inserido com sucesso!");
            } else {
                System.out.println("Falha ao inserir o destino.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void consultarDestinos(Connection connection) {
        System.out.println("Consultar destinos:");
        try {
            Statement statement = connection.createStatement();
            String selectQuery = "SELECT * FROM Destino";
            ResultSet resultSet = statement.executeQuery(selectQuery);

            while (resultSet.next()) {
                int destinoId = resultSet.getInt("destino_id");
                String nomeDestino = resultSet.getString("nome_destino");
                String descricaoDestino = resultSet.getString("descricao_destino");
                double precoDestino = resultSet.getDouble("preco_destino");

                System.out.println("ID do Destino: " + destinoId);
                System.out.println("Nome do Destino: " + nomeDestino);
                System.out.println("Descrição do Destino: " + descricaoDestino);
                System.out.println("Preço do Destino: " + precoDestino);
                System.out.println("----------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void atualizarDestino(Connection connection, Scanner scanner) {
        System.out.println("Atualizar destino:");

        System.out.print("ID do destino a ser atualizado: ");
        int destinoId = scanner.nextInt();
        scanner.nextLine();

        try {
            System.out.print("Novo nome do destino: ");
            String novoNomeDestino = scanner.nextLine();

            System.out.print("Nova descrição do destino: ");
            String novaDescricaoDestino = scanner.nextLine();

            System.out.print("Novo preço do destino: ");
            double novoPrecoDestino = scanner.nextDouble();

            String updateQuery = "UPDATE Destino SET nome_destino = ?, descricao_destino = ?, preco_destino = ? WHERE destino_id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
            preparedStatement.setString(1, novoNomeDestino);
            preparedStatement.setString(2, novaDescricaoDestino);
            preparedStatement.setDouble(3, novoPrecoDestino);
            preparedStatement.setInt(4, destinoId);

            int rowsUpdated = preparedStatement.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Destino atualizado com sucesso!");
            } else {
                System.out.println("DESTINO Invalido ou Inexistente");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void excluirDestino(Connection connection, Scanner scanner) {
        System.out.println("Excluir destino:");

        System.out.print("ID do destino a ser excluído: ");
        int destinoId = scanner.nextInt();
        scanner.nextLine();

        try {
            String deleteQuery = "DELETE FROM Destino WHERE destino_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.setInt(1, destinoId);

            int rowsDeleted = preparedStatement.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("Destino excluído com sucesso!");
            } else {
                System.out.println("Nenhum destino encontrado com o ID especificado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void menuPassagem(Connection connection, Scanner scanner) {
        while (true) {
            System.out.println("Opções Para Passagem:");
            System.out.println("1. Inserir nova passagem");
            System.out.println("2. Consultar passagens");
            System.out.println("3. Atualizar passagem");
            System.out.println("4. Excluir passagem");
            System.out.println("0. Voltar");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 0) {
                break;
            }

            switch (choice) {
                case 1:
                    insertPassagem(connection, scanner);
                    break;
                case 2:
                    consultarPassagens(connection);
                    break;
                case 3:
                    atualizarPassagem(connection, scanner);
                    break;
                case 4:
                    excluirPassagem(connection, scanner);
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private static void insertPassagem(Connection connection, Scanner scanner) {
        System.out.println("Inserir uma nova passagem:");

        try {
            System.out.print("ID do cliente: ");
            String idCliente = scanner.nextLine();

            System.out.print("Nome do cliente: ");
            String nomeCliente = scanner.nextLine();

            System.out.print("Data da compra (no formato yyyy-MM-dd): ");
            String dataCompraStr = scanner.nextLine();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date dataCompra = sdf.parse(dataCompraStr);

            System.out.print("Quantidade de passagens: ");
            int quantidadePassagens = scanner.nextInt();

            System.out.print("Preço por passagem: ");
            double precoPorPassagem = scanner.nextDouble();

            double precoTotal = quantidadePassagens * precoPorPassagem;

           
            String insertQuery = "INSERT INTO Passagem (id_clien, nome_clien, data_compra, qtd_passagens, preco_passagem, preco_total) VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, idCliente);
            preparedStatement.setString(2, nomeCliente);
            preparedStatement.setDate(3, new java.sql.Date(dataCompra.getTime()));
            preparedStatement.setInt(4, quantidadePassagens);
            preparedStatement.setDouble(5, precoPorPassagem);
            preparedStatement.setDouble(6, precoTotal);

            int rowsInserted = preparedStatement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("Passagem inserida com sucesso!");
            } else {
                System.out.println("Falha ao inserir a passagem.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void consultarPassagens(Connection connection) {
        System.out.println("Consultar passagens:");
        try {
            Statement statement = connection.createStatement();
            String selectQuery = "SELECT * FROM Passagem";
            ResultSet resultSet = statement.executeQuery(selectQuery);

            while (resultSet.next()) {
                int passagemId = resultSet.getInt("passagem_id");
                String idCliente = resultSet.getString("id_clien");
                String nomeCliente = resultSet.getString("nome_clien");
                Date dataCompra = resultSet.getDate("data_compra");
                int quantidadePassagens = resultSet.getInt("qtd_passagens");
                double precoPorPassagem = resultSet.getDouble("preco_passagem");
                double precoTotal = resultSet.getDouble("preco_total");

                System.out.println("ID da Passagem: " + passagemId);
                System.out.println("ID do Cliente: " + idCliente);
                System.out.println("Nome do Cliente: " + nomeCliente);
                System.out.println("Data da Compra: " + dataCompra);
                System.out.println("Quantidade de Passagens: " + quantidadePassagens);
                System.out.println("Preço por Passagem: " + precoPorPassagem);
                System.out.println("Preço Total: " + precoTotal);
                System.out.println("----------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void atualizarPassagem(Connection connection, Scanner scanner) {
        System.out.println("Atualizar passagem:");

        System.out.print("ID da passagem a ser atualizada: ");
        int passagemId = scanner.nextInt();
        scanner.nextLine();

        try {
            System.out.print("Novo ID do cliente: ");
            String novoIdCliente = scanner.nextLine();

            System.out.print("Novo nome do cliente: ");
            String novoNomeCliente = scanner.nextLine();

            System.out.print("Nova data da compra (no formato yyyy-MM-dd): ");
            String novaDataCompraStr = scanner.nextLine();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date novaDataCompra = sdf.parse(novaDataCompraStr);

            System.out.print("Nova quantidade de passagens: ");
            int novaQuantidadePassagens = scanner.nextInt();

            System.out.print("Novo preço por passagem: ");
            double novoPrecoPorPassagem = scanner.nextDouble();

            double novoPreçoTotal = novaQuantidadePassagens * novoPrecoPorPassagem;

            String updateQuery = "UPDATE Passagem SET id_clien = ?, nome_clien = ?, data_compra = ?, qtd_passagens = ?, preco_passagem = ?, preco_total = ? WHERE passagem_id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
            preparedStatement.setString(1, novoIdCliente);
            preparedStatement.setString(2, novoNomeCliente);
            preparedStatement.setDate(3, new java.sql.Date(novaDataCompra.getTime()));
            preparedStatement.setInt(4, novaQuantidadePassagens);
            preparedStatement.setDouble(5, novoPrecoPorPassagem);
            preparedStatement.setDouble(6, novoPreçoTotal);
            preparedStatement.setInt(7, passagemId);

            int rowsUpdated = preparedStatement.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Passagem atualizada com sucesso!");
            } else {
                System.out.println("PASSAGEM Invalida ou Inexistente");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void excluirPassagem(Connection connection, Scanner scanner) {
        System.out.println("Excluir passagem:");

        System.out.print("ID da passagem a ser excluída: ");
        int passagemId = scanner.nextInt();
        scanner.nextLine();

        try {
            String deleteQuery = "DELETE FROM Passagem WHERE passagem_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.setInt(1, passagemId);

            int rowsDeleted = preparedStatement.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("Passagem excluída com sucesso!");
            } else {
                System.out.println("Nenhuma passagem encontrada com o ID especificado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}