public class Manual
{
    public static void prolog ()
    {
        System.out.println("Choose the powers of Your organism. You can choose 6 of 8 abilities. They don't have to be unique." + "\n" +
                "For example You can have 2x strength or 3x flying. Choose wisely. Every ability is permutation od 4 letters: ABCD" + "\n" +
                "There is 20 permutations at all. 10 of them are just 'trash DNA'. In next rounds You will mutate and then You will get posibility" + "\n" +
                "to crossbreed with other organism. Let's start");
    }

    public static void abilities ()
    {
        System.out.println("1. ABCD - Strength      2. ACBD = Speed     3. ACDB - Flying" + "\n"+
                "4. ADBC - Armor        5. ADCB - Hearing       6. BACD = Smell" + "\n"+
                "7. BACD - Sight        8. BDAC = Swimming");
    }
}
