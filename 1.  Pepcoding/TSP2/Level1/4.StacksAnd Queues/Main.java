public class Main {

    public static void main(String[] args) {
        try {
            System.out.println("abc");
            if (1 == 1)
                throw new Exception();
            return;
        } catch (Exception e) {
            System.out.println(e);
            return;
        } finally {

            System.out.println("closing");

        }
    }

}
