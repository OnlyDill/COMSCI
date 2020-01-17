package Lesson10.recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class Array220 {

    private ArrayList<int[]> in;
    private ArrayList<Boolean> out;
    private String id;

    public Array220(ArrayList<int[]> i, ArrayList<Boolean> o, String inid) {
        in = i;
        out = o;
        id = inid;
    }

    public static void main(String[] args) {
        ArrayList<int[]> testdata = new ArrayList();
        testdata.add(new int[]{1, 2, 20});
        testdata.add(new int[]{3, 30});
        testdata.add(new int[]{3});
        testdata.add(new int[]{});
        testdata.add(new int[]{3, 3, 30, 4});

        ArrayList<Boolean> expected = new ArrayList();
        expected.add(true);
        expected.add(true);
        expected.add(false);
        expected.add(false);
        expected.add(true);

        Array220 prob = new Array220(testdata, expected, "array220");

        prob.solve();

    }

    public void solve() {
        for (int i = 0; i < in.size(); i++) {
            boolean result = array220(in.get(i), 0);
            System.out.print(id + "(" + Arrays.toString(in.get(i)) + ") ->");
            System.out.print(out.get(i) + " | " + result);
            if (result == out.get(i)) {
                System.out.println(" | OK");
            } else {
                System.out.println(" | FAIL");
            }
        }
    }

    public boolean array220(int[] nums, int index) {
        if (index == nums.length - 1 || nums.length < 1) {
            return false;
        }
        if (nums[index] * 10 == nums[index + 1]) {
            return true;
        } else {
            return array220(nums, index + 1);
        }
    }

}
