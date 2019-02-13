### Principle of Recursion
Recursion is an approach to solving problems using a function that calls itself as a subroutine.  
A recursive function should have the following properties so that it does not result in an infinite loop:  
1. A simple base case (or cases) — a terminating scenario that does not use recursion to produce an answer.
2. A set of rules, also known as recurrence relation that reduces all other cases towards the base case.

### Recurrence Relation
There are two important things that one needs to figure out before implementing a recursive function:  
1. recurrence relation: the relationship between the result of a problem and the result of its subproblems.
2. base case: the case where one can compute the answer directly without any further recursion calls. Sometimes, the base cases are also called bottom cases, since they are often the cases where the problem has been reduced to the minimal scale, i.e. the bottom, if we consider that dividing the problem into subproblems is in a top-down manner.

### Memorization

### Complexity Analysis
