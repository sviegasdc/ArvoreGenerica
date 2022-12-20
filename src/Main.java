public class Main {
    public static void main(String[] args) throws InvalidNoException {
        Arvore arvore = new  Arvore("raiz");
        No n = arvore.addFilho(arvore.raiz, "adotado");
        No a = arvore.addFilho(arvore.raiz, "junin");
        No p = arvore.addFilho(arvore.raiz, "ovo");
        arvore.mostraArvore();
        arvore.remove(n);
        arvore.mostraArvore();
        System.out.println(arvore.altura());

    }
}