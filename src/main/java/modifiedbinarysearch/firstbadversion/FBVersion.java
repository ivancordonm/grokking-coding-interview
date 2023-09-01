package modifiedbinarysearch.firstbadversion;

public class FBVersion {
    Api versionApi = new Api();

    public boolean isBadVersion(int v) {
        return versionApi.isBad(v);
    }

    public void setBadVersion(int v) {
        versionApi.bad = v;
    }

    public int[] firstBadVersion(int n) {
        // -- DO NOT CHANGE THIS SECTION
        versionApi.n = n;
        // --
        var start = 1;
        var end = n;
        var steps = 0;
        while (start < end) {
            steps++;
            var mid = start + (end - start) / 2;
            if (isBadVersion(mid)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return new int[]{end, steps};
    }

    private static class Api {
        int n;
        int bad;

        boolean isBad(int v) {
            return v >= bad;
        }
    }
}
