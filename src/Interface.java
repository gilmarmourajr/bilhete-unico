import java.util.ArrayList;
import java.util.Scanner;

public class Interface {
    private Scanner sc;
    private ArrayList<Bilhete> bilhetes;
    private String senhaAdm;

    public Interface () {
        sc = new Scanner(System.in);
        bilhetes = new ArrayList<>();
        senhaAdm = "1234";
    }

    public void start() {
        int input = 0;
        while(input != 3) {
            System.out.println("Selecione o tipo de usuário:");
            System.out.println("1 - Comum");
            System.out.println("2 - Administrador");
            System.out.println("3 - Encerrar programa");
            input = Integer.parseInt(sc.nextLine());

            while(input < 1 || input > 3) {
                System.out.println("Digite uma opção válida (de 1 a 3).");
                input = Integer.parseInt(sc.nextLine());
            }

            if(input == 1) {
                if(bilhetes.isEmpty()) {
                    System.out.println("Nenhum bilhete cadastrado.\n");
                } else {
                    this.menuComum();
                }
            }

            if(input == 2) {
                System.out.println("Digite a senha do administrador:");
                String senha = sc.nextLine();
                if(senha.equals(senhaAdm)) {
                    this.menuAdm();
                } else {
                    System.out.println("Senha incorreta.\n");
                }
            }
        }
    }

    private void menuComum() {
        Bilhete bilhete = selecaoUsuario();
        System.out.println("Olá, " + bilhete.getUsuario().getNome());
        int input = 0;
        while(input != 4) {
            System.out.println("Selecione a opção desejada:");
            System.out.println("1 - Consultar saldo do bilhete");
            System.out.println("2 - Carregar bilhete");
            System.out.println("3 - Passar na catraca");
            System.out.println("4 - Sair");
            input = Integer.parseInt(sc.nextLine());

            while(input<1 || input>4) {
                System.out.println("Digite uma opção válida (de 1 a 4).");
                input = Integer.parseInt(sc.nextLine());
            }

            if(input == 1) {
                System.out.println(bilhete.consultar());
            }

            if(input == 2) {
                usuarioCarregar(bilhete);
            }

            if(input == 3) {
                System.out.println(bilhete.passarCatraca());
            }
        }
    }

    private void menuAdm() {
        System.out.println("Olá, ADM");
        int input = 0;
        while(input != 4) {
            System.out.println("Selecione a opção desejada:");
            System.out.println("1 - Emitir novo bilhete");
            System.out.println("2 - Listar os bilhetes cadastrados");
            System.out.println("3 - Remover bilhete");
            System.out.println("4 - Sair");
            input = Integer.parseInt(sc.nextLine());

            while(input<1 || input>4) {
                System.out.println("Digite uma opção válida (de 1 a 4).");
                input = Integer.parseInt(sc.nextLine());
            }

            if(input == 1) {
                emitirBilhete();
            }

            if(input == 2) {
                if(this.bilhetes.isEmpty()) {
                    System.out.println();
                } else {
                    listarUsuarios();
                }
            }

            if(input == 3) {
                if(bilhetes.isEmpty()) {
                    System.out.println("Nenhum bilhete cadastrado.\n");
                } else {
                    bilhetes.remove(selecaoUsuario());
                }
            }
        }
    }

    private Bilhete selecaoUsuario() {
        System.out.println("Selecione o usuário: ");

        listarUsuarios();

        int input = (Integer.parseInt(sc.nextLine()) - 1);

        while(input>=this.bilhetes.size() || input<0) {
            System.out.println("Insira uma opção válida (de 1 a " + this.bilhetes.size() + ").");
            input = (Integer.parseInt(sc.nextLine()) - 1);
        }

        return this.bilhetes.get(input);
    }

    private void usuarioCarregar(Bilhete bilhete) {
        System.out.println("Digite o valor que deseja carregar: ");
        double carga = Double.parseDouble(sc.nextLine());

        while(carga < 0) {
            System.out.println("Valor inválido!");
            System.out.println("Digite o valor que deseja carregar: ");
            carga = Double.parseDouble(sc.nextLine());
        }

        bilhete.carregar(carga);
        if(carga > 0) {
            System.out.println("Carga realizada com sucesso!");
        }
    }

    private void listarUsuarios() {
        for(int i=0; i<this.bilhetes.size(); i++) {
            System.out.println((i+1) + " - " + this.bilhetes.get(i).getUsuario());
        }
    }

    private void emitirBilhete() {
        while(true) {
            System.out.println("Insira o nome do usuário (deixe em branco para sair):");
            String nome = sc.nextLine();
            if(nome.isBlank()) {
                break;
            }

            System.out.println("Digite o CPF:");
            String cpf = sc.nextLine();

            System.out.println("Digite o perfil do usuário (comum, estudante):");
            String perfil = sc.nextLine();

            Bilhete novo = new Bilhete(nome, cpf, perfil);
            this.bilhetes.add(novo);
        }
    }

}
