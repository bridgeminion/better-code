package by_frequency_and_tag.two_pointer;

public class NextPermutation {
    public void nextPermutation(int[] A) {
    }

    public void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    public void reverse(int[] A, int i, int j) {
    }

    public static void main(String[] args) {
        NextPermutation app = new NextPermutation();
        int[] nums = {5,3,3,0};
        app.nextPermutation(nums);
    }
}
