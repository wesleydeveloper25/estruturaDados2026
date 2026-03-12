//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import structureDataBST.binaryTree;

public class Main {
    public static void main(String[] args) {
        int[] vetor = {8, 3, 10, 1, 6, 14};
        binaryTree arvore = new binaryTree();
        classIssue aula = new classIssue();

        //ORDENAR VETOR
        aula.orderArray(vetor);
        System.out.println("\n--------------------------------------------");

        //CRIAR ARVORE
        //arvore = aula.createBinaryTree(vetor);

        //CRIAR ARVORE BALANCEADA
        arvore = aula.createBalancedBinaryTree(vetor);

        System.out.println("Percurso em ordem:");
        arvore.emOrdem(arvore.raiz);
        System.out.println("\n--------------------------------------------");
    }
}