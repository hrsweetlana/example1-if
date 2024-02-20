What was implemented.

Еhe cryptographic alphabet is based on uppercase and lowercase 
characters of the English alphabet and special characters '.', 
',', '«', '»', '"', '\'', ':', '!', '?', ' '.
The program can be run from the console by passing arguments.
Also the arguments can be passed through Command line interface.
If the path is wrong or even does not exist the error is thrown.
In case of option ENCRYPT/DECRYPT key is mandatory. Otherwise 
the error is thrown.
As a result of the program, a file with the same name as the input 
file, but marked _ENCRYPTED / _DECRYPTED/_BRUTE_FORCE appears in 
the folder with the initial file, depending on the operation performed.
 

What was not implemented.

Using brute force mode, a map is transferred to the program, in which 
the statistics of letter repetition are recorded in the specified 
reference map, the maximum value of repetitions of the symbol is searched 
and compared with the symbol that occurs most often in the encrypted text. 
Cyclic repetition for several key selection attempts is not implemented.


