Basics:  &, |, ~, ^, <<, >>  
* Test kth bit: `s &= (1 << k);`
* Set kth bit: `s |= (1 << k);`
* Turn off kth bit: `s &= ~(1 << k);`
* Toggle kth bit: `s ^= (1 << k);`
* Intersection: `s & t;`
* Union: `s | t;`
* Set Subtraction: `s & ~t;`
* Extract lowest set bit: `s & (~s), s & ~(s - 1);`
* Extract lowest unset bit: `~s & (s + 1);`
* Remove last bit: `s & (s - 1);`
* Check is power of 2: `(s & (s - 1) == 0);`
* Swap value: `x ^= y; y ^= x; x ^= y;`
