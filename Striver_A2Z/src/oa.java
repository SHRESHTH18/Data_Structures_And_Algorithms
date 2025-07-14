import java.util.*;
class oa {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        for(int i=0; i<n; i++){
            list.add(sc.nextInt());
        }
        int k = sc.nextInt();
        System.out.println(findoptimalResources(list,k));

    }
//    public static long findoptimalResources(List<Integer> arr, int k) {
//        int n = arr.size();
//        if (k > n) {
//            return -1;
//        }
//        long maxSum = -1;
//        for (int i = 0; i <= n - k; i++) {
//            Set<Integer> uniqueElements = new HashSet<>();
//            long sum = 0;
//            boolean allUnique = true;
//            for (int j = i; j < i + k; j++) {
//                if (!uniqueElements.add(arr.get(j))) {
//                    allUnique = false;
//                    break;
//                }
//                sum += arr.get(j);
//            }
//            if (allUnique) {
//                maxSum = Math.max(maxSum, sum);
//            }
//        }
//
//        return maxSum;
//    }

    public static long findoptimalResources(List<Integer> arr,int k){
        int n=arr.size();
        if(k>n) return -1;
        long sum=0;
        long max=-1;
        HashMap<Integer,Integer> map =new HashMap<>();
        for(int i=0;i<k;i++){
            map.put(arr.get(i),map.getOrDefault(arr.get(i),0)+1);
            sum+=arr.get(i);
        }
        if(map.size()==k){
            max=sum;
        }
        int left=0;
        for(int r=k;r<n;r++){
            sum+=arr.get(r);
            sum-=arr.get(left);
            map.put(arr.get(r),map.getOrDefault(arr.get(r),0)+1);
            map.put(arr.get(left),map.get(arr.get(left))-1);
            if(map.get(arr.get(left))==0){
                map.remove(arr.get(left));
            }
            if(map.size()==k && sum>max){
                max=sum;
            }
            left++;
        }
        return max;
    }
//    public static void main(String[] args) {
//        List<Long> list = new ArrayList<>();
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        for (int i = 0; i < n; i++) {
//            list.add(sc.nextLong());
//        }
//
//
//        List<Integer> result = getValidKeyCount(list);
//        System.out.println(result);
//    }
//
//    public static List<Integer> getValidKeyCount(List<Long> keys) {
//        long maxKey = 0;
//        for (Long key : keys) {
//            maxKey = Math.max(maxKey, key);
//        }
//
//        long sqrtMaxKey = (long) Math.sqrt(maxKey);
//        List<Long> primes = sieveOfEratosthenes(sqrtMaxKey);
//
//        List<Integer> result = new ArrayList<>();
//
//        for (Long key : keys) {
//            int count = 0;
//            long sqrtKey = (long) Math.sqrt(key);
//
//
//            for (Long prime : primes) {
//                if (prime <= sqrtKey) {
//                    count++;
//                } else {
//                    break;
//                }
//            }
//
//            result.add(count);
//        }
//
//        return result;
//    }
//
//    // Generate all primes up to n using Sieve of Eratosthenes
//    private static List<Long> sieveOfEratosthenes(long n) {
//        boolean[] isNotPrime = new boolean[(int)n + 1];
//        List<Long> primes = new ArrayList<>();
//
//        for (int i = 2; i <= n; i++) {
//            if (!isNotPrime[i]) {
//                primes.add((long)i);
//                for (int j = i * i; j <= n; j += i) {
//                    isNotPrime[j] = true;
//                }
//            }
//        }
//
//        return primes;
//    }
}