public class Usuario {
    private String nome;
    private String cpf;
    private String perfil;

    public Usuario(String nome, String cpf, String perfil) {
        this.nome = nome;
        this.cpf = cpf;
        this.perfil = perfil;
    }

    public String getNome() {
        return nome;
    }

    public String getPerfil() {
        return perfil;
    }

    @Override
    public String toString() {
        return this.nome + ", CPF " + this.cpf + " - Perfil: " + this.perfil;
    }
}
