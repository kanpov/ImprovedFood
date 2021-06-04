## What is this?

This is the archive of ImprovedFood project (revision 2).  
The project contained unique crops, features, food realism, (future) worldgen changes.

## Why did the project get archived?

Many reasons.  
Here's the biggest ones ordered by priority (from high to low):

1. **Huge feature overlap with Croptopia.**  
   Croptopia is [a famous Fabric mod](https://github.com/ExcessiveAmountsOfZombies/Croptopia) that  
   introduces many crops (both on land and on trees) and types of food into the game.  
   This mod had a similar idea, but introduced new worldgen, realism, storage and mechanics.  
   As a result, a major part of development was fully dedicated to copying/altering existing functionality from the mod.
2. **Size.**  
   Because of problem #1, the development was very long and tiring.  
   Only 20-30% of dev time was dedicated to unique features, and 70-80% to reimplementing Croptopia's functionality.
3. **Mentality of Content > Functionality.**  
   Most, if not all, of my work was towards making textures, content and _not programming_.  
   That may sound weird at first, but, as a programmer, I don't like focusing too much on content and art.
4. **Lack of modularity.**  
   Because the "realism" part of the mod added more difficulty, there needed to be options to turn on/off features.  
   Reworking the mod to support modularity would take even more time and effort.
5. **Demotivation.**  
   After focusing on a side project [MythicalTowers](https://github.com/RedGrapefruit09/MythicalTowers), I didn't want to work on the project anymore.  
   Because of problem #3, my attention was driven away and, as a result, there was a severe  
   lack of contributions for an in-active-development project.

## What next?

My final decision is to **convert** this project into a _plugin_ for Croptopia.  
That resolves many of the issues mentioned above:

1. Feature overlap is resolved because the foundation is provided by Croptopia - the base (dependency) mod.
2. The development time is cut and more unique features can be added.
3. There is no mentality of content > functionality because the focus is switched.
4. Modularity can easily be added as this is a new project.
5. -- 

## More info about the new project

Stay tuned as the project will be available on my GitHub account in a few days after it's set up locally!  

### What's confirmed

1. The name will be **Utopia**.  
2. The project will be split into several modules that can be enabled/disabled using custom commands.  
Here's the concept:  
```/uenable utopia_realism```  
```/udisable utopia_furniture```
3. The approximate release date (don't rely on it, just a guess): end of July 2021
4. The mod will have more and better unique features.
5. The mod will be written in Kotlin 1.5
6. I will try to update the mod to 1.17 as fast as possible
7. The mod will run on latest Fabric toolchain versions all the time
