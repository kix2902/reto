import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

import org.junit.Ignore;
import org.junit.Test;

import static java.lang.Thread.sleep;
import static junit.framework.TestCase.assertEquals;

public class SubsetSum {

    final private static boolean DEBUG = false;
    final private static int MAX_ACHIEVED = 34;
    protected ConcurrentHashMap<Integer, Boolean> results = new ConcurrentHashMap<Integer, Boolean>();

    @Test
    public void simplifiedSubsetSumSpec() {
        ArrayList<Integer> test1 = new ArrayList<>(Arrays.asList(1, 2, 3));
        assertEquals(getSimplifiedSubsetSum(test1), false);

        ArrayList<Integer> test2 = new ArrayList<>(Arrays.asList(-5, -3, -1, 2, 4, 6));
        assertEquals(getSimplifiedSubsetSum(test2), false);

        ArrayList<Integer> test3 = new ArrayList<>(Arrays.asList());
        assertEquals(getSimplifiedSubsetSum(test3), false);

        ArrayList<Integer> test4 = new ArrayList<>(Arrays.asList(-1, 1));
        assertEquals(getSimplifiedSubsetSum(test4), true);

        ArrayList<Integer> test5 = new ArrayList<>(Arrays.asList(-97364, -71561, -69336, 19675, 71561, 97863));
        assertEquals(getSimplifiedSubsetSum(test5), true);

        ArrayList<Integer> test6 = new ArrayList<>(Arrays.asList(-53974, -39140, -36561, -23935, -15680, 0));
        assertEquals(getSimplifiedSubsetSum(test6), true);

        ArrayList<Integer> test7 = new ArrayList<>(Arrays.asList(-2, 2, 3));
        assertEquals(getSimplifiedSubsetSum(test7), true);
    }

    @Test
    public void bonusOneSimpleSubsetSumSpec() {

        int[] test1 = {0};
        assertEquals(getSubsetSum(test1), true);

        int[] test2 = {-3, 1, 2};
        assertEquals(getSubsetSum(test2), true);

        int[] test3 = {-98634, -86888, -48841, -40483, 2612, 9225, 17848, 71967, 84319, 88875};
        assertEquals(getSubsetSum(test3), true);

        int[] test6 = {4, 4, -5, -3};
        assertEquals(getSubsetSum(test6), true);

        int[] test5 = null;
        assertEquals(getSubsetSum(test5), false);

        int[] test4 = {1, 2, 3, 4};
        assertEquals(getSubsetSum(test4), false);

    }

    @Test
    public void bonusOneComplexSubsetSumSpec() {

        int[] test1 = {-83314, -82838, -80120, -63468, -62478, -59378, -56958, -50061, -34791, -32264, -21928, -14988,
                23767, 24417, 26403, 26511, 36399, 78055};
        assertEquals(getSubsetSum(test1), false);

        int[] test2 = {-92953, -91613, -89733, -50673, -16067, -9172, 8852, 30883, 46690, 46968, 56772, 58703, 59150,
                78476, 84413, 90106, 94777, 95148};
        assertEquals(getSubsetSum(test2), false);

        int[] test3 = {-94624, -86776, -85833, -80822, -71902, -54562, -38638, -26483, -20207, -1290, 12414, 12627,
                19509, 30894, 32505, 46825, 50321, 69294};
        assertEquals(getSubsetSum(test3), false);

        int[] test4 = {-83964, -81834, -78386, -70497, -69357, -61867, -49127, -47916, -38361, -35772, -29803, -15343,
                6918, 19662, 44614, 66049, 93789, 95405};
        assertEquals(getSubsetSum(test4), false);

        int[] test5 = {-68808, -58968, -45958, -36013, -32810, -28726, -13488, 3986, 26342, 29245, 30686, 47966, 58352,
                68610, 74533, 77939, 80520, 87195};
        assertEquals(getSubsetSum(test5), false);

        int[] test6 = {-97162, -95761, -94672, -87254, -57207, -22163, -20207, -1753, 11646, 13652, 14572, 30580, 52502,
                64282, 74896, 83730, 89889, 92200};
        assertEquals(getSubsetSum(test6), true);

        int[] test7 = {-93976, -93807, -64604, -59939, -44394, -36454, -34635, -16483, 267, 3245, 8031, 10622, 44815,
                46829, 61689, 65756, 69220, 70121};
        assertEquals(getSubsetSum(test7), true);

        int[] test8 = {-92474, -61685, -55348, -42019, -35902, -7815, -5579, 4490, 14778, 19399, 34202, 46624, 55800,
                57719, 60260, 71511, 75665, 82754};
        assertEquals(getSubsetSum(test8), true);

        int[] test9 = {-85029, -84549, -82646, -80493, -73373, -57478, -56711, -42456, -38923, -29277, -3685, -3164,
                26863, 29890, 37187, 46607, 69300, 84808};
        assertEquals(getSubsetSum(test9), true);

        int[] test10 = {-87565, -71009, -49312, -47554, -27197, 905, 2839, 8657, 14622, 32217, 35567, 38470, 46885,
                59236, 64704, 82944, 86902, 90487};
        assertEquals(getSubsetSum(test10), true);
    }

    @Test
    public void bonusSubsetSumNinetyRecordsTrueSpec() {
        int[] test1 = {-83314, -82838, -80120, -63468, -62478, -59378,
                -56958, -50061, -34791, -32264, -21928, -14988, 23767, 24417, 26403, 26511, 36399, 78055, -92953,
                -91613, -89733, -50673, -16067, -9172, 8852, 30883, 46690, 46968, 56772, 58703, 59150, 78476, 84413,
                90106, 94777, 95148, -94624, -86776, -85833, -80822, -71902, -54562, -38638, -26483, -20207, -1290,
                12414, 12627, 19509, 30894, 32505, 46825, 50321, 69294, -83964, -81834, -78386, -70497, -69357, -61867,
                -49127, -47916, -38361, -35772, -29803, -15343, 6918, 19662, 44614, 66049, 93789, 95405, -68808, -58968,
                -45958, -36013, -32810, -28726, -13488, 3986, 26342, 29245, 30686, 47966, 58352, 68610, 74533, 77939,
                80520, 87195};

        // Note: there are better ways to benchmark but it's good enough for this
        long start = System.currentTimeMillis();

        assertEquals(getSubsetSum(test1), true);

        long elapsed = System.currentTimeMillis() - start;
        System.out.println("bonusSubsetSumNinetyRecordsTrueSpec(): elapsed time = " + elapsed + "ms");
    }

    @Test(timeout = 300000)
    public void bonusSubsetSumMaxNumRecordsFalseSpec() {

        int[] array = IntStream.rangeClosed(1, MAX_ACHIEVED).toArray();

        // Note: there are better ways to benchmark but it's good enough for this
        long start = System.currentTimeMillis();

        assertEquals(getSubsetSum(array), false);

        long elapsed = System.currentTimeMillis() - start;
        System.out.println("bonusSubsetMaxNumRecordsTrueSpec(): elapsed time = " + elapsed + "ms");
    }

    @Test
    @Ignore
    public void calculateMaxRange5minutes() {

        int i = 1;
        while (i < MAX_ACHIEVED) {
            int[] array = IntStream.rangeClosed(1, i).toArray();

            // Note: there are better ways to benchmark but it's good enough for this
            long start = System.currentTimeMillis();

            assertEquals(getSubsetSum(array), false);

            long elapsed = System.currentTimeMillis() - start;
            System.out.println("Array with " + i + " records: elapsed time = " + elapsed + "ms");

            if (elapsed > 300000) {
                break;
            }

            i++;
        }

        assertEquals(i, MAX_ACHIEVED);
    }

    // Solution without bonuses
    public boolean getSimplifiedSubsetSum(ArrayList<Integer> arrayList) {
        // Note, not very efficient, we are repeating check here
        return arrayList.stream().anyMatch(n1 -> arrayList.stream().anyMatch(n2 -> n1 + n2 == 0));
    }

    // Solution with first bonus, no performance analysis
    public boolean getSubsetSum(int[] arrayList) {

        if ((arrayList == null) || (arrayList.length == 0)) {
            return false;
        }

        if (arrayList.length == 1) {
            return arrayList[0] == 0;
        }

        int nThreads = arrayList.length;
        ExecutorService executorService = Executors.newFixedThreadPool(nThreads);

        class OneShotTask implements Runnable {
            int[] elements;
            int K;

            OneShotTask(int[] elementsParam, int KParam) {
                elements = elementsParam;
                K = KParam;
            }

            public void run() {
                try {

                    generateAllSubArrays(elements, K);

                } catch (Exception e) {
                    e.printStackTrace();
                    System.exit(-1);
                }
            }
        }

        for (int h = 1; h <= arrayList.length ; h++) {
            executorService.execute(new OneShotTask(arrayList, h));
        }

        while (results.size() < arrayList.length) {
            try {
                sleep(500);
                if (results.entrySet().stream().anyMatch(entry -> entry.getValue() == true)) {
                    break;
                }
            } catch (InterruptedException e) {
                break;
            }
        }
        executorService.shutdown();
        boolean result = results.entrySet().stream().anyMatch(entry -> entry.getValue() == true);
        results.clear();
        return result;
    }

    private boolean generateAllSubArrays(int[] elements, int K)  {

        int N = elements.length;
        int combination[] = new int[K];

        int r = 0;
        int index = 0;

        while (r >= 0) {

            if (index <= (N + (r - K))) {
                combination[r] = index;

                if (r == K - 1) {

                    int sum = 0;
                    for (int z = 0; z < combination.length; z++) {
                        sum += elements[combination[z]];
                    }

                    if (sum == 0) {
                        results.put(Integer.valueOf(K), Boolean.valueOf(true));
                        if (DEBUG) {
                            String output = "";
                            for(int z = 0 ; z < combination.length;z++){
                                output += elements[combination[z]] + "_";
                            }
                            System.out.println("TRUE: " + output);
                        }
                        return true;
                    }

                    if (DEBUG) {
                        String output = "";
                        for(int z = 0 ; z < combination.length;z++){
                            output += elements[combination[z]] + "_";
                        }
                        System.out.println("FALSE: " + output);
                    }

                    index++;
                } else {
                    index = combination[r] + 1;
                    r++;
                }
            } else {
                r--;
                if (r > 0) {
                    index = combination[r] + 1;
                } else {
                    index = combination[0] + 1;
                }
            }
        }
        results.put(K, false);
        return false;
    }
}

