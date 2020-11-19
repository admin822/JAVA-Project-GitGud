   
   In order to make a functional hashtable, we need to solve two problemes:  

   1. how to make **a hash function** that can assign a fixed length address for any input.
   2. if the hash function fails to give a unique address , then there will be a address conflict, **how to solve the address conflict**

The implementation of hashtable under the same directory of this writeup choose to use : （1） modulo as hash function (2) linked list as conflict handling method.  

 