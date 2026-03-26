import java.util.Scanner;
public class JogoHanoi {
    public static void main(String[] args){
        System.out.println("----Torre de Hanoi----");
        int escolha;
        Scanner entrada_escolha = new Scanner(System.in);
        System.out.println("Menu:\n 1-Mover Disco\n 2-Mostrar Torres\n 3-Reiniciar Jogo\n 4- Sair");
        escolha = entrada_escolha.nextInt();
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite a quantidade de discos que terão na torre: ");
        int qtd = entrada.nextInt();
        Disco tamanho = new Disco(qtd);
        try{
            Torre t1 = new Torre(qtd);
            Torre t2 = new Torre(qtd);
            Torre t3 = new Torre(qtd);
            if (escolha == 4){
                System.out.println("Obrigado por jogar!");
                System.exit(0);
            }
            if(escolha == 2){
                for (int i = 1; i <= qtd; i++){
                    String original = "*";
                    String repete = original.repeat(i);
                    Disco disco_atual = new Disco(i);
                    t1.push(disco_atual);
                    System.out.println(repete);
            }
                System.out.print("TORRE 1");
                System.out.print(" TORRE 2");
                System.out.print(" TORRE 3\n");
            }else if(escolha == 1){
            }else if(escolha == 3){
                System.out.println("Reiniciando jogo...");
                main(args);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("Tente novamente.\n");
            System.out.println("Menu:\n 1-Mover Disco\n 2-Mostrar Torres\n 3-Reiniciar Jogo\n 4- Sair");
            escolha = entrada_escolha.nextInt();
        }
    }
}