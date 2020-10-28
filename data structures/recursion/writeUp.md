1. Recursion will actually make a new space in the stack for each call to the recursion function, which means this could cost us a great deal of memory space.
2. local variable is independ for each call,they will not have an effect for another.
3. however, reference will be shared through the whole recursion process(Like an array.)
4. for the backTracking algorithm under this directory, we can change our strategy to find different path to the destination(currently the strategy is DOWN-RIGHT-UP-LEFT).