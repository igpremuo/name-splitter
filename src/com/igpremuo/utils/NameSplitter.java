package com.igpremuo.utils; /**
 * Author: Ignacio Pérez
 * 
 * igpremuo@inf.upv.es 2014
 */

/**
 * Utility to split names.
 * Designed for Spanish names, but extensible to others.
 * Can be used as instantiated class or as a static class.
 */
public class NameSplitter {
	
	public final static int FIRST_NAME 	= 0;
	public final static int MIDDLE_NAME = 1;
	public final static int LAST_NAME 	= 2;
	
	private final static String[] CONECTORS = {"de", "del", "los", "la" , "i" , "santa"};
	
	private String mCompleteName;
	private String mFirstName;
	private String mMiddleName;
	private String mLastName;
	
	/**
	 * Class constructor
	 * @param completeName complete name of the subject
	 */
	public NameSplitter(String completeName) {
		mCompleteName = completeName;
		String[] splittedName = split(mCompleteName);
		mFirstName 	= splittedName[FIRST_NAME];
		mMiddleName = splittedName[MIDDLE_NAME];
		mLastName 	= splittedName[LAST_NAME];
	}
	
	public String getCompleteName() {
		return mCompleteName;
	}

	public void setCompleteName(String completeName) {
		mCompleteName = completeName;
	}

	public String getFirstName() {
		return mFirstName;
	}

	public void setFirstName(String firstName) {
		mFirstName = firstName;
	}
	
	public String getMiddleName() {
		return mMiddleName;
	}

	public void setMiddleName(String middleName) {
		mMiddleName = middleName;
	}
	
	public String getLastName() {
		return mLastName;
	}

	public void setLastName(String lastName) {
		mLastName = lastName;
	}

	/**
	 * Split the given name and return a string array with the names
	 * @param completeName complete name in a single string
	 * @return string array
	 */
	public static String[] split(String completeName) {
		// Pre-process of the name
		String name = completeName;
		name = name.trim();
		name = name.toLowerCase();
		name = name.replace("  ", " ");
		// Split name by spaces
		String[] splittedName = name.split(" ");
		// Initialize flags array
		int[] nameFlags = new int[splittedName.length];
		// Find solution
		return split(splittedName, nameFlags, 0, FIRST_NAME);
	}
	
	/**
	 * Recursive function to do backtracking
	 * @param splittedName name splitted by spaces
	 * @param nameFlags aux flags
	 * @param pos
	 * @param nameFlag
	 * @return splitted name in string array
	 */
	private static String[] split(String[] splittedName, int[] nameFlags, int pos, int nameFlag) {
		// Initialize variables
		int pivot = nameFlag;
		boolean flag = false;
		nameFlag = nameFlags[pos];
		// Check all words in the array
		for (int i = pos; i < nameFlags.length; i++) {
			nameFlags[i] = pivot;
			// Check names connectors
			if (contains(splittedName[i], CONECTORS)) {
				flag = true;
			} else if (pivot <= LAST_NAME) {
				flag = false;
			}
			if (!flag) pivot += 1;
			// Check if have to do backtracking
			if (pivot > LAST_NAME && !flag && i < nameFlags.length - 1) {
				return split(splittedName, nameFlags, pos+1, nameFlag);
			}			
		}
		
		// Get name in string array form
		String[] result = new String[3];
		String capitalized;
		for (int i = 0; i < splittedName.length; i++) {
			if (result[nameFlags[i]] == null) result[nameFlags[i]] = "";
			capitalized = splittedName[i];
			if (capitalized != null && capitalized.length() > 1)
				capitalized = Character.toUpperCase(capitalized.charAt(0)) + capitalized.substring(1);
			result[nameFlags[i]] += capitalized  + " ";
		}
		
		return result;
	}
	
	/**
	 * Check if the word is contained in the elements array
	 * @param word
	 * @param elements
	 * @return boolean
	 */
	private static boolean contains(String word, String[] elements) {
		for (String element : elements) {
			if (word.equals(element)) return true;
		}
		return false;
	}
}
