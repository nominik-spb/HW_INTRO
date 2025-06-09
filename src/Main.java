public class Main {

    public static void main(String[] args) {
        int[] prices = {13, 17, 19, 25, 25, 25, 25, 25, 25, 27, 30};

        System.out.println("Для 31: " + countMore(prices, 31)); // 0
        System.out.println("Для 26: " + countMore(prices, 26)); // 2
        System.out.println("Для 25: " + countMore(prices, 25)); // 2
        System.out.println("Для 20: " + countMore(prices, 20)); // 8
    }

    public static int countMore(int[] prices, int money) {
        if (prices[0] > money) {
            return prices.length; // все недоступны
        }

        if (prices[prices.length - 1] < money) {
            return 0; // все доступны
        }

        int left = 0;
        int right = prices.length - 1;
        while (left < right) {
            int middle = (left + right) / 2;

            if (prices[middle] > money && prices[middle - 1] <= money) {
                return prices.length - middle;
            } else if (prices[middle] <= money) {
                left = middle + 1;
                continue;
            } else {
                right = middle - 1;
                continue;
            }

            // Ваш код:
            // Если в middle первый недоступный товар, вернуть размер массива минус middle
            // Если в middle доступный товар, то искать нужно правее - left = middle + 1
            // Если в middle недоступный товар, то искать нужно левее - right = middle - 1

        }
        return 0; // иначе не скомпилится, джава сама не знает бинпоис
    }
}