import java.util.Arrays;

public class QuickFindUF {
    public int[] components;

    public QuickFindUF(int numberOfComponents) {
        if (numberOfComponents < 0) throw new IllegalArgumentException();
        components = new int[numberOfComponents];
        for (int i = 0; i < numberOfComponents; i++) components[i] = i;
    }

    public void union(int firstSite, int secondSite) {
        //sets site and all connected to the root of the second site
        //iterates through all sites per union operation
        if (connected (firstSite, secondSite)) return;
        for (int i = 0; i < components.length; i++) {
            if (components[i] == components[firstSite]) {
                components[i] = components[secondSite];
            }
        }
    }

    public int find(int siteId) {
        return components[siteId];
    }

    public boolean connected(int firstSite, int secondSite) {
        return components[firstSite] == components[secondSite];
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
