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
            if(escolha== 4){
                System.out.println("Obrigada por jogar!!");
                System.exit(0);
            }
            for (int i = 1; i <= qtd; i++){
                    String original = "*";
                    String repete = original.repeat(i);
                    Disco tam_disco = new Disco(i);
                    t1.push(tam_disco);
            }
            switch(escolha){
                case 1:
                    System.out.println("Digite a torre de origem: ");
                    int origem = entrada.nextInt();
                    System.out.println("Digite a torre de destino: ");
                    int destino = entrada.nextInt();
                    if (t1.tam_disco.getTamanho() > t2.discos[t2.topo].getTamanho() || t1.tam_disco.getTamanho() > t3.discos[t3.topo].getTamanho()){
                        throw new InvalidMovementException("Movimento inválido! Você não pode colocar um disco maior em cima de um menor.");
                    }
                    if (origem == 1 && destino == 2){
                        t2.push(t1.pop());
                    }else if (origem == 1 && destino == 3){
                        t3.push(t1.pop());
                    }else if (origem == 2 && destino == 1){
                        t1.push(t2.pop());
                    }else if (origem == 2 && destino == 3){
                        t3.push(t2.pop());
                    }else if (origem == 3 && destino == 1){
                        t1.push(t3.pop());
                    }else if (origem == 3 && destino == 2){ 
                        t2.push(t3.pop());
                    }else{
                        throw new InvalidMovementException("Movimento inválido! As torres são numeradas de 1 a 3.");
                    }
            }
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
        }catch (TooSmallException | IsFullException | IsEmptyException | InvalidMovementException e){
            System.out.println("ERRO: " +e.getMessage());

        }
    }
}