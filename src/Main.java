public class Main {
    static double tarifa = 5.2;
    public static void main(String[] args) {
        Bilhete a = new Bilhete("Gil", "123.456.789-00", "Estudante");
        Bilhete b = new Bilhete("Fernando", "321.654.987-00", "Comum");
        System.out.println(a);
        System.out.println(b);
        a.carregar(50);
        b.carregar(15);
        a.consultar();
        b.consultar();

        a.passarCatraca();
        b.passarCatraca();
        a.consultar();
        b.consultar();

        b.passarCatraca();
        b.passarCatraca();
        b.passarCatraca();
        a.consultar();
        b.consultar();
    }
}