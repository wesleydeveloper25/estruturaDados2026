package structureDataBlackRed;

public class RedBlackTree {
    static final boolean RED   = true;
    static final boolean BLACK = false;

    static class Node {
        int key;
        boolean color;
        Node left, right, parent;

        Node(int key) {
            this.key   = key;
            this.color = RED; // todo nó novo nasce vermelho
        }
    }

    private Node root;
    private final Node NIL; // sentinela folha — sempre BLACK

    public RedBlackTree() {
        NIL        = new Node(0);
        NIL.color  = BLACK;
        NIL.left   = NIL.right = NIL.parent = NIL;
        root       = NIL;
    }

    // ── IMPLEMENTAR ──────────────────────────────────────
    /**
     * Remove a chave da árvore, mantendo as 5 propriedades
     * rubro-negras. Trate todos os casos de fixup.
     * Complexidade esperada: O(log n)
     */
    public void delete(int key) {
        // TODO: implementar
    }

    private void deleteFixup(Node x) {
        // TODO: implementar os 4 casos de rebalanceamento
        // Caso 1: irmão é vermelho
        // Caso 2: irmão é preto, ambos sobrinhos pretos
        // Caso 3: irmão preto, sobrinho próximo vermelho
        // Caso 4: irmão preto, sobrinho distante vermelho
    }

    private void transplant(Node u, Node v) {
        // TODO: substitui subárvore enraizada em u por v
    }
    // ─────────────────────────────────────────────────────

    // Métodos já fornecidos: insert(), rotateLeft(),
    // rotateRight(), search(), inorder(), printTree()
}
}
