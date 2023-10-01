package seedu.address.model.person;

import static java.util.Objects.requireNonNull;


/**
 * Represents the Remark of a Person in the Address book
 *
 * @author Anton Tan Hong Zhi
 */
public class Remark {
    public final String value;

    /**
     * Constructor for a Remark object
     * @param remark the remark for the person
     */
    public Remark(String remark) {
        requireNonNull(remark);
        value = remark;
    }
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Remark)) {
            return false;
        }

        Remark otherRemark = (Remark) other;
        return value.equals(otherRemark.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
