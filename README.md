![스마트IOT홈](https://user-images.githubusercontent.com/64193469/213203735-01aecc8f-3a37-40f5-a123-a8bd0e951d33.png)
![스마트IOT홈2-min](https://user-images.githubusercontent.com/64193469/213203519-ee822151-577b-4f9a-ae8f-f7da68980197.gif)
<img width="783" alt="스마트IOT홈3" src="https://user-images.githubusercontent.com/64193469/213203591-c6ea904f-1f73-4d68-8af6-e1416a9c5b32.PNG">
![스마트IOT홈4-min](https://user-images.githubusercontent.com/64193469/213203633-d5f34cf4-1f79-420c-8c5b-9b74acdeb316.gif)
![스마트IOT홈5](https://user-images.githubusercontent.com/64193469/213203657-2a1beefd-d01f-4aa4-aea1-112225c0a89c.png)


Author: AppForest.kr
Date: February 2021
Description: Smart home

(*This product has layout only, with only essential features added to operate the layout.*)

Rights: copyrighted templates and code. 
Some templates and code (Eg Graph,Animation) use the following APIs and libraries: *MPandido Chart Created by Philipp Jahoda* *Lottie Animation by Rishabh Goel* *AndroidSlidingUpPanel by umano*
​
Animation by Rishabh Goel on LottieFiles
Rishabh Goel on LottieFiles: https://lottiefiles.com/11808-electricity-loading

Bottom navigation drawer by umano/AndroidSlidingUpPanel: https://github.com/umano/AndroidSlidingUpPanel

You are licensed under Apache License Version 2.0 ("License"), and you cannot use this file except for license compliance. You can obtain a copy of the license.

http://www.apache.org/licenses/LICENSE-2.0

Copyright 2021 © AppForest.kr, Copyright 2020 Philippe Jahoda Philipp Jahoda

https;//AppForest.kr



#How to use
1. How to change the design
If you want to change the design, you can modify it by referring to the xml files in layout.

2. How to change the graph design
To customize the design of a graph
you can create your own custom in "DataFragment_month.java", "DataFragment_week.java", and "DataFragment_year.java".

3. How to change the data on a graph
To change the data on a graph
You can use the database to invoke it as a data function set in the activity.

4. How to change animation
You can easily change it from xml in the anim folder.
If you want to change to code, refer to the buttonAnimation function in "HomeFragmentation.java".

5. How to change the navigation bar design
You can change the color in color/bottom_navigation_colors.xml.
You can change the image in layout/activity_main.xml.
You can change the linked page in MainActivity.java.

6. How to change the bottom navigation drawer
You can change the drawer design in layout/fragment_stats.xml.
You can easily design by referring to the comment.
If you're not sure, refer to the link: https://github.com/umano/AndroidSlidingUpPanel



#control Detail Page
1. Home
This page is the main screen of this application.
You can add your furniture by clicking the add button and customize each furniture in the living room, kitchen, bedroom, bathroom, etc. using tab layout.
You can customize the setting according to the inhome, goingout, night, party, movie mode by pressing the mode button.
If you want to change the design or add a component of tab layout, modify it in "HomeFragment.java".

2. Stats
This is a layout where you can see the electricity usage and electric bill of your home.
The graph shows the amount of electricity you used for a week and displays a marker view when touching the corresponding coordinates.
In the bottom drawer, which says "overview,", you can drag from bottom to top and then it shows the details.
If you want to change the design method or link the data, modify it in "StatsFragment.java".

3. Setting
This is a layout where you can set up the app.
if you want to add actual operating functions, modify it in "SettingFragment.java".

4. Light
This is a layout where you can set the light in your home.
You can turn the lights on and off using the switch and adjust the brightness of the light using the Seekbar.
If you want to set the another light, modify it in "LightActivity.java".

5. Temperature
This is a layout where you can set the temperature in your home.
You can set the cooling or heating mode using the radio button and you can adjust the temperature using plus/minus buttons.
The button can only be changed when power button is pressed.
Also, you can set the speed of the heater using the Seekbar and you can change mode by pressing the mode buttons.
If you want to change the design method or link the data, modify it in "TempActivity.java".

*NOTE: Depending on the resolution, the screen may break.*
