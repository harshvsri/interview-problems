package com.interview;

public class Berklays {
  public static void main(String[] args) {
    String str = "Hatbshshatcmvnkhati";
    String key = "hat";
    System.out.println(occurrence(str, key));

    char[] arr = {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0};
    System.out.println(decode(arr));
  }

  /* PROBLEM STATEMENT 1
  Martin is a commander in the army. An undercover agent shares some secret information with him. The secret information consists of a text and the name of a terrorist. 
  With the given information, Martin needs to find the number of terrorists who are going to attack the army base. 
  The agent gave Martin a hint that the number of terrorists is the number of times the terrorist's name occurs in the text. 
  Write an algorithm to help Martin find the number of terrorists who are going to attack the army base. */
  
  static int occurrence(String str, String key) {
    str = str.toLowerCase();
    int count = 0;
    int index = 0;
    while ((index = str.indexOf(key, index)) != -1) {
      count++;
      index += key.length();
    }
    return count;
  }

  /* PROBLEM STATEMENT 2
  A digital machine generates binary data consisting of a string of characters of 0s and 1s. 
  A maximum signal M in the data consists of the maximum number of either 1s or Os that appear consecutively in the data. 
  However, M cannot occur at the beginning or end of the string.) Design a way to find the length of the maximum signal. */
  
  static int decode(char[] arr) {
    int count = 0;
    int maxCount = 0;
    char start = arr[0];
    Character curr = null;
    for(int i=1; i<arr.length; i++) {
      if(curr == null && arr[i] != start) {
        curr = arr[i];
        count++;
      } else if(curr != null && arr[i] != curr) {
        maxCount = Math.max(maxCount, count);
        count = 1;
        curr = arr[i];
      } else if(curr != null && arr[i] == curr) count++;
    }
    return maxCount;
  }
}
