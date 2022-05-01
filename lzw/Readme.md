# Readme:

[TOC]



## About：

The Lempel–Ziv–Welch (LZW) algorithm is a lossless data compression algorithm. LZW is an adaptive compression algorithm that does not assume prior knowledge of the input data distribution. This algorithm works well when the input data is sufficiently large and there is redundancy in the data.

## How to use:

### LZW.java

#### Entropy：

To calculate the entropy of the input sequence, we use the entropy function in the LZW .java. The function takes the form of a hash table, so the input data is not limited to three characters in the ABC.

#### Output:

The compression encoding of characters is implemented using the output function in LZW .java files.

#### main:

The main function mainly contains the reading of characters, the invocation of function functions, and the final output

### Result.java

In this file, we define the four functions of Write Dictionary, Read Dictionary, Write Encoding, and Read Encoding for use in LZW .java

## result:

```JAVA
ABABAB
Sequence entropy: 1.0
Input sequence: ABABAB
Output sequence: 3 5 1 
Dictionary:
0 A
1 B
2 C
3 AB
4 BA
5 ABA
6 ABAB

```

