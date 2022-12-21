public class Main {
    public static void main(String[] args) throws InvalidNoException {
        Arvore arvore = new  Arvore("Mr catra");
        No n = arvore.addFilho(arvore.raiz, "adotado");
        No a = arvore.addFilho(arvore.raiz, "junin");
        No p = arvore.addFilho(arvore.raiz, "ovo");
        No r = arvore.addFilho(n, "filho de n");
//        arvore.mostraArvore();
        System.out.println(arvore.size());
        arvore.elements();
        System.out.println(arvore.Nos());
        System.out.println("altura da árvore: " + arvore.altura());
        System.out.println("profundidade do no escolhido: " + arvore.profundidade(r));

    }
}