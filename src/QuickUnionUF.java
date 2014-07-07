import java.util.Arrays;

public class QuickUnionUF {
    public int[] components;

    public QuickUnionUF(int sites) {
        if (sites < 0) throw new IllegalArgumentException();
        components = new int[sites];
        for (int i = 0; i < sites; i++) components[i] = i;
    }

    public void union(int firstSite, int secondSite) {
        int firstSiteRoot = find(firstSite);
        int secondSiteRoot = find(secondSite);

        if (firstSiteRoot == secondSiteRoot) return;
        components[firstSiteRoot] = secondSiteRoot;
        //set the root of the first site to the second site
        //chains roots up the tree to the RootRoot
        //turtles all the way down
    }

    public int find(int siteId) {
        //recursively follows component roots to the top level
        if (siteId != components[siteId]) return find(components[siteId]);
        return siteId;
    }

    public boolean connected(int firstSite, int secondSite) {
        return components[firstSite] == components[secondSite];
    }

    public static void main(String[] args) {
        // TODO: implement this.
        QuickUnionUF uf = new QuickUnionUF(12);
        uf.union(1, 2);
        uf.union(2, 6);
        uf.union(6, 9);
        uf.union(9, 11);
        System.out.println(uf.find(1));
        System.out.println(Arrays.toString(uf.components));
    }
}
