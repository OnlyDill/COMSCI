package Lesson10.searching;

public class SearchExample1 {

    public static void main(String[] args) {
        String states[] = fillData();
        String state = "Ontario";
        int loc = linearSearch(states, state);
        System.out.format("%s was found at %d\n", state, loc);
        
        loc = binarySearch(states, state);
        System.out.format("%s was found at %d\n", state, loc);
                
    }

    public static int linearSearch(String arr[], String item) {
        int tries = 0;
        for (int i = 0; i < arr.length; i++) {
            tries++;
            if (item.equals(arr[i])) {
                System.out.println("Linear returning after " + tries + " tries");
                return i;
            }
        }
        System.out.println("Linear returning after " + tries + " tries");
        return -1; //not found
    }

    public static int binarySearch(Object[] a, Object searchValue) {
        int tries = 0;
        int left = 0;
        int right = a.length - 1;
        while (left <= right) {
            int midpoint = (left + right) / 2;
            int result = ((Comparable) a[midpoint]).compareTo(searchValue);
            tries++;
            if (result == 0) {
                System.out.println("Binary returning after " + tries + " tries");
                return midpoint;
            } else if (result < 0) {
                left = midpoint + 1;
            } else {
                right = midpoint - 1;
            }
        }
        System.out.println("Binary returning after " + tries + " tries");
        return -1;

    }

    public static String[] fillData() {
        String state[] = new String[50];
        state[0] = "Alabama";
        state[1] = "Alaska";
        state[2] = "Arizona";
        state[3] = "Arkansas";
        state[4] = "California";
        state[5] = "Colorado";
        state[6] = "Connecticut";
        state[7] = "Delaware";
        state[8] = "Florida";
        state[9] = "Georgia";
        state[10] = "Hawaii";
        state[11] = "Idaho";
        state[12] = "Illinois";
        state[13] = "Indiana";
        state[14] = "Iowa";
        state[15] = "Kansas";
        state[16] = "Kentucky";
        state[17] = "Louisiana";
        state[18] = "Maine";
        state[19] = "Maryland";
        state[20] = "Massachusetts";
        state[21] = "Michigan";
        state[22] = "Minnesota";
        state[23] = "Mississippi";
        state[24] = "Missouri";
        state[25] = "Montana";
        state[26] = "Nebraska";
        state[27] = "Nevada";
        state[28] = "New Hampshire";
        state[29] = "New Jersey";
        state[30] = "New Mexico";
        state[31] = "New York";
        state[32] = "North Carolina";
        state[33] = "North Dakota";
        state[34] = "Ohio";
        state[35] = "Oklahoma";
        state[36] = "Oregon";
        state[37] = "Pennsylvania";
        state[38] = "Rhode Island";
        state[39] = "South Carolina";
        state[40] = "South Dakota";
        state[41] = "Tennessee";
        state[42] = "Texas";
        state[43] = "Utah";
        state[44] = "Vermont";
        state[45] = "Virginia";
        state[46] = "Washington";
        state[47] = "West Virginia";
        state[48] = "Wisconsin";
        state[49] = "Wyoming";
        return state;
    }
}
