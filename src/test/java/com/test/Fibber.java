package com.test;
import java.util.Map;
import java.util.HashMap;

class Fibber {

    private Map<Integer, Integer> memo = new HashMap<Integer, Integer>();

    public int fib(int n) {

        if (n < 0) {
            throw new IllegalArgumentException(
                "Index was negative. No such thing as a negative index in a series.");

        // base cases
        } else if (n == 0 || n == 1) {
            return n;
        }

        // see if we've already calculated this
        if (memo.containsKey(n)) {
            System.out.printf("grabbing memo[%d]\n", n);
            return memo.get(n);
        }

        System.out.printf("computing fib(%d)\n", n);
        int result = fib(n - 1) + fib(n - 2);

        // memoize
        memo.put(n, result);

        return result;
    }
    public static int fib1(int n) {

        if (n < 0) {
            throw new IllegalArgumentException(
                "Index was negative. No such thing as a negative index in a series.");
        }

        // base cases
        if (n == 0 || n == 1) {
            return n;
        }

        System.out.printf("computing fib(%d)\n", n);
        return fib1(n - 1) + fib1(n - 2);
    }
    public static void main(String [] args)
    {
    	Fibber fb=new Fibber();
    	fb.fib(5);
    	fb.fib1(5);
    }
}