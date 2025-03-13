package day32;

class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        for (int i = 0; i < image.length; i++) {
            reverseArray(image[i]);
        }
        for (int i = 0; i < image.length; i++) {
            bitReverse(image[i]);
        }
        return image;
    }

    static void bitReverse(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] ^ 1;
        }
    }

    static void reverseArray(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}
