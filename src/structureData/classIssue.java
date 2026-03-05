package structureData;

import java.util.Arrays;

public class classIssue {
    public void orderArray(int[] vetor){
        Arrays.sort(vetor);

        System.out.println("\nVetor ordenado:");
        for (int n : vetor) {
            System.out.print(n + " ");
        }
    }

    public binaryTree createBinaryTree(int[] vetor){
        binaryTree arvore = new binaryTree();

        for (int n : vetor) {
            arvore.inserir(n);
        }

        return arvore;
    }

    public binaryTree createBalancedBinaryTree(int[] vetor){
        binaryTree arvore = new binaryTree();

        arvore.raiz = arvore.construirBalanceada(vetor, 0, vetor.length - 1);

        return arvore;
    }
}
