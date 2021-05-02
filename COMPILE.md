<b>WARNING: </b> this guide doesn't work with Linux and Mac.

# Why

Why would you compile the mod?  
Because compiled versions of the mod have the newest features of all the releases.  
But the output might potentially be unstable and even crash your world.  
<b>Backup your world</b> before using a compiled version of the mod.

# Where from

When choosing where to compile from you have 2 options:
<ul>
<li>'master' branch. It's code is tested and works fine in 70-80% of cases</li>
<li>'dev' branch. It's code is the latest and newest and can break your world or crash your game</li>
</ul>
I recommend 'master' branch for most cases.

# Prerequisites

1. Download AdoptOpenJDK 1.8 (other OpenJDK distributions aren't supported)
   from [here](https://adoptopenjdk.net/?variant=openjdk8&jvmVariant=hotspot)
2. Add Java to your path
3. Test it by running cmd.exe (Windows's default CLI tool) and typing ```java -version```

# Compiling

Download the ZIP file of your chosen branch by choosing it, clicking Code and then clicking Download ZIP.  
Unzip the file somewhere on your computer.  
Open cmd.exe and run ```cd $PATH_TO_THE_UNZIPPED_FOLDER$```. In cmd.exe also run ```gradlew build```.

# Where's the JAR

Now your JAR is in $PATH_TO_THE_UNZIPPED_FOLDER$/build/libs/improvedfood-1.0-SNAPSHOT.jar