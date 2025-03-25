import javax.swing.*;
import java.util.ArrayList;
//import java.util.Scanner;

public class Interface {
//    private Scanner sc;
    private ArrayList<Bilhete> bilhetes;
    private String senhaAdm;

    public Interface() {
//        sc = new Scanner(System.in);
        bilhetes = new ArrayList<>();
        senhaAdm = "1234";
    }

    public void start() {
        int input = 0;
        while (input != 3) {
            input = Integer.parseInt(JOptionPane.showInputDialog("Selecione o tipo de usuário:\n1 - Comum\n" +
                    "2 - Administrador\n3 - Encerrar programa"));
//            System.out.println("Selecione o tipo de usuário:");
//            System.out.println("1 - Comum");
//            System.out.println("2 - Administrador");
//            System.out.println("3 - Encerrar programa");
//            input = Integer.parseInt(sc.nextLine());

            while (input < 1 || input > 3) {
                input = Integer.parseInt(JOptionPane.showInputDialog("Digite uma opção válida (de 1 a 3)."));
//                System.out.println("Digite uma opção válida (de 1 a 3).");
//                input = Integer.parseInt(sc.nextLine());
            }

            if (input == 1) {
                if (bilhetes.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Nenhum bilhete cadastrado.");
//                    System.out.println("Nenhum bilhete cadastrado.\n");
                } else {
                    this.menuComum();
                }
            }

            if (input == 2) {
                String senha = JOptionPane.showInputDialog("Digite a senha do administrador.");
//                System.out.println("Digite a senha do administrador:");
//                String senha = sc.nextLine();
                if (senha.equals(senhaAdm)) {
                    this.menuAdm();
                } else {
                    JOptionPane.showMessageDialog(null, "Senha incorreta.");
//                    System.out.println("Senha incorreta.\n");
                }
            }
        }
    }

    private void menuComum() {
        Bilhete bilhete = selecaoUsuario();
        if(bilhete == null) {
            return;
        }
        JOptionPane.showMessageDialog(null, "Olá, " + bilhete.getUsuario().getNome());
//        System.out.println("Olá, " + bilhete.getUsuario().getNome());
        int input = 0;
        while (input != 4) {
            input = Integer.parseInt(JOptionPane.showInputDialog("Selecione a opção desejada:\n" +
                    "1 - Consultar saldo do bilhete\n2 - Carregar bilhete\n" +
                    "3 - Passar na catraca\n4 - Sair"));
//            System.out.println("Selecione a opção desejada:");
//            System.out.println("1 - Consultar saldo do bilhete");
//            System.out.println("2 - Carregar bilhete");
//            System.out.println("3 - Passar na catraca");
//            System.out.println("4 - Sair");
//            input = Integer.parseInt(sc.nextLine());

            while (input < 1 || input > 4) {
                input = Integer.parseInt(JOptionPane.showInputDialog("Digite uma opção válida (de 1 a 4)."));
//                System.out.println("Digite uma opção válida (de 1 a 4).");
//                input = Integer.parseInt(sc.nextLine());
            }

            if (input == 1) {
                JOptionPane.showMessageDialog(null, bilhete.consultar());
//                System.out.println(bilhete.consultar());
            }

            if (input == 2) {
                usuarioCarregar(bilhete);
            }

            if (input == 3) {
                JOptionPane.showMessageDialog(null, bilhete.passarCatraca());
//                System.out.println(bilhete.passarCatraca());
            }
        }
    }

    private void menuAdm() {
        JOptionPane.showMessageDialog(null, "Olá, ADM");
//        System.out.println("Olá, ADM");
        int input = 0;
        while (input != 4) {
            input = Integer.parseInt(JOptionPane.showInputDialog("Selecione a opção desejada:\n1 - Emitir novo bilhete\n" +
                    "2 - Listar os bilhetes cadastrados\n3 - Remover bilhete\n4 - Sair"));
//            System.out.println("Selecione a opção desejada:");
//            System.out.println("1 - Emitir novo bilhete");
//            System.out.println("2 - Listar os bilhetes cadastrados");
//            System.out.println("3 - Remover bilhete");
//            System.out.println("4 - Sair");
//            input = Integer.parseInt(sc.nextLine());

            while (input < 1 || input > 4) {
                input = Integer.parseInt(JOptionPane.showInputDialog("Digite uma opção válida (de 1 a 4)."));
//                System.out.println("Digite uma opção válida (de 1 a 4).");
//                input = Integer.parseInt(sc.nextLine());
            }

            if (input == 1) {
                emitirBilhete();
            }

            if (input == 2) {
                if (this.bilhetes.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Nenhum bilhete cadastrado.");
//                    System.out.println();
                } else {
                    JOptionPane.showMessageDialog(null, listarUsuarios());
//                    System.out.println(listarUsuarios());
                }
            }

            if (input == 3) {
                if (bilhetes.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Nenhum bilhete cadastrado.");
//                    System.out.println("Nenhum bilhete cadastrado.\n");
                } else {
                    bilhetes.remove(selecaoUsuario());
                }
            }
        }
    }

    private Bilhete selecaoUsuario() {
//        --- busca com lista

//        String output = "Selecione o usuário: \n" + listarUsuarios();
//
//        int input = Integer.parseInt(JOptionPane.showInputDialog(output)) - 1;
////        System.out.println(output);
////        int input = (Integer.parseInt(sc.nextLine()) - 1);
//
//        while(input>=this.bilhetes.size() || input<0) {
//            input = Integer.parseInt(JOptionPane.showInputDialog("Insira uma opção válida (de 1 a " + this.bilhetes.size() + ").")) - 1;
//            System.out.println("Insira uma opção válida (de 1 a " + this.bilhetes.size() + ").");
//            input = (Integer.parseInt(sc.nextLine()) - 1);

//        return this.bilhetes.get(input);

//        --- busca sem listar usuários

        String busca = JOptionPane.showInputDialog("Digite o CPF do usuário.");
        for (Bilhete bilhete : bilhetes) {
            if(bilhete.getUsuario().getCpf().equals(busca)) {
                return bilhete;
            }
        }

        JOptionPane.showMessageDialog(null, "Usuário não encontrado.");
        return null;
    }

    private void usuarioCarregar(Bilhete bilhete) {
        double carga = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor que deseja carregar."));
//        System.out.println("Digite o valor que deseja carregar: ");
//        double carga = Double.parseDouble(sc.nextLine());

        while (carga < 0) {
            carga = Double.parseDouble(JOptionPane.showInputDialog("Valor inválido!\nDigite o valor que deseja carregar."));
//            System.out.println("Valor inválido!");
//            System.out.println("Digite o valor que deseja carregar: ");
//            carga = Double.parseDouble(sc.nextLine());
        }

        bilhete.carregar(carga);
        if (carga > 0) {
            JOptionPane.showMessageDialog(null, "Carga realizada com sucesso!");
            System.out.println("Carga realizada com sucesso!");
        }
    }

    private String listarUsuarios() {
        String output = "";
        for (int i = 0; i < this.bilhetes.size(); i++) {
            output += (i + 1) + " - " + this.bilhetes.get(i) + "\n--------------------------------------------------------------------\n";
        }
        return output;
    }

    private void emitirBilhete() {
        while (true) {
            String nome = JOptionPane.showInputDialog("Insira o nome do usuário (deixe em branco para sair).");
//            System.out.println("Insira o nome do usuário (deixe em branco para sair):");
//            String nome = sc.nextLine();
            if (nome.isBlank()) {
                break;
            }

            String cpf = JOptionPane.showInputDialog("Digite o CPF.");
//            System.out.println("Digite o CPF:");
//            String cpf = sc.nextLine();

            String perfil = JOptionPane.showInputDialog("Digite o perfil do usuário (comum, estudante, professor).");
//            System.out.println("Digite o perfil do usuário (comum, estudante):");
//            String perfil = sc.nextLine();

            Bilhete novo = new Bilhete(nome, cpf, perfil);
            this.bilhetes.add(novo);
        }
    }

}
