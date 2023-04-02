public class Fibonachi {

    public static int main(String[] args) {
        int count = 3;

        int prev = 0;
        int next = 1;
        if (count == 0){;
            return next = 0;
        }
        if (count == 1){;
            return next = 1;
        }
        if (count > 1){;
            for (int i = 2; i < count; i++) {
                int temp = next;
                next = prev+next;
                prev = temp;
            }
            return next;
        }

        System.out.println(next);
    }
}
