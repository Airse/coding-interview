# Fraudulent Activity Notifications

[Source](https://www.hackerrank.com/challenges/fraudulent-activity-notifications)

HackerLand National Bank has a simple policy for warning clients about possible fraudulent account activity. If the amount spent by a client on a particular day is greater than or equal to `2x` the client's median spending for the last `d` days, they send the client a notification about potential fraud. The bank doesn't send the client any notifications until they have at least `d` prior days of transaction data.

Given the value of `d` and a client's total daily expenditures for a period of `n` days, find and print the number of times the client will receive a notification over all `n` days.

Note: The median of a list of numbers can be found by arranging all the numbers from smallest to greatest. If there is an odd number of numbers, the middle one is picked. If there is an even number of numbers, median is then defined to be the average of the two middle values. 