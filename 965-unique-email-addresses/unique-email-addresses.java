import java.util.*;

class Solution {
    public int numUniqueEmails(String[] emails) {

        Set<String> set = new HashSet<>();

        for (String email : emails) {

            String[] parts = email.split("@");
            String local = parts[0];
            String domain = parts[1];

            // ignore everything after '+'
            if (local.contains("+")) {
                local = local.substring(0, local.indexOf('+'));
            }

            // remove '.'
            local = local.replace(".", "");

            String normalized = local + "@" + domain;
            set.add(normalized);
        }

        return set.size();
    }
}