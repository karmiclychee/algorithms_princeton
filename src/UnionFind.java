import java.util.Arrays;

public class UnionFind {
    public int[] components;

    public UnionFind(int numberOfComponents) {
        if (numberOfComponents < 0) throw new IllegalArgumentException();
        components = new int[numberOfComponents];
        for (int i = 0; i < numberOfComponents; i++) components[i] = i;
    }

    public void union(int firstComponent, int secondComponent) {
        components[secondComponent] = components[firstComponent];
    }

    public int findRoot(int component) {
        if (components[component] != component) {
            return findRoot(components[component]);
        } else {
            return component;
        }
    }

    public boolean connected(int firstComponent, int secondComponent) {
        return findRoot(firstComponent) == findRoot(secondComponent);
    }

    public int count() {
        return components.length;
    }

    public static void main(String[] args) {
// TODO: implement this.
        UnionFind uf = new UnionFind(12);
        uf.union(1,2);
        uf.union(1,3);
        uf.union(1,6);
        uf.union(2,6);
        System.out.println(uf.connected(1,2));
        System.out.println(uf.connected(1,3));
        System.out.println(uf.findRoot(1));
        System.out.println(Arrays.toString(uf.components));
    }
}
