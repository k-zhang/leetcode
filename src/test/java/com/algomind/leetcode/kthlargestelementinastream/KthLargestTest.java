package com.algomind.leetcode.kthlargestelementinastream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class KthLargestTest {
    @ParameterizedTest
    @MethodSource("provideData")
    public void test(int[] expected, int k, int[] init, int[] nums) {
        KthLargest solution = new KthLargest(k, init);

        List<Integer> results = new ArrayList<>();
        for(var num : nums) {
            int result = solution.add(num);
            results.add(result);
        }

        Assertions.assertArrayEquals(expected, results.stream().mapToInt(i -> i).toArray());
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(new int[]{4,5,5,8,8}, 3, new int[]{4,5,8,2}, new int[]{3,5,10,9,4}),
                Arguments.of(new int[]{8,8,10,10,10}, 1, new int[]{4,5,8,2}, new int[]{3,5,10,9,4}),
                Arguments.of(new int[]{-3,-2,-2,0,4}, 1, new int[]{}, new int[]{-3,-2,-4,0,4}),
                Arguments.of(new int[]{-1,1,1,2,3}, 3, new int[]{5,-1}, new int[]{2,1,-1,3,4})
        );
    }
}