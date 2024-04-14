/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.faysal;

import java.time.LocalDate;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Faysal Kabir Ashik
 */
public final class Validation {
    
    private static final String LOWERCASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUMBERS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "_";

    private static final String EMAIL_REGEX =
            "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    /// validation


    public static boolean isValidEmail(String email) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    public static boolean allDigits(String str) 
    {
        if (str == null) {return false;}
        String digitPattern = "\\d+";
        return str.matches(digitPattern);
    }
    
    public static boolean containsWhiteSpace(String str) 
    {
    return str.contains(" ");
    }
    
        public static boolean isValidUsername(String username) {
        String pattern = "^[a-z_][a-z0-9_]*$";
        return username.matches(pattern);
    }

    
    public static boolean isValisUserIdentity(String userIdentity)
    {
       return (!containsWhiteSpace(userIdentity)) && (isValidUsername(userIdentity) || allDigits(userIdentity));
    }
    
    public static boolean hasUniqueCharacter(String str) {
    // Regular expression to match any special character
    String pattern = ".*[^a-zA-Z0-9].*";
    return str.matches(pattern);
}

    // 2. Check if a string has at least one number
    public static boolean hasNumber(String str)
    {
        String pattern = ".*\\d.*";
        return str.matches(pattern);
    }

    // 3. Check if a string has at least one letter
    public static boolean hasLetter(String str)
    {
        String pattern = ".*[a-zA-Z].*";
        return str.matches(pattern);
    }

    // 4. Check if a string has at least one lowercase letter
    public static boolean hasLowerCase(String str) {
        String pattern = ".*[a-z].*";
        return str.matches(pattern);
    }

    // 5. Check if a string has at least one uppercase letter
    public static boolean hasUpperCase(String str) {
        String pattern = ".*[A-Z].*";
        return str.matches(pattern);
    }

    // 6. Check if a string is at least 8 characters long
    public static boolean isAtLeastEightDigits(String str) {
        String pattern = ".{8,}";
        return str.matches(pattern);
    }

    // 7. Check if all criteria are met for a password
    public static boolean isValidPassword(String password) {
        return hasUniqueCharacter(password) && hasNumber(password) && hasLetter(password) &&
                hasLowerCase(password) && hasUpperCase(password) && isAtLeastEightDigits(password);
    }

    
    
    // Check if a birth date is valid (not in the future and not too old)
    public static boolean isValidBirthDate(LocalDate birthDate) {
        if (birthDate == null) return false; 
        LocalDate currentDate = LocalDate.now();
        return !birthDate.isAfter(currentDate) && birthDate.getYear() >= 1900; // Assuming a reasonable lower limit for birth year
    }

    // Confirm age is at least 15 years
    public static boolean isAtLeastEighteenYearsOld(LocalDate birthDate) {
        if (birthDate == null) return false; 
        LocalDate currentDate = LocalDate.now();
        LocalDate yearAgo = currentDate.minusYears(18);
        return isValidBirthDate( birthDate) && !birthDate.isAfter(yearAgo);
    }

    // Confirm age is at least 20 years
    public static boolean isAtLeastTwentyYearsOld(LocalDate birthDate) {
        if (birthDate == null) return false; 
        LocalDate currentDate = LocalDate.now();
        LocalDate twentyYearsAgo = currentDate.minusYears(20);
        return isValidBirthDate( birthDate) && !birthDate.isAfter(twentyYearsAgo);
    }
    
    public static boolean upToYearsFutureDateValidation(LocalDate givenDate, int noOfYears) {
        LocalDate currentDate = LocalDate.now();
        LocalDate futureDate = currentDate.plusYears(noOfYears);
        return !givenDate.isBefore(currentDate) && !givenDate.isAfter(futureDate);
    }
    // Check if a given date is a future date up to the specified valid date
    public static boolean upToValidADateFutureDateValidation(LocalDate givenDate, LocalDate upToValidDate) {
        LocalDate currentDate = LocalDate.now();
        return !givenDate.isBefore(currentDate) && !givenDate.isAfter(upToValidDate);
    }
    
    
    
    // Check if a given date is a past date up to the specified valid date
    public static boolean pastDateValidation(LocalDate givenDate, LocalDate pastValidDate) {
        LocalDate currentDate = LocalDate.now();
        return !givenDate.isAfter(currentDate) && !givenDate.isBefore(pastValidDate);
    }
    
    public static boolean isValidJoiningDate(LocalDate joiningDate) {
        LocalDate currentDate = LocalDate.now();
        LocalDate upToValidDate = currentDate.plusYears(4); // Up to 4 years from the current date
        LocalDate pastValidDate = LocalDate.of(2021, 1, 1); // January 1, 2021
        return !joiningDate.isBefore(pastValidDate) && !joiningDate.isAfter(upToValidDate);
    }
    
    
    //////////////////////////////////////////////////////////////////////
    ////////////////// generate pass///////////////////
         
    public static String generatePassword() {
        String validChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()-_=+";
        Random random = new Random();

        StringBuilder password = new StringBuilder();

   
        while (true) {
            password.setLength(0); // Clear StringBuilder
 
            int length = random.nextInt(13) + 8;

         
            for (int i = 0; i < length; i++) {
                int randomIndex = random.nextInt(validChars.length());
                password.append(validChars.charAt(randomIndex));
            }

             if (isValidPassword(password.toString())) {
                break;  
            }
        }

        return password.toString();
    }
    
    public static String generateUsername() {
        StringBuilder usernameBuilder = new StringBuilder();

        Random random = new Random();

        // Ensure the username starts with a lowercase letter or underscore
        usernameBuilder.append(LOWERCASE_LETTERS.charAt(random.nextInt(LOWERCASE_LETTERS.length())));

        // Append lowercase letters, numbers, and underscores randomly
        String characters = LOWERCASE_LETTERS + NUMBERS + SPECIAL_CHARACTERS;
        for (int i = 1; i < 8; i++) { // 8 characters total
            usernameBuilder.append(characters.charAt(random.nextInt(characters.length())));
        }

        return usernameBuilder.toString();
    }

    
    
}