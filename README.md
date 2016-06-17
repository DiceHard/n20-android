# n20-android
Natural20 Android Application

The purpose is to create a platform for playing table-top RPGs 
that is useful and enjoyable. 
Didn't bring your dice with you? Got a phone? You can play!

It also tracks rolls to try to suss out what causes someone to roll 
consistent statisically improbable results. Wil Wheaton, for example,
rolled an average of 6 on a 20-sided die during a session of Critical Role

The app will let you know what is real, what is just your mind playing 
tricks on you, and what strange things correlate to good rolls. If there is
some invisible demon making you roll poorly, big data will expose him. 
(And hopefully, he chooses to wear pants when it does.)

=======================================================================

System Architecture:

Android App <=====\\         //=====> SQL DB  
                   \\       //
iOS App <===========>> API <<
	           	     //       \\
Web App <=========// 	       \\=====> Analytics

========================================================================

Build Priorities:
1. Android App
	-All of the business logic, Physics Engine, UI, 
	 and other useful/satisfying features will happen client side.

2. DB, API and Analytics
	-Purely so that we have a complete running system 
	 before we start conquering new lands. 

3. Port Android to Web & iOS
	-Once a working prototype is made in android,
	 a port to Browser, iOS, and maybe MS is we're feeling it.
	-The web app might be a good place to introduce more DM features.

=========================================================================

App stories: (VERY Mutable)
		One thing at a time, 
		maybe not all of this gets built, 
		maybe some of this is for another app.

1. As a player, I would like to shake my phone to roll a d20
	-Bonus if it makes a satisfying noise to go with the result.
	-Bonus if it vibrates for same purpose.

2. As a player I would like to be able to have my d20 act as an object.
	-I can "train" it (choose which starting side is up)
	-I can get new dice with different looks and physical properties
	-I can place my dice in a "dice jail" for rolling poorly

3. As a player I would like to roll x dice with x sides.
	-I want to be able to roll 10 d6 all at once.
	-I want to roll any legal and necessary dice for play

4. As a player I would like to be able to make special rolls
	-where you ignore lower or higher values.
	-where the roll is added to the last roll
	-where the roll is digit based, such as percent die.

5. As a player I would like to let the app know special additional info
	-Have a 1-10 scale of 'how important the results of this roll are'
	-default 5.
	-0 means they are not at all meaningful, 
	 just rolling dice for no purpose (not pushed to DB)
	-Be able to input random things I have done 
	 that may influence the roll. (works like hashtags)

6. As a player I would like to be able to review my dice rolls 
	to see how I'm doing.
	-Access the rolls and see some fun charts about them

7. As a player I'd like to compare my rolls to others
	-Access the larger DB and compare your numbers to everyone's
	-See what trends people do are helping/harming.

8. As a player I'd like to create and/or shop for new dice.

9. As a player I'd like to have my dice rolls build a character sheet 
	which is sharable and updates automatically.

10. As a player I would like my app to interface with friends.
	-Where dice I have can be borrowed or given away
	-Where roll results are shared across devices

11. As a DM, I would like to have access to my player's rolls 
	and character sheets
	-Where I can start a session that others can join via bluetooth 
	 like an old warcraft LAN party.
	-Where I can have remote players join the game.
	-Where I can assign damage, modifiers, and xp in-app.
	-Where I can manage battles and ongoing effects.
	-Where I can display a r/t battle map on my player's devices,
	 which they can change and interact with as well.
