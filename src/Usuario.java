public class Usuario {
    String nome;
    String cpf;
    String perfil;

    public Usuario(String nome, String cpf, String perfil) {
        this.nome = nome;
        this.cpf = cpf;
        this.perfil = perfil;
    }

    @Override
    public String toString() {
        return this.nome + ", CPF " + this.cpf + " - Perfil: " + this.perfil;
    }
}
