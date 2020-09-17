package bai_hoc.thuat_toan_tim_kiem.bai_tap.cai_dat_thuat_toan_tim_kiem;

class BinarySearch {

    public int binarySearch(int arr[], int l, int r, int x) {
        if (r >= l) {
            int mid = (r - l) / 2;

            // Nếu arr[mid] = x, trả về chỉ số và kết thúc
            if (arr[mid] == x)
                return mid;
            // Nếu arr[mid] > x, gọi đệ quy tìm kiếm bên trái
            if (arr[mid] > x)
                return binarySearch(arr, l, mid - 1, x);
            // Ngược lại, nếu arr[mid] < x, gọi đệ quy tìm kiếm bên phải
            return binarySearch(arr, mid + 1, r, x);
        }

        // Trong trường hợp không tìm thấy
        return -1;
    }

    public static void main(String args[]) {
        BinarySearch ob = new BinarySearch();
        int arr[] = {2, 3, 4, 10, 40};
        int n = arr.length;
        int x = 10;
        int result = ob.binarySearch(arr, 0, n - 1, x);
        if (result == -1)
            System.out.println("Không tìm thấy phần tử " + x);
        else
            System.out.println("Phần tử " + x + " được tìm thấy tại chỉ số " +
                    result);
    }
}
