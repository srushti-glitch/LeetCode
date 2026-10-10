
import java.util.*;

class LockingTree {
    int[] parent;
    int[] lockedBy;
    ArrayList<Integer>[] children;

    public LockingTree(int[] parent) {
        this.parent = parent;
        int n = parent.length;

        lockedBy = new int[n];
        children = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            children[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            children[parent[i]].add(i);
        }
    }

    public boolean lock(int num, int user) {
        if (lockedBy[num] != 0) {
            return false;
        }

        lockedBy[num] = user;
        return true;
    }

    public boolean unlock(int num, int user) {
        if (lockedBy[num] != user) {
            return false;
        }

        lockedBy[num] = 0;
        return true;
    }

    public boolean upgrade(int num, int user) {
        if (lockedBy[num] != 0) {
            return false;
        }

        int p = parent[num];

        while (p != -1) {
            if (lockedBy[p] != 0) {
                return false;
            }
            p = parent[p];
        }

        ArrayList<Integer> lockedNodes = new ArrayList<>();
        findLocked(num, lockedNodes);

        if (lockedNodes.isEmpty()) {
            return false;
        }

        for (int node : lockedNodes) {
            lockedBy[node] = 0;
        }

        lockedBy[num] = user;
        return true;
    }

    private void findLocked(int num, ArrayList<Integer> lockedNodes) {
        for (int child : children[num]) {
            if (lockedBy[child] != 0) {
                lockedNodes.add(child);
            }

            findLocked(child, lockedNodes);
        }
    }
}
