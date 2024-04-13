/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.faysal.users;

import java.time.LocalDate;

/**
 *
 * @author Faysal Kabir Ashik
 */
public final class ValidationVerification {
    
    
    /// validation
    
    public static boolean allDigits(String str) 
    {
    String digitPattern = "\\d+";
    return str.matches(digitPattern);
    }
    
    public static boolean containsWhiteSpace(String str) 
    {
    return str.contains(" ");
    }
    
    public static boolean isValidUsername(String username) 
    {
    String pattern = "^[a-zA-Z_][a-zA-Z0-9_]*$";
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
    public static boolean isAtLeastFifteenYearsOld(LocalDate birthDate) {
        if (birthDate == null) return false; 
        LocalDate currentDate = LocalDate.now();
        LocalDate fifteenYearsAgo = currentDate.minusYears(15);
        return isValidBirthDate( birthDate) && !birthDate.isAfter(fifteenYearsAgo);
    }

    // Confirm age is at least 20 years
    public static boolean isAtLeastTwentyYearsOld(LocalDate birthDate) {
        if (birthDate == null) return false; 
        LocalDate currentDate = LocalDate.now();
        LocalDate twentyYearsAgo = currentDate.minusYears(20);
        return isValidBirthDate( birthDate) && !birthDate.isAfter(twentyYearsAgo);
    }

    // Check if a given date is a future date up to the specified valid date
    public static boolean futureDateValidation(LocalDate givenDate, LocalDate upToValidDate) {
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
        LocalDate upToValidDate = currentDate.plusYears(3); // Up to 3 years from the current date
        LocalDate pastValidDate = LocalDate.of(2021, 1, 1); // January 1, 2021
        return !joiningDate.isBefore(pastValidDate) && !joiningDate.isAfter(upToValidDate);
    }
    
    
    //////////////////////////////////////////////////////////////////////
    ////////////////// VERification///////////////////
         
    
}