# Online Shopping Sample
An Android Application for online shopping sample

<img src="/assets/sample.gif" width="49%">

This project aims to show a shopping sample. It is written in Kotlin. 

Code Design and Architectural Solution

	The framework made for this challenge was initially made with the MVP pattern in mind. It also abides in CLEAN Architecture with SOLID principles (To meet up the universal rules requirements). I also took the liberty to imitate the current [**Dawanda Android Application on Playstore**](https://play.google.com/store/apps/details?id=com.dawanda.shopping).
	
Requirements Fullfilled:
	
	•	Target SDK - 25. Minimum SDK - 16
	•	Stage 1 
		- Displayed each item.
		- Displayed image
		- Used "image_url" with right aspect ratio
		- Has a progress bar and while loading the json object 
		- used Picasso Image Loader for all images in loading images asynchronously
		- used the received image as the image for the card itself
	•	Stage 2 
		- product item opened in a new screen
		- user can navigate back both on the back button or the arrow button
		- progress bar will appear again once the user taps, sliding to the left animation also appears for transation
	•	Stage 3
		- product details opened in a new screen
		- user can navigate back both on the back button or the arrow button
		- shown image, title, price, badge (left top triangular layout), seller name, shop name, and rating
		- app instance state safe

	•	Added Library
		- Although not a library itself, I've added some extension classes (AnimationExtension and UiUtils). Its some of the collaboration of my work together my previous colleagues to shorten layout creation.  

Improvements

		•	In my opinion, there can be a lot of ways to improve the current app right now. Although I haven't used thoroughly the app itself, below are some suggestions I just thought of. 
			- more targeted first screen products (if we know more about the user his age, location, life we can give more target products for him on the first page that he would most likely buy)
			- triangular badge on left top of the detailed page 
			- aggregated content blog (for marketing - once we know the data from our backend, we can create a blog out of it)
			- gamifying our users / partners (each user can improve their level depeding on how many items they already bought, if they buy more, they get to increase their level. Each level has a corresponding awards, abilities they can do)
		
	
