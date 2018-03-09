# Guess a number multiple players multiple instances

<b>This game is developed using Java(JSP), javascript & jquery.</b>
It consists of a launcher page index.jsp(screenshot) where a player can guess a number from 1-10 and verify his guess.


<b>How to play:</b>

User has to guess a number from 1-10 correctly.

![alt text](https://github.com/sindhuvl/guess-a-number-multi-player/blob/master/Screenshots/GuessANumber.PNG)

Based on the guess, user will be shown a message "cold" when the guess is 3 or more away from the correct answer, "warm" when the guess is 2
away, and "hot" when the guess is 1 away.

![alt text](https://github.com/sindhuvl/guess-a-number-multi-player/blob/master/Screenshots/ColdGuess.PNG)

![alt text](https://github.com/sindhuvl/guess-a-number-multi-player/blob/master/Screenshots/WarmGuess.PNG)

![alt text](https://github.com/sindhuvl/guess-a-number-multi-player/blob/master/Screenshots/HotGuess.PNG)

Once the user guessed correctly or run out of the attempts(fails to guess), a new game is started. User can continue playing the game continously.

![alt text](https://github.com/sindhuvl/guess-a-number-multi-player/blob/master/Screenshots/CorrectGuess.PNG)

![alt text](https://github.com/sindhuvl/guess-a-number-multi-player/blob/master/Screenshots/FailGuess.PNG)

Incase of any invalid input i.e, guess below 1 & guess greater than 10, user will lose an attempt just like an incorrect guess.

![alt text](https://github.com/sindhuvl/guess-a-number-multi-player/blob/master/Screenshots/InvalidGuess.PNG)

If the user refreshes the page, a new game starts ie., existing state of game will be ignored.

Multiple users can play multiple instances of game parallely in different browsers/tabs.
