package com.algomind.leetcode.rotateimage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class RotateImageTest {
    private final RotateImage rotateImage = new RotateImage();

    @ParameterizedTest
    @MethodSource("provideData")
    public void test(int[][] expected, int[][] matrix) {
        rotateImage.rotate(matrix);

        for(int i = 0 ; i < matrix.length; i ++) {
            Assertions.assertArrayEquals(expected[i], matrix[i]);
        }
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(
                        new int[][]{new int[]{1}},
                        new int[][]{new int[]{1}}),
                Arguments.of(
                        new int[][]{new int[]{3,1},new int[]{4,2}},
                        new int[][]{new int[]{1,2},new int[]{3,4}}),
                Arguments.of(
                        new int[][]{new int[]{7,4,1},new int[]{8,5,2},new int[]{9,6,3}},
                        new int[][]{new int[]{1,2,3},new int[]{4,5,6},new int[]{7,8,9}}),
                Arguments.of(
                        new int[][]{new int[]{15,13,2,5},new int[]{14,3,4,1},new int[]{12,6,8,9},new int[]{16,7,10,11}},
                        new int[][]{new int[]{5,1,9,11},new int[]{2,4,8,10},new int[]{13,3,6,7},new int[]{15,14,12,16}}),
                Arguments.of(
                        new int[][]{new int[]{21,16,11,6,1},new int[]{22,17,12,7,2},new int[]{23,18,13,8,3},new int[]{24,19,14,9,4},new int[]{25,20,15,10,5}},
                        new int[][]{new int[]{1,2,3,4,5},new int[]{6,7,8,9,10},new int[]{11,12,13,14,15},new int[]{16,17,18,19,20},new int[]{21,22,23,24,25}})
        );
    }
}