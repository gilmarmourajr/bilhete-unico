import java.text.DecimalFormat;
import java.util.Random;

public class Bilhete {
    private int numero;
    private double saldo;
    private Usuario usuario;
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

    public String passarCatraca() {
        double debito = Main.tarifa / 2;
        if(this.usuario.getPerfil().equalsIgnoreCase("comum")) {
            debito = Main.tarifa;
        }

        if(this.saldo >= debito) {
            this.saldo -= debito;
            return "Passagem liberada!";
        }

        return "Saldo insuficiente.";
    }

    public Usuario getUsuario() {
        return usuario;
    }

    @Override
    public String toString() {
        return "Bilhete N° " + this.numero + " - Saldo: " + fM.format(this.saldo) + "\n" + this.usuario;
    }
}
