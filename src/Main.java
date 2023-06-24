public class Main {
    public static void main(String[] args) {
        Fighter f1 = new Fighter("Can", 20, 120, 100, 20);
        Fighter f2 = new Fighter("Yusuf", 10, 105, 95, 60);

        Match match = new Match(f1, f2, 85, 100);
        match.run();
    }
}