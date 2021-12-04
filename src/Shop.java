import java.util.Random;

public class Shop implements Runnable{
    private final TaxService taxService;
    private final int[] sells = new int[200];

    public Shop(TaxService taxService) {
        Random random = new Random();
        this.taxService = taxService;
        for (int i = 0; i < sells.length; i++) {
            sells[i] = random.nextInt(300);
        }
    }

    @Override
    public void run() {
        for (int sell : sells) {
            taxService.add(sell);
        }
        System.out.println(Thread.currentThread().getName() + " подсчет выручки закончен.");
    }
}