import java.util.HashSet;
import java.util.Set;

public class Solution929 {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            int i = email.indexOf("@");
            String local = email.substring(0, i).split("\\+")[0];
            set.add(local.replace(".", "") + email.substring(i));
        }
        return set.size();
    }
}
