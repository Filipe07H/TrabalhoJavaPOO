import java.util.ArrayList;
import java.util.List;

public class Agenda {
    // lista que guarda todos os contatos
    private List<Contato> contatos;
    
    // construtor - inicializa a lista vazia
    public Agenda() {
        this.contatos = new ArrayList<>();
    }
    
    // métodos para gerenciar os contatos
    
    // adiciona um novo contato na agenda
    public void adicionarContato(Contato contato) {
        // verifica se o contato é válido e tem nome
        if (contato != null && contato.getNome() != null && !contato.getNome().trim().isEmpty()) {
            // verifica se já não existe um contato com esse nome
            if (buscarPorNome(contato.getNome()) == null) {
                contatos.add(contato);
                System.out.println("Contato adicionado com sucesso!");
            } else {
                System.out.println("Erro: Já existe um contato com este nome!");
            }
        } else {
            System.out.println("Erro: Nome do contato é obrigatório!");
        }
    }
    
    // remove um contato pelo nome
    public void removerContato(String nome) {
        if (nome != null && !nome.trim().isEmpty()) {
            Contato contato = buscarPorNome(nome);
            if (contato != null) {
                contatos.remove(contato);
                System.out.println("Contato removido com sucesso!");
            } else {
                System.out.println("Contato não encontrado!");
            }
        } else {
            System.out.println("Erro: Nome é obrigatório para remoção!");
        }
    }
    
    // busca um contato pelo nome (ignora maiúsculas/minúsculas)
    public Contato buscarPorNome(String nome) {
        if (nome != null && !nome.trim().isEmpty()) {
            // percorre todos os contatos procurando pelo nome
            for (Contato contato : contatos) {
                if (contato.getNome().equalsIgnoreCase(nome.trim())) {
                    return contato;
                }
            }
        }
        return null;  // não encontrou
    }
    
    // busca um contato pelo email (ignora maiúsculas/minúsculas)
    public Contato buscarPorEmail(String email) {
        if (email != null && !email.trim().isEmpty()) {
            // percorre todos os contatos
            for (Contato contato : contatos) {
                // percorre todos os emails do contato
                for (String contatoEmail : contato.getEmails()) {
                    if (contatoEmail.equalsIgnoreCase(email.trim())) {
                        return contato;
                    }
                }
            }
        }
        return null;  // não encontrou
    }
    
    // mostra todos os contatos da agenda
    public void listarTodos() {
        if (contatos.isEmpty()) {
            System.out.println("Nenhum contato cadastrado na agenda.");
        } else {
            System.out.println("\n=== LISTA DE CONTATOS ===");
            // percorre todos os contatos mostrando cada um
            for (int i = 0; i < contatos.size(); i++) {
                System.out.println("\nContato " + (i + 1) + ":");
                System.out.println(contatos.get(i));
            }
            System.out.println("Total de contatos: " + contatos.size());
        }
    }
    
    // mostra um contato para edição (estrutura básica)
    public void editarContato(String nome) {
        if (nome != null && !nome.trim().isEmpty()) {
            Contato contato = buscarPorNome(nome);
            if (contato != null) {
                System.out.println("Contato encontrado:");
                System.out.println(contato);
                System.out.println("Use o menu de edição para modificar os dados.");
            } else {
                System.out.println("Contato não encontrado!");
            }
        } else {
            System.out.println("Erro: Nome é obrigatório para edição!");
        }
    }
    
    // Métodos auxiliares
    public boolean contatoExiste(String nome) {
        return buscarPorNome(nome) != null;
    }
    
    public int getQuantidadeContatos() {
        return contatos.size();
    }
    
    public List<Contato> getContatos() {
        return new ArrayList<>(contatos); // Retorna uma cópia para evitar modificação externa
    }
} 