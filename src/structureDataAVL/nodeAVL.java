package structureDataAVL;

public class nodeAVL {
        int key;
        int height;

        nodeAVL left;
        nodeAVL right;

        nodeAVL(int key) {
            this.key = key;
            height = 1;
        }
}
