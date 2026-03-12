package structureDataAVL;

public class avlTree {
    nodeAVL inserir(nodeAVL node, int key) {
        // Caso base da recursão:
        // Se chegamos em uma posição vazia da árvore,
        // criamos um novo nó com o valor a ser inserido.
        if (node == null)
            return new nodeAVL(key);

        // Verifica se o valor a ser inserido é menor que o valor do nó atual.
        // Se for, continuamos a busca na subárvore esquerda.
        if (key < node.key)
            node.left = inserir(node.left, key);
        else if (key > node.key) {
            // Se o valor for maior que o nó atual,
            // continuamos a busca na subárvore direita.
            node.right = inserir(node.right, key);
        }
        else{
            // Caso o valor já exista na árvore,
            // não permitimos duplicidade e simplesmente retornamos o nó.
            return node;
        }

        // Após inserir o novo elemento, precisamos atualizar a altura do nó atual.
        // A altura é definida como:
        // 1 + a maior altura entre as subárvores esquerda e direita.
        node.height = 1 + Math.max(altura(node.left), altura(node.right));

        // Calcula o fator de balanceamento do nó atual.
        // Esse valor indica se a árvore ficou desbalanceada após a inserção.
        int balance = getBalance(node);

        // Caso 1: Left Left (LL)
        // A árvore ficou desbalanceada para a esquerda
        // e o valor foi inserido na subárvore esquerda do filho esquerdo.
        // Correção: rotação simples à direita.
        if (balance > 1 && key < node.left.key)
            return rotacaoDireita(node);

        // Caso 2: Right Right (RR)
        // A árvore ficou desbalanceada para a direita
        // e o valor foi inserido na subárvore direita do filho direito.
        // Correção: rotação simples à esquerda.
        if (balance < -1 && key > node.right.key)
            return rotacaoEsquerda(node);

        // Caso 3: Left Right (LR)
        // A árvore está desbalanceada à esquerda
        // mas o valor foi inserido na direita do filho esquerdo.
        // Correção: rotação dupla (esquerda + direita).
        if (balance > 1 && key > node.left.key) {
            node.left = rotacaoEsquerda(node.left);
            return rotacaoDireita(node);
        }

        // Caso 4: Right Left (RL)
        // A árvore está desbalanceada à direita
        // mas o valor foi inserido na esquerda do filho direito.
        // Correção: rotação dupla (direita + esquerda).
        if (balance < -1 && key < node.right.key) {
            node.right = rotacaoDireita(node.right);
            return rotacaoEsquerda(node);
        }

        // Se nenhuma rotação foi necessária,
        // apenas retornamos o nó atual.
        return node;
    }

    nodeAVL rotacaoEsquerda(nodeAVL x) {

        nodeAVL y = x.right;
        nodeAVL T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = Math.max(altura(x.left), altura(x.right)) + 1;
        y.height = Math.max(altura(y.left), altura(y.right)) + 1;

        return y;
    }

    nodeAVL rotacaoDireita(nodeAVL y) {

        nodeAVL x = y.left;
        nodeAVL T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = Math.max(altura(y.left), altura(y.right)) + 1;
        x.height = Math.max(altura(x.left), altura(x.right)) + 1;

        return x;
    }

    nodeAVL rotacaoRL(nodeAVL node) {
        node.right = rotacaoDireita(node.right);
        return rotacaoEsquerda(node);
    }

    nodeAVL rotacaoLR(nodeAVL node) {
        node.left = rotacaoEsquerda(node.left);
        return rotacaoDireita(node);
    }

    int altura(nodeAVL node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    int getBalance(nodeAVL node) {

        if (node == null) {
            return 0;
        }

        return altura(node.left) - altura(node.right);
    }

    nodeAVL remover(nodeAVL root, int key) {

        // Caso base da recursão:
        // Se chegamos a um nó nulo significa que o valor não existe na árvore.
        if (root == null)
            return root;

        // Se o valor que queremos remover é menor que o valor do nó atual,
        // continuamos a busca na subárvore esquerda.
        if (key < root.key)
            root.left = remover(root.left, key);

            // Se o valor é maior que o valor do nó atual,
            // continuamos a busca na subárvore direita.
        else if (key > root.key)
            root.right = remover(root.right, key);

            // Caso encontramos o nó que deve ser removido.
        else {

            // Verifica se o nó possui apenas um filho ou nenhum filho.
            if ((root.left == null) || (root.right == null)) {

                // Variável auxiliar para armazenar o possível filho existente.
                nodeAVL temp = null;

                // Se o filho da esquerda é nulo,
                // então o filho existente (se houver) está à direita.
                if (temp == root.left)
                    temp = root.right;

                    // Caso contrário, o filho existente está à esquerda.
                else
                    temp = root.left;

                // Caso o nó seja folha (não possui filhos)
                // simplesmente removemos o nó.
                if (temp == null) {
                    root = null;
                }

                // Caso exista um filho,
                // substituímos o nó atual por seu filho.
                else
                    root = temp;
            }

            // Observação: o caso de nó com dois filhos normalmente
            // envolve substituir pelo sucessor em ordem (menor da direita).
            // Esse trecho não aparece neste código específico.
        }

        // Se após a remoção a árvore ficou vazia,
        // retornamos imediatamente.
        if (root == null)
            return root;

        // Atualizamos a altura do nó atual.
        // A altura é definida como:
        // 1 + a maior altura entre as subárvores esquerda e direita.
        root.height = Math.max(altura(root.left), altura(root.right)) + 1;

        // Após atualizar a altura, precisamos verificar se a árvore
        // ficou desbalanceada. O método getValidateBalance()
        // calcula o fator de balanceamento e aplica as rotações
        // necessárias (LL, RR, LR ou RL).
        root = getValidateBalance(root);

        // Retorna o nó atualizado após possível balanceamento.
        return root;
    }

    nodeAVL getValidateBalance(nodeAVL node) {
        int balance = getBalance(node);

        // Caso LL
        if (balance > 1 && getBalance(node.left) >= 0)
            return rotacaoDireita(node);

        // Caso LR
        if (balance > 1 && getBalance(node.left) < 0) {
            node.left = rotacaoEsquerda(node.left);
            return rotacaoDireita(node);
        }

        // Caso RR
        if (balance < -1 && getBalance(node.right) <= 0)
            return rotacaoEsquerda(node);

        // Caso RL
        if (balance < -1 && getBalance(node.right) > 0) {
            node.right = rotacaoDireita(node.right);
            return rotacaoEsquerda(node);
        }

        return node;
    }
}
