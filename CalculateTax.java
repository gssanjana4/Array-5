// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        // System.out.println("Hello World!");
        double salary = 55000;
        List<List<Double>> taxbracket = new ArrayList<>();
        taxbracket.add(Arrays.asList(10000.0, 0.1));
        taxbracket.add(Arrays.asList(20000.0, 0.2));
        taxbracket.add(Arrays.asList(30000.0, 0.3));
        taxbracket.add(Arrays.asList(null, 0.4));
        double res = calculateTax(taxbracket, salary);
        System.out.println(res);
    }
    
    public static double calculateTax(List<List<Double>> levels, double balance){
        
        double taxableAmt = 0, taxVal = 0, prev = 0;
        int i=0;
        while(balance > 0){
        
            System.out.println(balance);
            // check if the index is 3 because we know that we have reached end of tax calculation and then return the tax result 
            if(i == 3)
            {
                 taxVal += balance * 0.4;
                 return taxVal;
            }
            List<Double> taxbracket = levels.get(i);

            taxableAmt = Math.min(taxbracket.get(0) - prev, balance);
            taxVal += taxableAmt * taxbracket.get(1);
            balance -= taxableAmt;
            prev = taxableAmt;
            i++;
        }
        return taxVal;

    }
}
