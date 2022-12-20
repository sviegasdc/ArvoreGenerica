import java.util.Iterator;

public class Arvore {
    No raiz;
    int tamanho;

    public Arvore(Object elemento){
        raiz = new No(null, elemento);
        tamanho = 1;
    }

    public No getRaiz(){
        // retornar raiz da arvore
        return raiz;
    }

    public No getPai(No node){
        // retornar o pai de um nó
        return (node.paiDeUmNo());
    }

    public Iterator<Object> getFilhos(No node){
        return node.filhosDeUmNo();
    }

    public boolean ehInterno(No node){
        return (node.numeroFilhos() == 0);
    }

    public boolean ehExterno(No node){
        return (node.numeroFilhos() == 0);
    }

    public boolean ehRaiz(No node){
        return node == raiz;
    }

    public No addFilho(No node, Object elemento){
        No novoNo = new No(node, elemento);
        node.addFilho(novoNo);
        tamanho++;
        return novoNo;
    }

    public Object remove(No node) throws InvalidNoException{
        No pai = node.paiDeUmNo();
        if (pai != null || ehExterno(node)){
            pai.removeFilho(node);
        }
        else{
            throw new InvalidNoException("Esse nó não pode ser removido");
        }
        Object elemento = node.getElemento();
        tamanho --;
        return elemento;
    }

    public int profundidade(No node){
        if (node == raiz) {
            return 0;
        }
        else{
            return 1 + profundidade(node.paiDeUmNo());
        }
    }

    public int altura(){
        if (raiz == null) {
            return 0;
        }
        int altura = 0;
        for (Iterator<Object> it = getFilhos(raiz); it.hasNext(); ) {
            Object filho = it.next();
            No noFilho = (No) filho;
            altura = Math.max(altura, profundidade(noFilho));
        }
        return altura;
    }


    public void Nos(){

    }

    public int size(){
        return tamanho;
    }

    public boolean isEmpty(){
        return tamanho == 0;
    }

    public void trocaElementosDosNos(No node, No segundoNo){
        Object elementoNode= node.getElemento();
        Object elementoSegundoNo = segundoNo.getElemento();
        node.setElemento(elementoSegundoNo);
        segundoNo.setElemento(elementoNode);
    }

    public Object trocarElemento(No node, Object elemento){
        Object antigoElemento = node.getElemento();
        node.setElemento(elemento);
        return antigoElemento;
    }

    public void mostraArvore(){
        mostraArvoreRecursivo(raiz, 0);
    }
    private void mostraArvoreRecursivo(No node, int profundidade){
        for (int i = 0; i < profundidade; i++) {
            System.out.print("  ↳ ");
        }
        System.out.println(node.getElemento());
        // 'loop' para percorrer os filhos
        for (Iterator<Object> it = getFilhos(node); it.hasNext(); ) {
            // cria o iterador 'it' para percorrer os filhos
            // 'it.hasNext' == i++ (retorna o próximo elemento na coleção e faz o iterador apontar para o próx. elemento)
            Object filho = it.next();
            // cria uma variável objeto para armazenar os filhos
            No noFilho = (No) filho;
            // converte essa variável para nó, pois o "mostraArvore" recebe um nó como argumento
            mostraArvoreRecursivo(noFilho, profundidade + 1);
        }
    }
}
