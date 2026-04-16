package structureDataBPlus;

public class BPlusTree {
    private final int ORDER;
    private InternalNode root;
    private LeafNode firstLeaf; // início da lista ligada

    /** Nó interno — apenas chaves de roteamento */
    static class InternalNode {
        int[] keys;
        Object[] children; // InternalNode ou LeafNode
        int keyCount;
    }

    /** Nó folha — chave + valor + ponteiro para próxima folha */
    static class LeafNode {
        int[] keys;
        Object[] values;  // dados reais (registros)
        int keyCount;
        LeafNode next;    // encadeamento da lista ligada!
        LeafNode prev;    // encadeamento duplo
    }

    // ── IMPLEMENTAR ──────────────────────────────────────
    /**
     * Remove a chave da B+.
     * Atenção: a chave pode aparecer nos nós internos como
     * separador mesmo após ser removida das folhas.
     * Trate: remoção simples, redistribuição e merge de folhas.
     * OBRIGATÓRIO: manter a lista ligada correta após merge.
     */
    public void delete(int key) {
        // TODO
    }

    private void mergeLeaves(LeafNode left, LeafNode right,
                             InternalNode parent, int sepIdx) {
        // TODO: funde duas folhas e atualiza a lista ligada:
        //   left.next = right.next
        //   if (right.next != null) right.next.prev = left
    }

    /**
     * Percorre a lista ligada das folhas retornando todos
     * os valores no intervalo [from, to] — demonstra que
     * o encadeamento está correto após remoções.
     */
    public List<Integer> rangeQuery(int from, int to) {
        // TODO: navega pela lista ligada coletando valores
        return null;
    }
}
