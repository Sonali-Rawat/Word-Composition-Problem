# Word-Composition-Problem



Step 1: Reading Words from File
The program reads the words from a text file using the readWordsFromFile method. This method reads each line from the file, trims any leading or trailing whitespace, and adds the word to a list.

Step 2: Finding the Longest Compound Words
The findLongestCompoundWords method is used to identify the longest and second longest compound words. 

Convert List to Set: The list of words is converted to a HashSet for O(1) lookup times.

Sort Words by Length: The words are sorted in descending order based on their lengths.

Check Compound Words

Add Word Back: After checking, the word is added back to the set.

Step 3: Checking if a Word Can Be Formed
The canFormWord method uses dynamic programming to determine if a word can be formed by concatenating other words in the set. 