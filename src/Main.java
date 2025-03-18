import javax.swing.*;

public class Main {
    static double tarifa = 5.2;
    public static void main(String[] args) {
        Bilhete a = new Bilhete("Gil", "123.456.789-00", "Estudante");
        Bilhete b = new Bilhete("Fernando", "321.654.987-00", "Comum");
        System.out.println(a);
        System.out.println(b);
        a.carregar(50);
        b.carregar(10);
        System.out.println(a.consultar());
        System.out.println(b.consultar());

        System.out.println(a.passarCatraca());
        System.out.println(b.passarCatraca());
        System.out.println(a.consultar());
        System.out.println(b.consultar());

        System.out.println(b.passarCatraca());
        System.out.println(a.consultar());
        System.out.println(b.consultar());

        JOptionPane.showMessageDialog(null, "oierrrr");
        String nome = JOptionPane.showInputDialog("qual seu nome?");
    }
}