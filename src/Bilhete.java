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

    public double carregar(double carga) {
        if(carga > 0) {
            this.saldo += carga;
        }
        return this.saldo;
    }

    public String consultar() {
        return "Saldo atual: " +fM.format(this.saldo);
    }

    public double passarCatraca() {
        if(this.usuario.perfil.equalsIgnoreCase("professor") || this.usuario.perfil.equalsIgnoreCase("estudante")) {
            double result = this.saldo - (Main.tarifa * 0.5);
        } else {
            double result = this.saldo - Main.tarifa;
        }

        if (result < 0) {
            System.out.println("Saldo insuficiente!");
            return saldo;
        } else {
            this.saldo = result;
        }
        return this.saldo;
    }

    @Override
    public String toString() {
        return "Bilhete N° " + this.numero + " - Saldo: " + fM.format(this.saldo) + "\n" + this.usuario;
    }
}
