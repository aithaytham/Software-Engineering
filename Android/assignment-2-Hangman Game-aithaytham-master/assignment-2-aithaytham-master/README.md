# Assignment 2: Hangman Game

The first assignment was all about getting to know some basic widgets
better. Now, this assignment will ask you to manipulate a bit more
Buttons and TextViews. This assignment will also be a **little bit** more
challenging because the logic is also more complex.

## Description of the App

In this assignment, you will mainly manipulate Buttons to implement the
Hangman Game. This game will proceed as follows:

1. When launched, the application will read a word in a static file (or
	 in a string-array). This will be the word to find.
2. At the start of the game, **no letter is shown**.
3. The player will have to press Buttons representing each letter in the
	 alphabet to guess the word. The player is allowed **10 wrong attempts**.
4. If the letter is present in the hidden word:
	1. Display **all occurrences** of this letter;
	2. The background color of the Button also turns to green;
    3. The Button is disabled (it is not clickable anymore).
5. If the letter is not present in the hidden word:
    1. The player lost a "life";
    2. The background color of the Button turns to red;
    3. The Button is disabled (it is not clickable anymore).
6. If the player finds the word before getting 10 wrong attempts,
	 display a message to congratulate him/her.
7. If the player gets 10 wrong attempts, the game is over.
8. After step 6 or 7, display a hidden Button to restart the game in the
	 same Activity.

You can base the design of your app on the figure displayed in the
lecture slides.

## Detailed specifications

The following points must be implemented in your app:

1. Your application must store a list of static words in either a file
	 or in the `res` folder;
2. Your application must **randomly** choose a word in this list;
3. Your application must display the number of wrong attempts left;
4. Your application must display **all occurrences** of a letter present
	 in the word;
5. The clicked Buttons must change background and be disabled to prevent
	 further unintentionnal clicks.
6. When a round is over, display a Button to restart the game with a new
	 word.

## Deadline for submission

Deadline: October 8, 2019 23:59.

Lateness policy applies if still available. Issues with configuring the
IDE or working with Git/GitHub will not warrant any deadline extension
anymore.
