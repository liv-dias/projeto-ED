public class Torre <T> {
    // atributos
    private Object[] elementos;
    private int topo;
    private int tamanho;
    // construtores
    public Torre(int tamanho){
        this.tamanho = tamanho;
        this.elementos = new Object[tamanho];
        this.topo = -1;
    }
    public boolean isEmpty(){
        return this.topo == -1;
    }