package za.co.carhire.util;

import org.apache.commons.validator.routines.EmailValidator;
import za.co.carhire.domain.reservation.Booking;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.List;

public class Helper {
    public static boolean isNullOrEmpty(String s) {
        return s == null || s.isEmpty();
    }
    public static boolean isValidPostalCode(short postalCode) {
        if (postalCode < -1 || postalCode > 9999) {
            return false;
        }
        return true;
    }
    public static boolean isValidPolicyNumber(long policyNumber) {
        if (policyNumber < 1 || policyNumber > 999999999) {
            return false;
        }
        return true;
    }
    public static boolean isValidNationalIDNumber(String nationalIDNumber) {
        if (nationalIDNumber == null || nationalIDNumber.isEmpty()) {
            return false;
        }
        return true;
    }
    private static final List<String> VALID_PAYMENT_METHODS =
            List.of("CREDIT_CARD", "EFT", "CASH", "BANK TRANSFER");

    public static boolean isValidPaymentMethod(String method) {
        return !isNullOrEmpty(method) &&
                VALID_PAYMENT_METHODS.contains(method.toUpperCase());
    }

    public static boolean isBookingPayable(Booking booking) {
        try {
            return booking != null &&
                    !isNullOrEmpty(booking.getBookingStatus()) &&
                    !booking.getBookingStatus().equalsIgnoreCase("CANCELLED") &&
                    booking.getEndDate() != null &&
                    booking.getEndDate().after(new Date());
        } catch (Exception e) {
            return false;
        }
    }
    public static int generateId() {
        return (int) (Math.random() * 1000000);
    }

    public static long daysBetween(Date start, Date end) {
        return (end.getTime() - start.getTime());
    }


    public static boolean isEmptyOrNull(String str) {
        if (str.isEmpty() ||str == null || str.equalsIgnoreCase("null")) {
            return true;
        }
        return false;
    }
    public static boolean isValidDate(String dateString) {
        if (dateString == null || dateString.trim().isEmpty()) {
            return false;
        }

        try {
            LocalDate.parse(dateString); // Uses format: yyyy-MM-dd
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }


    // The following method uses a singleton pattern to validate an email address
    public static boolean isValidEmail(String email) {
        if (email == null || !email.contains("@")) {
            return false;
        }

        EmailValidator validator = EmailValidator.getInstance();
        return validator.isValid(email);
    }


}
