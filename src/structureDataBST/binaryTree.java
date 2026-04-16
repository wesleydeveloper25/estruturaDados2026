package structureDataBST;

public class binaryTree {
    public node raiz;

    public void inserir(int valor) {
        raiz = setNewValue(raiz, valor);
    }

    private node setNewValue(node atual, int valor) {
        if (atual == null) {
            return new node(valor);
        }

        if (valor < atual.valor) {
            atual.esquerda = setNewValue(atual.esquerda, valor);
        } else if (valor > atual.valor) {
            atual.direita = setNewValue(atual.direita, valor);
        }

        return atual;
    }

    public void emOrdem(node no) {
        if (no != null) {
            emOrdem(no.esquerda);
            System.out.print(no.valor + " ");
            emOrdem(no.direita);
        }
    }

    public int altura(node no) {

        // Caso base: árvore vazia
        if (no == null) {
            return -1;
        }

        // Calcula altura da subárvore esquerda
        int alturaEsquerda = altura(no.esquerda);

        // Calcula altura da subárvore direita
        int alturaDireita = altura(no.direita);

        // Retorna a maior + 1
        return 1 + Math.max(alturaEsquerda, alturaDireita);
    }
}
