public class Player {
    private float nyawa = 100.0f;
    private float level = 1.0f;
    private Item[] ransel = new Item[10];

    public float getNyawa() { return nyawa; }
    public float getLevel() { return level; }

    public void tambahItem(Item item) {
        for (int i = 0; i < ransel.length; i++) {
            if (ransel[i] == null) {
                ransel[i] = item;
                return;
            }
        }
    }

    public void tampilkanRansel() {
        System.out.println("Isi Ransel:");
        for (int i = 0; i < ransel.length; i++) {
            System.out.println((i + 1) + ". " + (ransel[i] == null ? " " : ransel[i].nama));
        }
    }

    public void kurangiNyawa(int damage) {
        nyawa -= damage;
    }

    public void naikLevel() {
        level += 0.5;
        System.out.println("Naik level! Level sekarang: " + level);
    }
}
