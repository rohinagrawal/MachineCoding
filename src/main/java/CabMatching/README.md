#Problem
##Description 
A cab company has the list of cab rides after it gets completed. After the journey both cab driver and ride taker provide rating to each other. Rating can be from 1 to 5 where 5 is the best rating and 1 being the worst. 

Given a Ride taker name, find the eligible cab drivers for him based on the historical data that is being given to you. The criteria's are given below to choose the eligible cab drivers - 

1. Avg rating of Cab driver should be Greater than average rating of ride taker (Choose with the highest rating) 
2. If no cab driver is found to consider the best of all of them 
3. If any cab driver has provided 1 rating to a ride taker or vice versa then they are not allowed to do a ride together. 

###Input 
Ride data is given (Ride Taker Name Rating given to Ride Taker . Driver Name. Rating given to driver)

Ride 1 - (Ram, 3, Bheem, 5)  
Ride 2 - (Laxman, 5, Nakul, 2)  
Ride 3 - (Ram, 4, Sahadev, 2)  
Ride 4 - (Bharat, 3, Bheem, 5)  
Ride 5 - (Ram, 3, Bheem, 1)  
Ride 6 - (Laxman, 5, Sahadev, 3)  
Ride 7 - (Bharat, 5, Nakul, 5)  

Q. Find eligible driver for  
    1. Ram  
    2. Laxman  

A.  1. Nakul  
    2. Bheem