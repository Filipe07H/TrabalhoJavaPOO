public class Endereco {
    // aqui guardamos os dados do endereço
    private String rua;
    private String cidade;
    private String estado;
    private String cep;
    
    // construtor vazio (sem parâmetros)
    public Endereco() {
    }
    
    // construtor com todos os dados do endereço
    public Endereco(String rua, String cidade, String estado, String cep) {
        this.rua = rua;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }
    
    // getters e setters - para acessar e modificar os dados
    public String getRua() {
        return rua;
    }
    
    public void setRua(String rua) {
        this.rua = rua;
    }
    
    public String getCidade() {
        return cidade;
    }
    
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    
    public String getEstado() {
        return estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public String getCep() {
        return cep;
    }
    
    public void setCep(String cep) {
        this.cep = cep;
    }
    
    // método para mostrar o endereço de forma bonita
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Endereço: ");
        
        // só mostra a rua se ela existir
        if (rua != null && !rua.trim().isEmpty()) {
            sb.append(rua);
        }
        
        // só mostra a cidade se ela existir
        if (cidade != null && !cidade.trim().isEmpty()) {
            if (sb.length() > 10) sb.append(", ");
            sb.append(cidade);
        }
        
        // só mostra o estado se ele existir
        if (estado != null && !estado.trim().isEmpty()) {
            if (sb.length() > 10) sb.append(" - ");
            sb.append(estado);
        }
        
        // só mostra o CEP se ele existir
        if (cep != null && !cep.trim().isEmpty()) {
            if (sb.length() > 10) sb.append(", CEP: ");
            sb.append(cep);
        }
        
        return sb.toString();
    }
} 