import java.util.HashMap;

public class ScrambledString {
    public static void main(String[] args) {
        String a = "great", b = "rgeat";
        if (a.length() == b.length()) {
            boolean ans = fun(a, b);
            System.out.println(ans);
        } else {
            System.out.println("false");
        }
    }

    static HashMap<String, Boolean> map = new HashMap<>();

    static boolean fun(String a, String b) {

        if (a.equals(b))
            return true;
        if (a.length() <= 1)
            return false;

        if (map.containsKey(a + "_" + b)) {
            return map.get(a + "_" + b);
        }

        boolean flag = false;

        for (int k = 1; k <= a.length() - 1; k++) {
            if (fun(a.substring(0, k), b.substring(a.length() - k)) == true
                    && fun(a.substring(k), b.substring(0, a.length() - k)) == true) {
                flag = true;
                break;
            } else if (fun(a.substring(0, k), b.substring(0, k)) == true
                    && fun(a.substring(k), b.substring(k)) == true) {
                flag = true;
                break;
            }
        }
        map.put(a + "_" + b, flag);
        return flag;
    }

    static boolean funDp(String a, String b) {

        if (a.equals(b))
            return true;
        if (a.length() <= 1)
            return false;

        if (map.containsKey(a + "_" + b)) {
            return map.get(a + "_" + b);
        }

        boolean flag = false;
        int len = a.length();
        for (int i = 1; i <= len - 1; i++) {

            String al, ar, bl, br;
            boolean swap1, swap2;
            boolean noSwap1, noSwap2;
            String all, arr, bll, brr;

            al = a.substring(0, i);
            br = b.substring(len - i);
            ar = a.substring(i);
            bl = b.substring(0, len - i);

            if (map.containsKey(al + "_" + br)) {
                swap1 = map.get(al + "_" + br);
            } else {
                swap1 = fun(a.substring(0, i), b.substring(len - i));
            }

            if (map.containsKey(ar + "_" + bl)) {
                swap2 = map.get(ar + "_" + bl);
            } else {
                swap2 = funDp(a.substring(i), b.substring(0, len - i));
            }

            all = a.substring(0, i);
            bll = b.substring(0, i);
            arr = a.substring(i);
            brr = b.substring(i);

            if (map.containsKey(all + "_" + bll)) {
                noSwap1 = map.get(all + "_" + bll);
            } else {
                noSwap1 = fun(a.substring(0, i), b.substring(0, i));
            }

            if (map.containsKey(arr + "_" + brr)) {
                noSwap2 = map.get(arr + "_" + brr);
            } else {
                noSwap2 = funDp(a.substring(i), b.substring(i));
            }

            if (swap1 == true && swap2 == true) {
                flag = true;
                break;
            } else if (noSwap1 == true && noSwap2 == true) {
                flag = true;
                break;
            }
        }
        map.put(a + "_" + b, flag);
        return flag;
    }

}
