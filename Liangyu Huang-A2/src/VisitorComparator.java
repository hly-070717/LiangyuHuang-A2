import java.util.Comparator;

/**
 * Comparator for sorting Visitor objects.
 * Compares visitors by at least two instance variables.
 * Implements Comparator interface as required (not Comparable).
 */
public class VisitorComparator implements Comparator<Visitor> {

    /**
     * Compares two Visitor objects for sorting.
     * Uses two comparison criteria:
     * 1. Primary: Age (younger to older)
     * 2. Secondary: Name alphabetically (if ages are equal)
     *
     * @param v1 the first visitor to compare
     * @param v2 the second visitor to compare
     * @return negative if v1 < v2, zero if equal, positive if v1 > v2
     */
    @Override
    public int compare(Visitor v1, Visitor v2) {
        if (v1 == null && v2 == null) return 0;
        if (v1 == null) return -1;
        if (v2 == null) return 1;

        // Primary comparison: Age (ascending - younger first)
        int ageComparison = Integer.compare(v1.getAge(), v2.getAge());

        // If ages are equal, use secondary comparison: Name (alphabetical)
        if (ageComparison == 0) {
            return v1.getName().compareToIgnoreCase(v2.getName());
        }

        return ageComparison;
    }

    /**
     * Alternative comparator that sorts by different criteria.
     * This demonstrates using different comparison strategies.
     */
    public static class NameComparator implements Comparator<Visitor> {
        @Override
        public int compare(Visitor v1, Visitor v2) {
            if (v1 == null && v2 == null) return 0;
            if (v1 == null) return -1;
            if (v2 == null) return 1;

            // Primary: Membership type (VIP first)
            int typeComparison = getMembershipPriority(v2) - getMembershipPriority(v1);

            // Secondary: Name (alphabetical)
            if (typeComparison == 0) {
                return v1.getName().compareToIgnoreCase(v2.getName());
            }

            return typeComparison;
        }

        private int getMembershipPriority(Visitor visitor) {
            if (visitor == null) return 0;
            String type = visitor.getMembershipType().toLowerCase();
            if (type.contains("vip") || type.contains("premium")) return 3;
            if (type.contains("student")) return 2;
            return 1; // Regular
        }
    }

    /**
     * Another comparator for demonstration purposes.
     */
    public static class TicketNumberComparator implements Comparator<Visitor> {
        @Override
        public int compare(Visitor v1, Visitor v2) {
            if (v1 == null && v2 == null) return 0;
            if (v1 == null) return -1;
            if (v2 == null) return 1;

            // Compare by season pass status (pass holders first)
            if (v1.hasSeasonPass() && !v2.hasSeasonPass()) return -1;
            if (!v1.hasSeasonPass() && v2.hasSeasonPass()) return 1;

            // If both have or don't have passes, compare by ticket number
            return v1.getTicketNumber().compareTo(v2.getTicketNumber());
        }
    }
}