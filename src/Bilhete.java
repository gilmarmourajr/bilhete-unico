import java.text.DecimalFormat;
import java.util.Random;

public class Bilhete {
    int numero;
    double saldo;
    Usuario usuario;
    Random rd = new Random();
    DecimalFormat fM = new DecimalFormat("R$##0.00");

    public Bilhete(String nomeDoUsuario, String cpf, String perfil) {
        this.numero = rd.nextInt(1000, 9999);
        this.saldo = 0;
        this.usuario = new Usuario(nomeDoUsuario, cpf, perfil);
    }

    public void carregar(double carga) {
        if(carga > 0) {
            this.saldo += carga;
        }
    }

    public void consultar() {
        System.out.println("Saldo atual: " +fM.format(this.saldo));
    }

    public void passarCatraca() {
        double result = this.saldo - Main.tarifa;
        if (result < 0) {
            System.out.println("Saldo insuficiente!");
        } else {
            this.saldo = result;
        }
    }

    @Override
    public String toString() {
        return "Bilhete N° " + this.numero + " - Saldo: " + fM.format(this.saldo) + "\n" + this.usuario;
    }
}
