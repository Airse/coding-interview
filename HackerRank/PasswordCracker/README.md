# Password Cracker

[Source](https://www.hackerrank.com/challenges/password-cracker)

There are N users registered on a website CuteKittens.com. Each of them have a unique password represented by pass[1], pass[2], ..., pass[N]. As this a very lovely site, many people want to access those awesomely cute pics of the kittens. But the adamant admin doesn't want this site to be available for general public. So only those people who have passwords can access it.

Yu being an awesome hacker finds a loophole in their password verification system. A string which is concatenation of one or more passwords, in any order, is also accepted by the password verification system. Any password can appear 0 or more times in that string. He has access to each of the N passwords, and also have a string loginAttempt, he has to tell whether this string be accepted by the password verification system of the website.

For example, if there are 3 users with password {"abra", "ka", "dabra"}, then some of the valid combinations are "abra" (pass[1]), "kaabra" (pass[2]+pass[1]), "kadabraka" (pass[2]+pass[3]+pass[2]), "kadabraabra" (pass[2]+pass[3]+pass[1]) and so on.

## Input Format

First line contains an integer T, the total number of test cases. Then T test cases follow. 
First line of each test case contains N, the number of users with passwords. Second line contains N space separated strings, pass[1] pass[2] ... pass[N], representing the passwords of each user. Third line contains a string, loginAttempt, for which Yu has to tell whether it will be accepted or not.)

## Output Format

For each valid string, Yu has to print the actual order of passwords, separated by space, whose concatenation results into loginAttempt. If there are multiple solutions, print any of them. If loginAttempt can't be accepted by the password verification system, then print WRONG PASSWORD.