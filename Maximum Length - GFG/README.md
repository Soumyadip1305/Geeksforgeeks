# Maximum Length
## Medium
<div class="problems_problem_content__Xm_eO"><p><span style="font-size:13.5pt"><span style="font-family:Arial"><span style="color: rgb(0, 0, 0); --darkreader-inline-color:#e8e6e3;" data-darkreader-inline-color="">Given the maximum occurrences of a, b, and c in a string. Your task is to make the largest length string containing only a, b, and c such that no three consecutive characters are the same. Return the longest possible string length.</span></span></span></p>

<p><strong><span style="font-size:13.5pt"><span style="font-family:Arial"><span style="color: rgb(0, 0, 0); --darkreader-inline-color:#e8e6e3;" data-darkreader-inline-color="">Example 1:</span></span></span></strong></p>

<pre><span style="font-size:13.5pt"><span style="font-family:Arial"><span style="color: rgb(0, 0, 0); --darkreader-inline-color:#e8e6e3;" data-darkreader-inline-color=""><strong>Input</strong></span></span></span><span style="font-size:13.5pt"><span style="font-family:Arial"><span style="color: rgb(0, 0, 0); --darkreader-inline-color:#e8e6e3;" data-darkreader-inline-color="">:</span></span></span><span style="font-size:13.5pt"><span style="font-family:Arial"><span style="color: rgb(0, 0, 0); --darkreader-inline-color:#e8e6e3;" data-darkreader-inline-color="">
a = 3, b = 3, c = 3</span></span></span><span style="font-size:13.5pt"><span style="font-family:Arial"><span style="color: rgb(0, 0, 0); --darkreader-inline-color:#e8e6e3;" data-darkreader-inline-color=""><strong>
Output:</strong></span></span></span><span style="font-size:13.5pt"><span style="font-family:Arial"><span style="color: rgb(0, 0, 0); --darkreader-inline-color:#e8e6e3;" data-darkreader-inline-color=""> </span></span></span><span style="font-size:13.5pt"><span style="font-family:Arial"><span style="color: rgb(0, 0, 0); --darkreader-inline-color:#e8e6e3;" data-darkreader-inline-color="">
9</span></span></span><span style="font-size:13.5pt"><span style="font-family:Arial"><span style="color: rgb(0, 0, 0); --darkreader-inline-color:#e8e6e3;" data-darkreader-inline-color=""><strong>
Explanation</strong></span></span></span><span style="font-size:13.5pt"><span style="font-family:Arial"><span style="color: rgb(0, 0, 0); --darkreader-inline-color:#e8e6e3;" data-darkreader-inline-color="">: </span></span></span><span style="font-size:13.5pt"><span style="font-family:Arial"><span style="color: rgb(0, 0, 0); --darkreader-inline-color:#e8e6e3;" data-darkreader-inline-color="">
No three consecutive character of</span></span></span><span style="font-size:13.5pt"><span style="font-family:Arial"><span style="color: rgb(0, 0, 0); --darkreader-inline-color:#e8e6e3;" data-darkreader-inline-color="">
the string "abcabcabc" is same.</span></span></span></pre>

<p><span style="font-size:13.5pt"><span style="font-family:Arial"><span style="color: rgb(0, 0, 0); --darkreader-inline-color:#e8e6e3;" data-darkreader-inline-color=""><strong>Example 2:</strong></span></span></span></p>

<pre><span style="font-size:13.5pt"><span style="font-family:Arial"><span style="color: rgb(0, 0, 0); --darkreader-inline-color:#e8e6e3;" data-darkreader-inline-color=""><strong>Input:</strong></span></span></span><span style="font-size:13.5pt"><span style="font-family:Arial"><span style="color: rgb(0, 0, 0); --darkreader-inline-color:#e8e6e3;" data-darkreader-inline-color="">
a = 11, b = 2, c = 2</span></span></span><span style="font-size:13.5pt"><span style="font-family:Arial"><span style="color: rgb(0, 0, 0); --darkreader-inline-color:#e8e6e3;" data-darkreader-inline-color=""><strong>
Output: </strong></span></span></span><span style="font-size:13.5pt"><span style="font-family:Arial"><span style="color: rgb(0, 0, 0); --darkreader-inline-color:#e8e6e3;" data-darkreader-inline-color="">
-1</span></span></span><span style="font-size:13.5pt"><span style="font-family:Arial"><span style="color: rgb(0, 0, 0); --darkreader-inline-color:#e8e6e3;" data-darkreader-inline-color=""><strong>
Explanation</strong></span></span></span><span style="font-size:13.5pt"><span style="font-family:Arial"><span style="color: rgb(0, 0, 0); --darkreader-inline-color:#e8e6e3;" data-darkreader-inline-color="">: </span></span></span><span style="font-size:13.5pt"><span style="font-family:Arial"><span style="color: rgb(0, 0, 0); --darkreader-inline-color:#e8e6e3;" data-darkreader-inline-color="">
If we build a string of these character's,</span></span></span><span style="font-size:13.5pt"><span style="font-family:Arial"><span style="color: rgb(0, 0, 0); --darkreader-inline-color:#e8e6e3;" data-darkreader-inline-color="">
the string will be"aabaacaabaac<u><strong>aaa</strong></u>", here
we can see that there will be three consecutive <strong>a</strong>. So
there </span></span></span><span style="font-size:13.5pt"><span style="font-family:Arial"><span style="color: rgb(0, 0, 0); --darkreader-inline-color:#e8e6e3;" data-darkreader-inline-color="">is no solution exist.</span></span></span></pre>

<p><span style="font-size:13.5pt"><span style="font-family:Arial"><span style="color: rgb(0, 0, 0); --darkreader-inline-color:#e8e6e3;" data-darkreader-inline-color=""><strong>Your Task:&nbsp;&nbsp;</strong></span></span></span><br>
<span style="font-size:13.5pt"><span style="font-family:Arial"><span style="color: rgb(0, 0, 0); --darkreader-inline-color:#e8e6e3;" data-darkreader-inline-color="">You don't need to read input or print anything. Your task is to complete the function </span></span></span><span style="font-size:13.5pt"><span style="font-family:Arial"><span style="color: rgb(0, 0, 0); --darkreader-inline-color:#e8e6e3;" data-darkreader-inline-color=""><strong>solve( )</strong></span></span></span><span style="font-size:13.5pt"><span style="font-family:Arial"><span style="color: rgb(0, 0, 0); --darkreader-inline-color:#e8e6e3;" data-darkreader-inline-color=""> which takes </span></span></span><span style="font-size:13.5pt"><span style="font-family:Arial"><span style="color: rgb(0, 0, 0); --darkreader-inline-color:#e8e6e3;" data-darkreader-inline-color=""><strong>integers a, b, and c</strong></span></span></span><span style="font-size:13.5pt"><span style="font-family:Arial"><span style="color: rgb(0, 0, 0); --darkreader-inline-color:#e8e6e3;" data-darkreader-inline-color=""> as input parameters and returns the longest possible string length. If there is no possible answer return -1.</span></span></span></p>

<p><span style="font-size:13.5pt"><span style="font-family:Arial"><span style="color: rgb(0, 0, 0); --darkreader-inline-color:#e8e6e3;" data-darkreader-inline-color=""><strong>Expected Time Complexity:</strong></span></span></span><span style="font-size:13.5pt"><span style="font-family:Arial"><span style="color: rgb(0, 0, 0); --darkreader-inline-color:#e8e6e3;" data-darkreader-inline-color=""> O(a+b+c)</span></span></span><br>
<span style="font-size:13.5pt"><span style="font-family:Arial"><span style="color: rgb(0, 0, 0); --darkreader-inline-color:#e8e6e3;" data-darkreader-inline-color=""><strong>Expected Auxiliary Space:</strong></span></span></span><span style="font-size:13.5pt"><span style="font-family:Arial"><span style="color: rgb(0, 0, 0); --darkreader-inline-color:#e8e6e3;" data-darkreader-inline-color=""> O(1)</span></span></span></p>

<p><span style="font-size:13.5pt"><span style="font-family:Arial"><span style="color: rgb(0, 0, 0); --darkreader-inline-color:#e8e6e3;" data-darkreader-inline-color=""><strong>Constraints:</strong></span></span></span><br>
<span style="font-size:13.5pt"><span style="font-family:Arial"><span style="color: rgb(0, 0, 0); --darkreader-inline-color:#e8e6e3;" data-darkreader-inline-color="">0 ≤ a, b, c ≤ 10</span></span></span><span style="font-size:13.5pt"><span style="font-family:Arial"><span style="color: rgb(0, 0, 0); --darkreader-inline-color:#e8e6e3;" data-darkreader-inline-color=""><sup>5</sup></span></span></span><br>
<span style="font-size:13.5pt"><span style="font-family:Arial"><span style="color: rgb(0, 0, 0); --darkreader-inline-color:#e8e6e3;" data-darkreader-inline-color="">0 &lt; (a + b + c)&nbsp;</span></span></span></p>
</div>