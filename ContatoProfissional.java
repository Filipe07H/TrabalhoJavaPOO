public class ContatoProfissional extends Contato {
    // dados específicos de contato profissional
    private String empresa;
    private String cargo;
    
    // construtor vazio
    public ContatoProfissional() {
        super();  // chama o construtor da classe pai (Contato)
    }
    
    // construtor só com nome
    public ContatoProfissional(String nome) {
        super(nome);  // chama o construtor da classe pai com nome
    }
    
    // construtor completo com todos os dados
    public ContatoProfissional(String nome, Endereco endereco, String empresa, String cargo) {
        super(nome, endereco);  // chama o construtor da classe pai
        this.empresa = empresa;
        this.cargo = cargo;
    }
    
    // getters e setters para dados profissionais
    public String getEmpresa() {
        return empresa;
    }
    
    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }
    
    public String getCargo() {
        return cargo;
    }
    
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
    // método para mostrar o contato profissional de forma bonita
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== CONTATO PROFISSIONAL ===\n");
        sb.append(super.toString());  // chama o toString da classe pai
        
        // só mostra a empresa se ela existir
        if (empresa != null && !empresa.trim().isEmpty()) {
            sb.append("Empresa: ").append(empresa).append("\n");
        }
        
        // só mostra o cargo se ele existir
        if (cargo != null && !cargo.trim().isEmpty()) {
            sb.append("Cargo: ").append(cargo).append("\n");
        }
        
        sb.append("===========================\n");
        return sb.toString();
    }
} 