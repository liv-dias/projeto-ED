public class Torre{
    // atributos
    private final Pilha<Disco> tam_disco;

    // construtor
    public Torre(int qtd){
        this.tam_disco = new Pilha<>(qtd);
    }
   
    public Pilha<Disco> getTam_disco() {
        return this.tam_disco;
    }

    public Pilha<Disco> getTam_disco(Pilha<Disco> tam_disco) {
        return this.tam_disco;
    }

    public void inicializarDiscos(int qtd) throws Exception{
        if (qtd <= 1){
            throw new TooSmallException("A quantidade de discos deve ser maior que um(1).");
        }
        for(int i = 1; i <= qtd; i++){
            String original = "*";
            String repete = original.repeat(i);
            System.out.println(repete);
            Disco disco_atual = new Disco(i);
            tam_disco.push(disco_atual);
        }
    }

    public Disco pop() throws Exception{
        if (tam_disco.isEmpty()){
            throw new Exception("A torre está vazia, não é possível retirar um disco.");
        }
        return tam_disco.pop();
    }

    public Disco push(Disco disco) throws Exception{
        if (!tam_disco.isEmpty() && disco.getTamanho() > tam_disco.topo().getTamanho()){
            throw new InvalidMovementException("Movimento inválido! Você não pode colocar um disco maior em cima de um menor.");
        }
        tam_disco.push(disco);
        return disco;
    }

    public Disco getTopo() throws IsEmptyException{
        if (tam_disco.isEmpty()){
            throw new IsEmptyException("A torre está vazia, não é possível obter o topo.");
        }
        return this.tam_disco.topo();
    }
}



