# Flashcards

[JetBrains Academy](https://hyperskill.org) / Java Developer project.
[My profile -> Pozadr](https://hyperskill.org/profile/17362185 "Pozadr")

Source code: *JBA_Flashcards/Flashcards/task/src/flashcards/*

## Description
The program supports the following commands: actions:

* **add:** add a card
* **remove:** remove a card 
* **import:** load cards from file
* **export:** save cards to file
* **ask:** ask for definitions of some random cards
* **exit:** exit the program
* **log:** save the application log to the given file
* **hardest card:** print the term or terms that the user makes most mistakes with
* **reset stats:** erase the mistake count for all cards

Program can be run with command-line arguments:
* -import IMPORT is passed, where IMPORT is the path to file and file name.
* -export EXPORT is passed, where EXPORT is the path to file and file name.

##### Run arguments examples

    java Flashcards -import derivatives.txt
    java Flashcards -export animals.txt
    java Flashcards -import words13june.txt -export words14june.txt
    java Flashcards -export vocab.txt -import vocab.txt 

## Example

    Input the action (add, remove, import, export, ask, exit, log, hardest card, reset stats):
    > hardest card
    There are no cards with errors.
    
    Input the action (add, remove, import, export, ask, exit, log, hardest card, reset stats):
    > import
    File name:
    > capitals.txt
    28 cards have been loaded.
    
    Input the action (add, remove, import, export, ask, exit, log, hardest card, reset stats):
    > hardest card
    The hardest card is "France". You have 10 errors answering it.
    
    Input the action (add, remove, import, export, ask, exit, log, hardest card, reset stats):
    > ask
    How many times to ask?
    > 1
    Print the definition of "Russia":
    > Paris
    Wrong. The right answer is "Moscow", but your definition is correct for of "France" card.
    
    Input the action (add, remove, import, export, ask, exit, log, hardest card, reset stats):
    > hardest card
    The hardest cards are "Russia", "France". You have 10 errors answering them.
    
    Input the action (add, remove, import, export, ask, exit, log, hardest card, reset stats):
    > reset stats
    Card statistics have been reset.
    
    Input the action (add, remove, import, export, ask, exit, log, hardest card, reset stats):
    > hardest card
    There are no cards with errors.
    
    Input the action (add, remove, import, export, ask, exit, log, hardest card, reset stats):
    > log
    File name:
    > todayLog.txt
    The log has been saved.
    
    Input the action (add, remove, import, export, ask, exit, log, hardest card, reset stats):
    > exit
    Bye bye!

