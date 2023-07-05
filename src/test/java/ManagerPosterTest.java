import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ManagerPosterTest {

    PosterInfo film1 = new PosterInfo("Бладшот");
    PosterInfo film2 = new PosterInfo("Вперёд");
    PosterInfo film3 = new PosterInfo("Отель <Белград>");
    PosterInfo film4 = new PosterInfo("Джентельмены");
    PosterInfo film5 = new PosterInfo("Человек - невидимка");
    PosterInfo film6 = new PosterInfo("Тролли. Мировой тур");
    PosterInfo film7 = new PosterInfo("Номер один");

    @Test
    public void addFilms() {
        ManagerPoster add = new ManagerPoster();
        add.save(film1);
        add.save(film2);
        add.save(film3);
        add.save(film4);
        add.save(film5);
        add.save(film6);
        add.save(film7);
        PosterInfo[] expected = {film1, film2, film3, film4, film5, film6, film7};
        PosterInfo[] actual = add.getPosters();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void newLimit() {
        ManagerPoster newLimit = new ManagerPoster(7);
        int expected = 7;
        int actual = newLimit.getLimit();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void usualLimit() {
        ManagerPoster usualLimit = new ManagerPoster();
        int expected = 5;
        int actual = usualLimit.getLimit();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void reversed() {
        ManagerPoster reversed = new ManagerPoster();
        reversed.save(film6);
        reversed.save(film2);
        reversed.save(film1);
        PosterInfo[] expected = {film1, film2, film6};
        PosterInfo[] actual = reversed.findLast();
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void inSeries() {
        ManagerPoster inSeries = new ManagerPoster();
        inSeries.save(film4);
        inSeries.save(film1);
        inSeries.save(film7);
        PosterInfo[] expected = {film4, film1, film7};
        PosterInfo[] actual = inSeries.findAll();
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void reversedUnderLimit() {
        ManagerPoster underLimitReversed = new ManagerPoster(2);
        underLimitReversed.save(film1);
        underLimitReversed.save(film3);
        underLimitReversed.save(film5);
        PosterInfo[] expected = {film5, film3};
        PosterInfo[] actual = underLimitReversed.findLast();
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void reversedNoLimit() {
        ManagerPoster noLimitReversed = new ManagerPoster(5);
        noLimitReversed.save(film1);
        noLimitReversed.save(film3);
        noLimitReversed.save(film5);
        PosterInfo[] expected = {film5, film3, film1};
        PosterInfo[] actual = noLimitReversed.findLast();
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void inSeriesUnderLimit() {
        ManagerPoster underLimitInSeries = new ManagerPoster(2);
        underLimitInSeries.save(film2);
        underLimitInSeries.save(film4);
        underLimitInSeries.save(film6);
        PosterInfo[] expected = {film2, film4};
        PosterInfo[] actual = underLimitInSeries.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void inSeriesNoLimit() {
        ManagerPoster noLimitInSeries = new ManagerPoster(5);
        noLimitInSeries.save(film2);
        noLimitInSeries.save(film4);
        noLimitInSeries.save(film6);
        PosterInfo[] expected = {film2, film4, film6};
        PosterInfo[] actual = noLimitInSeries.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }
}
