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

9. (19)rmNthNodeList.java

(Dec 08, 2022) I used a brute force method. I iterate through the list once to get its length. Next, I use length to calculate the index of what I want to remove. In practice, this is the node BEFORE what I want to remove, since I 'remove' a node from list by changing .next connections of the parent.
NOTE: list is accessed from head. If I operate on head directly e.g. iterate, that changes the list when I return head.
To edit list, clone the head node and use that (and that.next) to make changes.
https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/

10. (20)validParenthesis.java

(Dec 08, 2022) Most important idea is to use stack. Reason for stack: when we got LHS parenthesis, entire list of parenthesis is fine ONLY IF we got a RHS parenthesis to pair. But, between parenthesis, there is variable amount of other parenthesis. Since earlier parenthesis MUST either ENTIRELY INCLUDE or NOT OVERLAP with later parenthesis (i.e. [{]} NOT ok; BUT: []{} ok AND [{}] ok). 
TLDR: valid parenthesis strings are (locally) symmetric. It's NOT globally symmetric, so we cannot use array/index method easily.
How to exploit local symmetry: 
suppose parenthesis pairs A and B form continous part of given string such that B is INSIDE A. If B is valid, NO need to check B. ONLY need to check A. -> OK to ditch B when checked. -> if B NOT valid, entire string of parenthesis is invalid
Also, we know that local symmetry violators == parenthesis part that do NOT have pair
TLDR: we are finding parenthesis pairs. When some pair P is clear, P can be removed (since it's Not going to be local sym violator)
So we use stack: ONLY pop IF: current peak() result is LHS parenthesis, current character in given array is the RHS parenthesis (of That LHS parenthesis).
If we got a violator, it's going to get left be hand (Not-cancelled-out) After we went through eveyrthing in the list.
https://leetcode.com/problems/valid-parentheses/description/

11. Merge 2 sorted lists

(Jan 11, 2022) For list1 = {A, B, C, D}, list1 = A (ref to list == head node of list). A.next = B.
If u do list1 = list1.next, list1 is now {B, C, D}
Recursion: make NEW list to return (rather than messing w/ input lists).
  next, take smaller head node of two lists = head of new list to be return
Iterative, use Recursion steps iteratively, BUT, u need MANUAL Head & Tail nodes
  Manual head: empty node, where empty.next = ur entire list. Keep empty node, bc you NO wanna move it around!
  Manual tail: Initially, equal to head. You add stuff to tail.next. When u do, MOVE tail, using tail = tail.next
Iterative better, because less memory used.
https://leetcode.com/problems/merge-two-sorted-lists/description/

12. enumerate Valid parenthesis combo, given pair count

(Jan 11, 2022) use Backtracking (which uses Recursion)
TLDR: build Valid parenthesis, add em to list of Valid enumeration
STOP condition: entry length at max (entry length = pair count * 2)
Add condition: 
  1) add Left parenthesis if total Left parenthesis within limit (aka pair count)
  2) add Right parenthesis if total right parenthesis within limit (aka Left parenthesis count, bc more right than left == NO Valid)
https://leetcode.com/problems/generate-parentheses/description/

13. merge K sorted lists

from 11., we know how to merge 2 sorted lists. So we can use divide-n'-conquer method
  tldr: repeatedy divide lists into groups of 2, then merge
  Note: it's OK if k != n^2. If we end up w/ 1 list, tis exactly what we want. If we end up w/ 2 lists, it reduces to 1 list aka Still what we want
  to Divide, use variable Batchsize, starting at 1. Given list 'lists', containing lists we wanna merge, when we merge lists[1] and lists[2], we store result in lists[1] BUT we do NOT delete what's in lists[2] BUT we do NOT want to Reuse that lists[2]
   TLDR, using BatchSize, we skip over what we do NOT want
  use loop A to manage BatchSize, increasing by factor of 2
  use loop B, inside loop A, to manage PAIRS of lists we wanna merge
  e.g. first round, we merge (index) 0-1, 2-3, 4-5, 6-7 <-Note: how we need to increment loop B index by i += BatchSize * 2, so we do NOT get 0-1 And Then 1-2!
  second round, we be mergine 0-2, 4-6, 8-10 SKIPping over lists indexed at 1, 3, 5 ect. bc we Already used them for merging
https://leetcode.com/problems/merge-k-sorted-lists/description/

14. swap every 2 nodes of list

Iterative method, use MANUAL Tail for the SWAPped section of the list, so we can put crosshair on the pair we going to swap
  here, manual tail == node B4 the pair of nodes we gonna Swap
  use head to move stuff forward
  use empty node First to access entire lists (for return)
  after swapping a pair, connect New head to the Manual Tail 
https://leetcode.com/problems/swap-nodes-in-pairs/description/

15. swap groups of K nodes, repeat for a list

(I think) this means for K = 4, you want ABCDE -> [ABCD]E -> [DCBA]E -> DCBAE
https://leetcode.com/problems/reverse-nodes-in-k-group/description/

16. next larger permutation, by lexicographical order

next = immediate e.g. next larger than X = smallest possible, that's larger than X
lexicographical order = size difference, when u turn string no #s to actual no. e.g., 1, 3, 2 > 1, 2, 3, by lexicographical number, because 132 > 123 (it's THAT simple...)
https://leetcode.com/problems/next-permutation/description

17. max valid parenthesis string

TLDR: count no.left & no.right parenthesis. AND: check from BOTH Forward & Backward directions, choose max result;
->Fwd direction MISS ((() case; whereas Bwd direction MISS ()))) case!
Record length condition: left = right (no. of brackets, by types left & right)
Start NEW record condition: right > left (this is in FWD case; opposite condition for Bwd case!), cus for Fwd dir, if you got Total 1x ( and 2x )) at ANY point, its NOT possible to have valid parenthesis string!
https://leetcode.com/problems/longest-valid-parentheses/description

18. search, Sorted array is Rotated

rotated = entries shifted by some element. BUT, here we DON'T know how many entries array is shifted by
Fastest search in Sorted arr is binary. BUT, only PART of shifted sorted array is sorted
TLDR: BS BUT, change conditions to find SORTed part of array if possible
  so instead of doing 'target vs mid entry', we do 'start entry vs mid entry', to determine which part of array is shifted
  e.g., if arr is skewed to LHS, we got mid entry > left entry, bc mid entry is within the Sorted part (in this case, equivalent to half, bc Binary Search) of the shifted arr; opposite for skewed to RHS
  for LHS skewed arr, if target e [start entry, mid entry], we go for that part. if not, that's alright, we go for the UN sorted part of the array
Doing regular Binary Search conditions NO work, cuz it assumes array is sorted aka SKIPs over nums we wanna look at, due array being Only PARTly sorted (due to rotation aka shifting)
https://leetcode.com/problems/search-in-rotated-sorted-array/description

19. search, Sorted array, index range for Repeated targets

TLDR: augmented Binary Search
  1 git ur nums[mid] == target
  2 git LHS & RHS bound for Repeated target values, SEPARATELY
  for LHS, if nums[mid - 1] ALSO == target, mid NOT LHS bound; ALSO, if mid = start i.e. mid = start = end i.e. target repeats x1 Only, or repeate start from LHS of Entire array; If these conditions NO met, do ed = mid - 1, so we ONLY go LHS (cuz we looking for LHS bound here!)
  for RHS, do opposite day.
https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description

20. search, Sorted array, index to insert Target (position, if present; position by sort, if NO present)

TLDR: augmented Binary Search
  for NO found, return LHS. for nums.length = l
  1 if target > max entry, ur LAST state is: mid = st = ed = l - 1; u do st = mid + 1 = l + 1, and loop terminates. l + 1 is position to insert target
  2 if target < min entry, ur LAST state is: mid = st = ed = 0; ur do ed = mid - 1 = -1, and loop terminates; st is STILL @ 0, which is position to insert target
  3 if target's correct position is btwn two entries, LAST state is mid = st = ed = (dat correct position - 1).
  (I think that) Binary Search ends @ MAX entry in array that's <= target; so in case 3, u get st = mid + 1 = dat correct position
https://leetcode.com/problems/search-insert-position/description

ex. (217) combination of n numbers, sums to k. using numbers 0 ~ 9

TLDR: backtrack, cuz: we looking for ALL combinations
Backtrack method: use Remain, initialize to k; When add #, do Remain - #; use Next to keep track of next # to add to combination (on same STEP)
  to avoid repeat # in ea combination, choos （next + 1） from list
  ea time we incl. number A, do backtrack(remain - A, next = A). <-we did (next + 1) instead of just next, so in this next recursion, we get OTR number B
  e.g. first, we trying out #A_ (_being empty aka no # there yet!), recursion takes us to #AB (For loop Starts from next + 1, so ONLY can choose B, NO can choose A!) <- make sure we try out ALL vals at SAME position of combination
  Use for loop to try out All 0~9 for combination
  BUT, do entry.removeLast() to remove A After calling recursion (so that u free up space for B, in A's current position! i.e. trying out #B_ now!)
https://leetcode.com/problems/combination-sum-iii/description
  
21. combination using numbers in given array, allow repeats, sums to k
  
TLDR: backtrack, since this is combination problem
Backtrack method: use Remain to keep track of sum
  The drill: add A to entry, backtrack(), entry.removeLast()
  (compare to ex 217 above:) we NO doing i+1 WITHIN for loop (NOT talking bout i++ in the loop frame!), cuz its OK we got repeat no.s, we want recursion call to start AT current no. in array. 
  BUT, once we done w/ combination starting w/ A, we NO use A again! e.g. exhausted All combos that's A###, when we doing B###, those #s NO can be A! (otherwise, we     get repeated combos aka repeat results aka WRONG)
https://leetcode.com/problems/combination-sum/description/
