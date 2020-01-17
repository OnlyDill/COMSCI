
package Lesson10.recursion;

import java.util.ArrayList;

public class CountPairs {
    
    private ArrayList<String> in;
    private ArrayList<Integer> out;
    private String id;
    
    public CountPairs(ArrayList<String> i, ArrayList<Integer> o, String inid){
        in = i;
        out = o;
        id = inid;
    }
    public static void main(String[] args) {
        ArrayList<String> testdata = new ArrayList();
        testdata.add("axa");
        testdata.add("axax");
        testdata.add("axbx");
        testdata.add("hi");
        testdata.add("hihih");
        
        ArrayList<Integer> expected = new ArrayList();
        expected.add(1);
        expected.add(2);
        expected.add(1);
        expected.add(0);
        expected.add(3);
        
        CountPairs prob = new CountPairs (testdata, expected, "countPairs");
        
        prob.solve();
            
    }
    
    public void solve(){
        for (int i = 0; i < in.size(); i++) {
            int result = countPairs(in.get(i));
            System.out.print(id + "(" + in.get(i) + ") ->");
            System.out.print(out.get(i) + " | " + result);
            if (result==out.get(i)) {
                System.out.println(" | OK");
            }
            else{
                System.out.println(" | FAIL");
            }
        }
    }
    
    public int countPairs(String str){
        if (str.length() < 3)
            return 0;
        else if (str.charAt(0)==str.charAt(2))
            return 1 + countPairs (str.substring(1));
        else
            return 0 + countPairs(str.substring(1));
    }
}
