import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.Level;

public class InformacaoUsuario {

    private static final Logger logger = Logger.getLogger(InformacaoUsuario.class.getName());

    public static void main(String[] args) {
        setupLogger();
        Scanner scanner = new Scanner(System.in);

        // Solicitar os dados do usuario
        System.out.println("Digite seu nome: ");
        String nome = scanner.nextLine();

        System.out.println("Digite sua idade: ");
        int idade = scanner.nextInt();

        scanner.nextLine(); // Limpar o buffer do teclado

        System.out.println("Digite o seu email:");
        String email = scanner.nextLine();

        // Salvar os dados do usuario em um arquivo
        try {
            FileWriter arquivo = new FileWriter("usuario.txt", true);
            arquivo.write("Nome: " + nome + "\n");
            arquivo.write("Idade: " + idade + "\n");
            arquivo.write("Email: " + email + "\n");
            arquivo.write("...........................................................\n");
            arquivo.close();
            System.out.println("Dados salvos com sucesso!");
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Erro ao salvar os dados do usuario", e);
        }

        scanner.close();
    }

    private static void setupLogger() {
        try {
            FileHandler fileHandler = new FileHandler("app.log", true);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
            logger.setLevel(Level.ALL);
        } catch (IOException e) {
            System.err.println("Não foi possível configurar o logger: " + e.getMessage());
        }
    }
}
