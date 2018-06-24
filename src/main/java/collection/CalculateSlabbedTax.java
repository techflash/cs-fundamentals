package collection;

import java.util.Comparator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class CalculateSlabbedTax {
    NavigableMap<Range, Double> map = new TreeMap<>(new Comparator<Range>() {
        @Override
        public int compare(Range o1, Range o2) {
            if (o1.low == o2.low) return 0;
            return o1.low > o2.low ? 1 : -1;
        }
    });

    public CalculateSlabbedTax() {
        map.put(new Range(250000, 500000), 5.0);
        map.put(new Range(500000, 1000000), 20.0);
        map.put(new Range(1000000, Integer.MAX_VALUE), 30.0);
        map.put(new Range(0, 250000), 0.0);
    }

    public static void main(String[] args) {
        double totalSalary = 1500000;
        CalculateSlabbedTax calculateSlabbedDiscount = new CalculateSlabbedTax();
        double taxableIncome = calculateSlabbedDiscount.calculateTaxOnSalary(totalSalary);

        System.out.println(taxableIncome);
    }

    private double calculateTaxOnSalary(double totalSalary) {
        double taxableSalary = totalSalary;
        double totalTax = 0;

        for (Map.Entry<Range, Double> entry : map.entrySet()) {

            if (taxableSalary > (entry.getKey().high - entry.getKey().low)) {
                double applicableSal = (entry.getKey().high - entry.getKey().low);
                taxableSalary = taxableSalary - applicableSal;

                if (entry.getValue() > 0) {
                    totalTax = totalTax + (((applicableSal) * entry.getValue()) / 100);
                }

            } else {
                totalTax = totalTax + ((taxableSalary * entry.getValue()) / 100);
                break;
            }

        }

        return totalTax;
    }


    private static class Range {
        private int low;
        private int high;

        private Range(int low, int high) {
            this.low = low;
            this.high = high;
        }

        public int getLow() {
            return low;
        }

        public void setLow(int low) {
            this.low = low;
        }

        public int getHigh() {
            return high;
        }

        public void setHigh(int high) {
            this.high = high;
        }

        @Override
        public String toString() {
            return "Range{" +
                    "low=" + low +
                    ", high=" + high +
                    '}';
        }

        @Override
        public int hashCode() {
            return 31 * this.low * this.high;
        }

        @Override
        public boolean equals(Object obj) {
            Range that = (Range) obj;
            if (this == obj) return true;
            else if (this.low == that.low && this.high == that.high) {
                return true;
            }
            return super.equals(obj);
        }
    }
}
