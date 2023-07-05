public class ManagerPoster {
    private PosterInfo[] posters = new PosterInfo[0];
    private int limit;

    public void save(PosterInfo poster) {
        PosterInfo[] tmp = new PosterInfo[posters.length + 1];
        for (int i = 0; i < posters.length; i++) {
            tmp[i] = posters[i];
        }
        tmp[tmp.length - 1] = poster;
        posters = tmp;
    }

    public PosterInfo[] getPosters() {

        return posters;
    }

    public ManagerPoster() {
        this.limit = 5;
    }

    public ManagerPoster(int newLimit) {
        this.limit = newLimit;
    }

    public int getLimit() {
        return limit;
    }

    public PosterInfo[] findLast() {
        int resultLength;
        if (limit < posters.length) {
            resultLength = this.limit;
        } else {
            resultLength = posters.length;
        }
        PosterInfo[] last = getPosters();
        PosterInfo[] reversed = new PosterInfo[resultLength];
        for (int i = 0; i < reversed.length; i++) {
            reversed[i] = last[last.length - 1 - i];
        }
        return reversed;
    }

    public PosterInfo[] findAll() {
        int resultLength;
        if (limit < posters.length) {
            resultLength = this.limit;
        } else {
            resultLength = posters.length;
        }
        PosterInfo[] all = new PosterInfo[resultLength];
        for (int i = 0; i < all.length; i++) {
            all[i] = posters[i];
        }
        return all;
    }
}

