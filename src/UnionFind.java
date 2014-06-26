import java.util.Arrays;

public class UnionFind {
    public int[] components;

    public UnionFind(int numberOfComponents) {
        if (numberOfComponents < 0) throw new IllegalArgumentException();
        components = new int[numberOfComponents];
        for (int i = 0; i < numberOfComponents; i++) components[i] = i;
    }

    public void union(int firstComponent, int secondComponent) {
        components[firstComponent] = components[secondComponent];
    }

    public int find(int component) {
        // finds the root of the component group
        if (components[component] != component) {
            return find(components[component]);
        } else {
            return component;
        }
    }

    public boolean connected(int firstComponent, int secondComponent) {
        return find(firstComponent) == find(secondComponent);
    }

    public static void main(String[] args) {
// TODO: implement this.
        UnionFind uf = new UnionFind(12);
        uf.union(1,2);
        uf.union(2,6);
        uf.union(6,9);
        uf.union(9,11);
        System.out.println(uf.find(1));
        System.out.println(Arrays.toString(uf.components));
    }
}
