[![build](https://github.com/RedGrapefruit09/ImprovedFood/actions/workflows/build.yml/badge.svg)](https://github.com/RedGrapefruit09/ImprovedFood/actions/workflows/build.yml)

# About
ImprovedFood is a Minecraft mod in early development.  
The mod will gradually improve food in Minecraft and add new food.

# Features
<ul>
<li>Food is divided into 4 groups: meat, fruit, vegetables, berries</li>
<li>Food properties are displayed in a neat, colorful tooltip</li>
<li>Food can rot slowly</li>
<li>Food can overdue slowly</li>
<li>Food can be put in a fridge to slow down rot and overdue</li>
<li>Meat can be salted to slow down rot</li>
<li><b>All</b> vanilla food is modified and also has these changes</li>
<li>A lot of new food and crops</li>
<li>Fridge and salt table blocks</li>
<li>Different food structures all around the world</li>
</ul>
And much more...

# Future
This mod's release date is currently June 1st, 2021 (could be delayed if something goes wrong).  
I will continue to release updates and bugfixes at least until October 1st, 2021.  
Alpha and beta releases will be also available, but they're not nearly as stable.

# Install
(Beware that this instruction only applies to Windows 10)  
Requirements:
<ul>
<li><a href="https://www.minecraft.net/en-us/">Minecraft (1.16.5 Java Edition)</a></li>
<li><a href="https://fabricmc.net/use/">Fabric Loader (0.11.3 and above)</a></li>
<li><a href="https://www.curseforge.com/minecraft/mc-mods/fabric-api/files">Fabric API (0.33.0 and above)</a></li>
</ul>
To install this mod, you'll need to:
<ul>
<li>Setup the requirements from above</li>
<li>Create a modded 1.16.5 Minecraft instance on your computer</li>
<li>Navigate to C:/Users/$PUT_YOUR_USERNAME_HERE$/AppData/Local/.minecraft/mods</li>
<li>Paste the downloaded mod JAR file (get it <a href="https://github.com/RedGrapefruit09/ImprovedFood/releases">here</a>) in the folder you opened</li>
<li>Launch Minecraft and enjoy your modded experience!</li>
</ul>

# Compile
To get the <span style="color: green">latest</span> and <span style="color: red">probably broken</span> version of the mod, you need to compile it  
Requirements:
<ul>
<li><a href="https://adoptopenjdk.net/?variant=openjdk8&jvmVariant=hotspot">AdoptOpenJDK 8 HotSpot VM</a></li>
<li>JAVA_PATH variable set up and working (you can test it by typing 'java -version' in the command line)</li>
</ul>
To compile this mod, you'll need to:
<ul>
<li>Download the ZIP archive of this repository's master branch if you want stability or dev branch if you want latest untested changes</li>
<li>Unpack the ZIP somewhere on your computer</li>
<li>Navigate to the unpacked folder</li>
<li>Open your command line tool (cmd.exe on Windows)</li>
<li>Type 'gradlew build'</li>
<li>Close your command line tool and navigate to build/libs inside of your unpacked folder</li>
<li>Copy improvedfood-1.0-SNAPSHOT.jar to your mods folder (you can follow Install instructions from point 2 from now on)</li>
</ul>

# Code
This project is written in Java 8 using Minecraft's and Fabric's APIs.  
I put a lot of effort into comments and javadocs, so I hope the code is readable.  
Do keep in mind that I only have 1 or 2 hours a day to work on this project, so the progress is kind of slow.  
It's planned to update to Java 11 later, but right now Java 8 is good enough.

# Tools
Here's a set of tools I use for this project if someone's interested:
<ul>
<li>Coding - <a href="https://www.jetbrains.com/idea/">JetBrains IntelliJ IDEA (Community)</a></li>
<li>Art - <a href="https://www.aseprite.org/">Aseprite</a></li>
<li>Modeling - <a href="https://blockbench.net/">Blockbench</a></li>
<li>Task Management - <a href="https://trello.com/">Trello</a></li>
</ul>

# Contribute
This project is currently not open for contributions, and I'm working solo on it right now.  
Although things might change when I feel more confident.