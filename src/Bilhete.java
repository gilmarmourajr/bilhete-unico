import java.util.Random;

public class Bilhete {
    int numero;
    double saldo;
    Usuario usuario;
    Random rd = new Random();

    public Bilhete(String nomeDoUsuario, String cpf, String perfil) {
        this.numero = rd.nextInt(1000, 9999);
        this.saldo = 0;
        this.usuario = new Usuario(nomeDoUsuario, cpf, perfil);
    }

    @Override
    public String toString() {
        return "Bilhete N° " + this.numero + " - Saldo: " + this.saldo + "\n" + this.usuario;
    }
}
