package structureDataBTree;

public class BTree {
    private final int ORDER;   // ordem m
    private final int MIN_KEYS; // ⌈m/2⌉ - 1
    private BTreeNode root;

    static class BTreeNode {
        int[] keys;
        BTreeNode[] children;
        int keyCount;
        boolean isLeaf;

        BTreeNode(int order, boolean isLeaf) {
            keys     = new int[order - 1];
            children = new BTreeNode[order];
            keyCount = 0;
            this.isLeaf = isLeaf;
        }
    }

    public BTree(int order) {
        this.ORDER    = order;
        this.MIN_KEYS = (int) Math.ceil(order / 2.0) - 1;
        root = new BTreeNode(order, true);
    }

    // ── IMPLEMENTAR ──────────────────────────────────────
    /**
     * Remove key da árvore B.
     * Trate: remoção em folha, remoção em nó interno,
     * redistribuição com irmão e fusão (merge).
     */
    public void delete(int key) {
        // TODO
    }

    private void deleteFromNode(BTreeNode node, int key) {
        // TODO: lógica recursiva de remoção
    }

    private void fill(BTreeNode node, int idx) {
        // TODO: resolve underflow no filho node.children[idx]
        // Decide entre redistribuição ou merge
    }

    private void borrowFromPrev(BTreeNode node, int idx) {
        // TODO: redistribuição com irmão esquerdo
    }

    private void borrowFromNext(BTreeNode node, int idx) {
        // TODO: redistribuição com irmão direito
    }

    private void merge(BTreeNode node, int idx) {
        // TODO: funde children[idx] com children[idx+1]
    }
}
