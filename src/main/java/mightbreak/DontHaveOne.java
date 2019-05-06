package mightbreak;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class DontHaveOne {
    public static void main(String[] args) {
        Map<String, String> names = new HashMap<>();
        names.put("Fred", "Jones");

        String target = "Fred";
        String last = names.get(target);
        if (last != null) {
            String address = "Mx. " + last.toUpperCase();
            System.out.println("Dear " + address);
        } else {
            System.out.println("Name not found");
        }

        Optional.of(names)
                .map(m -> m.get(target))
                .map(n -> "Dear Mx. " + n)
                .ifPresentOrElse(s -> System.out.println(s), () -> System.out.println("Name not found"));
    }
}
