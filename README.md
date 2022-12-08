# About:
In this repository, I record my accepted solutions to LeetCode problems.
I am doing LeetCode problems because my Data Structure and Algorithm course is theoretical in nature. Coding problems are a good way for me to practice using DS & A concepts and figure out what I don't understand.
->some background: I was in CSE247R, a coding seminar class paired with CSE 247 (Data Structures and Algorithms). Every Sunday in the Fall 2022 semester, I work with my partner Luis on coding questions for two hours. 
Taking the class made me realize that filling in given framework, which is the computer scienc homework I am used to working on, is very different from writing up code from scratch! We found that they come from LeetCode, so I decided to learn more actively by finding DS & A problems there!

# Files (updating):
1. TwoSum_v1.java

(Nov 24, 2022) A brute force solution to Two Sum (question 1). I compare the sum all combination of two numbers from the given list against the desired sum.
https://leetcode.com/problems/two-sum/description/

2. (2)AddTwoNums_v1.java

(Nov 24, 2022) Instead of converting given numbers, which are in the forms of lists of digits, into numbers in the decimal form, I perform addition operation with carryover directly.
https://leetcode.com/problems/add-two-numbers/

3. (3)maxSubStringNoRpt.java

(Nov 25 2022) I use the property of sets to ensure that in each version of my current longest substring, there are no repeating characters.
https://leetcode.com/problems/longest-substring-without-repeating-characters/

4. (4)medianSortedArrs.java

(Nov 27, 2022) The most important part was recognizing the relationship between the segmentation of two given array and segmentation of the (imaginary) combined array, from which the median is found.
https://leetcode.com/problems/median-of-two-sorted-arrays/description/

5. (5)maxPandrolim.java

(Nov 27, 2022) I detected pandrolims from their 'median' element, where the mirroring of characters start. The two ways to start a pandrolim are: odd number of median characters (bAAAb) versus even number (bAAb).
https://leetcode.com/problems/longest-palindromic-substring/

6. (11)maxArea.java

(Nov 27, 2022) The most important idea is to use two pointers, starting from either end of the given array.
https://leetcode.com/problems/container-with-most-water/

7. (15)SumThree.java

(Nov 29, 2022) The brute force method (iterating through array three times, resulting in n^3 time complexity) did not work because some test cases are huge. 
By observing solutions, I notice that only two iterations over the entire array is needed (time complexity was n^2). 
So I look for ways to avoid a third iteration. I found that it can be done using using a set containing all uniqe numbers in the given array (comparison is constant-time), resulting in n^2 time complexity.
However, n^2 still results in time-outs. This was caused by arrays containing a few unique numbers that are being repeated many times. To detect this edge case, I use the aforementioned set so that my main loop avoid going over different entries in the given array that have the same value. This avoided time-outs without reducing time complexity.
https://leetcode.com/problems/3sum/

8. (18)letterComb.java

(Nov 29, 2022) I used a brute force method, since the question stated a small number of cases I can capture iteratively. 
However, by reading the solution, I found that this can be done using back-tracking. This is a concept I am not familiar with, so I am working on it now.
https://leetcode.com/problems/letter-combinations-of-a-phone-number/

