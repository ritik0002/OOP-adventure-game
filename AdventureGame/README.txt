Student name:Ritik Desai
Student number:200205418

Please complete this README file for your level 3 mini-project submission.

If your level 1/2 submission did not get full marks you MUST complete the second part of this template describing how and where your have improved your code so that it now meets the level 1 and 2 requirements. If your code still does not meet level 1 and 2 requirements then you will get 0 for level 3.

LEVEL THREE
*To note I have already Passed level 1 & 2 thus removing them from this readme file*

GUI
[(All the code takes place in the AdventureGame class) At the start of my program The user presses the start button and gets to the main game then must enter there name(inside a textField and has to press a button then stores the name (lines=90-109 (shows the display and actions taken at lines=201-211) Then the user gets to battle zombies and gets 5 options to fight,rest,use ultimate,display stats, or quit and set a checkpoint- when the user chooses to fight it displays the outcome to the textarea(and other stuff like how much damage taken etc),stats show current health,strength speed,ultimate status, and ultimate is used to use ultimate to gain health,strength,speed and resting gains some health and attack and which all is displayed to the screen. One last thing when the user gains a certain powerup it has a activate powerup button which is a 1 time use and gains health from it and can use it when the enemy attacks (line numbers:223-226,228-311 for the response)]


Exceptions

[I've used exception handling a few times but 1 example would be in the AdventureGame class at line number:373-382]
[Exception Handling is nessecary as it helps check for errors and maintain the normal flow of the code like when reading a file which causes a IOexception,exception handling is required because you have to handle errors and make sure the code works]

Collections

[I use Several Arraylists in my program which i use in the class AdventureGame at lines:47-53,54-56,230,330 (the wave class also implements some of the arraylist functions which is used at some of theses linenumbers)]

[ArrayLists are dyanamic sized whilst arrays are fixed sized this means once you give the size to an array it won't be able to grow,This is advantagous to use arraylist as like in my game i use arraylist to add more Zombies if the user gets a certain powerup it would be much harder to do with using a single array Alongside this arraylist comes with alot of other inbulit methods like .clear (which i have also used) which sets the whole arraylist elements to null and arraylist are generic types which ensure type saftey so problems are easier found.]

File I/O

[I use file input output i use it as a "save/checkpoint" feature in my game so the  I save ALL there stats like strength,health,name etc inwhich that is what it is set at when they come back and the user can come back reenter their name and they will go back to the wave they are at/set a checkpoint at. The line numbers i use file input output and the respected code and methods for them is in the class AdventureGame at lines:122-143,308,372-382,383-400 ]

'Something impressive'

[I have used multiple things like i've delved into looking at the Swing graphics and used that at the start to create my start screen and used it to draw different shapes (lines:72-89), i also looked a bit more into the Collections utility class and used it to shuffle my Arraylist (This helps to add a bit more randomness to my game at line:233, finally i also looked into threads and understand some parts of it like what threading is used for in java (threads are used to allow multiple proccesses to take place at the same time) but i've only used it at the most basic level to set a delay when ending my program so the user can see the final messages at lines:216-220]






