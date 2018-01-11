import java.util.ArrayList;
import java.util.List;

public class PrintCategories {
    public void altCategories(Category ana, List<Category> test, String katman) {
        if (ana.getParentId() != null) {
            katman += "-";
        }
        System.out.print(katman);
        System.out.println(ana.toString());
        for (Category cat : test) {
            if (cat.getParentId() != null) {
                if (cat.getParentId() == ana.getId()) {
                    altCategories(cat, test, katman);
                }
            }
        }
    }

    public static void main(String[] args) {
        List<Category> cats = new ArrayList<Category>();
        cats.add(new Category(6, 11, "roman"));
        cats.add(new Category(63, 6, "klasik"));
        cats.add(new Category(11, null, "kitap"));
        cats.add(new Category(36, 6, "polisiye"));
        cats.add(new Category(130, 63, "dunya"));
        cats.add(new Category(13, 11, "hikaye"));
        cats.add(new Category(133, 36, "yerli"));
        cats.add(new Category(16, 17, "lise"));
        cats.add(new Category(17, 11, "ders kitaplari"));
        cats.add(new Category(23, 17, "ilkokul"));
        cats.add(new Category(106, 2, "kursun"));
        cats.add(new Category(31, 2, "tükenmez"));
        cats.add(new Category(2, null, "kalem"));


        PrintCategories p = new PrintCategories();

        List<Category> basliklar = new ArrayList<>();
        for (Category test : cats) {
            if (test.getParentId() == null) {
                basliklar.add(test);

            }
        }
        for (Category test : basliklar) {
            p.altCategories(test, cats, "");
        }

    }
}
