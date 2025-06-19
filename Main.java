import java.util.Scanner;

public class Main {
    // agenda que vai guardar todos os contatos
    private static Agenda agenda = new Agenda();
    // scanner para ler o que o usuário digita
    private static Scanner scanner = new Scanner(System.in);
    
    // método principal - onde tudo começa
    public static void main(String[] args) {
        System.out.println("=== AGENDA DE CONTATOS ===");
        System.out.println("Bem-vindo ao sistema de gerenciamento de contatos!");
        
        // loop principal do programa
        while (true) {
            exibirMenu();
            try {
                // lê a opção que o usuário escolheu
                int opcao = Integer.parseInt(scanner.nextLine());
                if (opcao == 8) break;  // sai do programa
                processarOpcao(opcao);
            } catch (NumberFormatException e) {
                System.out.println("Erro: Digite um número válido!");
            } catch (Exception e) {
                System.out.println("Erro inesperado: " + e.getMessage());
            }
        }
        
        System.out.println("Obrigado por usar a Agenda de Contatos!");
        scanner.close();
    }
    
    // mostra o menu principal na tela
    private static void exibirMenu() {
        System.out.println("\n=== MENU PRINCIPAL ===");
        System.out.println("1. Adicionar contato pessoal");
        System.out.println("2. Adicionar contato profissional");
        System.out.println("3. Listar todos os contatos");
        System.out.println("4. Buscar contato por nome");
        System.out.println("5. Buscar contato por e-mail");
        System.out.println("6. Editar contato");
        System.out.println("7. Remover contato");
        System.out.println("8. Sair");
        System.out.print("Escolha uma opção: ");
    }
    
    // decide o que fazer baseado na opção escolhida
    private static void processarOpcao(int opcao) {
        switch (opcao) {
            case 1:
                adicionarContatoPessoal();
                break;
            case 2:
                adicionarContatoProfissional();
                break;
            case 3:
                agenda.listarTodos();
                break;
            case 4:
                buscarPorNome();
                break;
            case 5:
                buscarPorEmail();
                break;
            case 6:
                editarContato();
                break;
            case 7:
                removerContato();
                break;
            default:
                System.out.println("Opção inválida! Digite um número entre 1 e 8.");
        }
    }
    
    // adiciona um contato pessoal
    private static void adicionarContatoPessoal() {
        try {
            System.out.println("\n=== ADICIONAR CONTATO PESSOAL ===");
            
            // lê o nome do contato
            String nome = lerNome();
            if (nome == null) return;
            
            // cria o contato pessoal
            ContatoPessoal contato = new ContatoPessoal(nome);
            
            // lê os dados básicos (telefone, email, endereço)
            lerDadosBasicos(contato);
            lerEndereco(contato);
            
            // lê a data de aniversário
            System.out.print("Data de aniversário (DD/MM/AAAA): ");
            String dataAniversario = scanner.nextLine().trim();
            if (!dataAniversario.isEmpty()) {
                contato.setDataAniversario(dataAniversario);
            }
            
            // adiciona o contato na agenda
            agenda.adicionarContato(contato);
            
        } catch (Exception e) {
            System.out.println("Erro ao adicionar contato pessoal: " + e.getMessage());
        }
    }
    
    // adiciona um contato profissional
    private static void adicionarContatoProfissional() {
        try {
            System.out.println("\n=== ADICIONAR CONTATO PROFISSIONAL ===");
            
            // lê o nome do contato
            String nome = lerNome();
            if (nome == null) return;
            
            // cria o contato profissional
            ContatoProfissional contato = new ContatoProfissional(nome);
            
            // lê os dados básicos (telefone, email, endereço)
            lerDadosBasicos(contato);
            lerEndereco(contato);
            
            // lê os dados profissionais
            System.out.print("Empresa: ");
            String empresa = scanner.nextLine().trim();
            if (!empresa.isEmpty()) {
                contato.setEmpresa(empresa);
            }
            
            System.out.print("Cargo: ");
            String cargo = scanner.nextLine().trim();
            if (!cargo.isEmpty()) {
                contato.setCargo(cargo);
            }
            
            // adiciona o contato na agenda
            agenda.adicionarContato(contato);
            
        } catch (Exception e) {
            System.out.println("Erro ao adicionar contato profissional: " + e.getMessage());
        }
    }
    
    // lê o nome do contato (método auxiliar)
    private static String lerNome() {
        System.out.print("Nome completo: ");
        String nome = scanner.nextLine().trim();
        
        if (nome.isEmpty()) {
            System.out.println("Erro: Nome é obrigatório!");
            return null;
        }
        return nome;
    }
    
    // lê telefone e email (método auxiliar)
    private static void lerDadosBasicos(Contato contato) {
        // lê o telefone
        System.out.print("Telefone (ou pressione Enter para pular): ");
        String telefone = scanner.nextLine().trim();
        if (!telefone.isEmpty()) {
            contato.adicionarTelefone(telefone);
        }
        
        // lê o email
        System.out.print("E-mail (ou pressione Enter para pular): ");
        String email = scanner.nextLine().trim();
        if (!email.isEmpty()) {
            contato.adicionarEmail(email);
        }
    }
    
    // lê os dados do endereço (método auxiliar)
    private static void lerEndereco(Contato contato) {
        System.out.println("\n--- Dados do Endereço ---");
        System.out.print("Rua: ");
        String rua = scanner.nextLine().trim();
        System.out.print("Cidade: ");
        String cidade = scanner.nextLine().trim();
        System.out.print("Estado: ");
        String estado = scanner.nextLine().trim();
        System.out.print("CEP: ");
        String cep = scanner.nextLine().trim();
        
        // só cria o endereço se pelo menos um campo foi preenchido
        if (!rua.isEmpty() || !cidade.isEmpty() || !estado.isEmpty() || !cep.isEmpty()) {
            Endereco endereco = new Endereco(rua, cidade, estado, cep);
            contato.setEndereco(endereco);
        }
    }
    
    // busca um contato pelo nome
    private static void buscarPorNome() {
        try {
            System.out.print("\nDigite o nome do contato: ");
            String nome = scanner.nextLine().trim();
            
            if (nome.isEmpty()) {
                System.out.println("Erro: Nome é obrigatório!");
                return;
            }
            
            // busca o contato na agenda
            Contato contato = agenda.buscarPorNome(nome);
            if (contato != null) {
                System.out.println("\nContato encontrado:");
                System.out.println(contato);
            } else {
                System.out.println("Contato não encontrado!");
            }
            
        } catch (Exception e) {
            System.out.println("Erro na busca: " + e.getMessage());
        }
    }
    
    // busca um contato pelo email
    private static void buscarPorEmail() {
        try {
            System.out.print("\nDigite o e-mail do contato: ");
            String email = scanner.nextLine().trim();
            
            if (email.isEmpty()) {
                System.out.println("Erro: E-mail é obrigatório!");
                return;
            }
            
            // busca o contato na agenda
            Contato contato = agenda.buscarPorEmail(email);
            if (contato != null) {
                System.out.println("\nContato encontrado:");
                System.out.println(contato);
            } else {
                System.out.println("Contato não encontrado!");
            }
            
        } catch (Exception e) {
            System.out.println("Erro na busca: " + e.getMessage());
        }
    }
    
    // mostra um contato para edição (estrutura básica)
    private static void editarContato() {
        try {
            System.out.print("\nDigite o nome do contato a ser editado: ");
            String nome = scanner.nextLine().trim();
            
            if (nome.isEmpty()) {
                System.out.println("Erro: Nome é obrigatório!");
                return;
            }
            
            // busca o contato na agenda
            Contato contato = agenda.buscarPorNome(nome);
            if (contato != null) {
                System.out.println("\nContato encontrado:");
                System.out.println(contato);
                System.out.println("\nFuncionalidade de edição será implementada em versões futuras.");
                System.out.println("Por enquanto, remova o contato e adicione novamente com os dados corretos.");
            } else {
                System.out.println("Contato não encontrado!");
            }
            
        } catch (Exception e) {
            System.out.println("Erro na edição: " + e.getMessage());
        }
    }
    
    // remove um contato da agenda
    private static void removerContato() {
        try {
            System.out.print("\nDigite o nome do contato a ser removido: ");
            String nome = scanner.nextLine().trim();
            
            if (nome.isEmpty()) {
                System.out.println("Erro: Nome é obrigatório!");
                return;
            }
            
            // remove o contato da agenda
            agenda.removerContato(nome);
            
        } catch (Exception e) {
            System.out.println("Erro na remoção: " + e.getMessage());
        }
    }
} 