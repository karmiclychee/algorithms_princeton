import java.util.Arrays;

public class QuickFindUF {
    public int[] components;

    public QuickFindUF(int numberOfComponents) {
        if (numberOfComponents < 0) throw new IllegalArgumentException();
        components = new int[numberOfComponents];
        for (int i = 0; i < numberOfComponents; i++) components[i] = i;
    }

    public void union(int firstComponent, int secondComponent) {
        if (connected (firstComponent, secondComponent)) return;
        for (int i = 0; i < components.length; i++) {
            if (components[i] == components[firstComponent]) {
                components[i] = components[secondComponent];
            }
        }
    }

    public int find(int componentId) {
        return components[componentId];
    }

    public boolean connected(int firstComponent, int secondComponent) {
        return components[firstComponent] == components[secondComponent];
    }

    public static void main(String[] args) {
        // TODO: implement this.
        QuickFindUF uf = new QuickFindUF(12);
        uf.union(1, 2);
        uf.union(2, 6);
        uf.union(6, 9);
        uf.union(9, 11);
        System.out.println(uf.find(1));
        System.out.println(Arrays.toString(uf.components));
    }
}
