[![build](https://github.com/RedGrapefruit09/ImprovedFood/actions/workflows/build.yml/badge.svg)](https://github.com/RedGrapefruit09/ImprovedFood/actions/workflows/build.yml)
[![CodeQL](https://github.com/RedGrapefruit09/ImprovedFood/actions/workflows/codeql-analysis.yml/badge.svg)](https://github.com/RedGrapefruit09/ImprovedFood/actions/workflows/codeql-analysis.yml)
![GitHub](https://img.shields.io/github/license/RedGrapefruit09/ImprovedFood?color=blue)
![GitHub release (latest by date including pre-releases)](https://img.shields.io/github/v/release/RedGrapefruit09/ImprovedFood?color=purple&include_prereleases)
![GitHub commits since latest release (by date including pre-releases)](https://img.shields.io/github/commits-since/RedGrapefruit09/ImprovedFood/latest?color=red&include_prereleases)
![Lines of code](https://img.shields.io/tokei/lines/github/RedGrapefruit09/ImprovedFood?color=orange)

# About

ImprovedFood is a Minecraft mod made with Fabric's toolchain aiming to improve food in the game.

Here's a list of features:

1. Food can now rot and overdue
2. You can put your food into a fridge or salt it to reduce the speed of the process
3. Colorful and very detailed tooltips describing _everything_ about your food item
4. Food storage: boxes, lockers etc.
5. You can grow your food and make an astonishing farm
6. You can find your food on trees in jungles and forests
7. You can explore the world to find beautiful structures with lots of food and rare items
8. More to come later!

Do keep in mind that the mod is in its middle stages of development, and most of these features are yet to come.  
Current release date: June 15th, 2021.

# Install

**This mod is creative-only right now with no way of obtaining its items**.  
This is going to change over the next few release cycles (e.g. in a few weeks), but currently it's impossible to get _any_ item from mod.

Requirements:

- AdoptOpenJDK 1.8 HotSpot VM from [here](https://adoptopenjdk.net/?variant=openjdk8&jvmVariant=hotspot)
- Licensed Minecraft 1.16.5 Java Edition from [here](https://www.minecraft.net/en-us/)
- Fabric Loader 0.11.3 from [here](https://fabricmc.net/use/) (there's the installer tool)
- A fully set up modded Minecraft instance running on Fabric Loader
- Fabric API 0.34.1 from [here](https://www.curseforge.com/minecraft/mc-mods/fabric-api/files)

To get the mod file, navigate to the releases page [here](https://github.com/RedGrapefruit09/ImprovedFood/releases),
click on the top release and download the JAR file.  
Put the JAR file from the releases page <b>and</b> Fabric API JAR file in your mods folder, launch the game and enjoy
your modded experience!

# Compile

See [COMPILE.md](https://github.com/RedGrapefruit09/ImprovedFood/blob/master/COMPILE.md) for a guide on how to use
GitHub Actions compiled builds.  
(_Not recommended_) If you want to compile manually, you can see the deprecated manual compilation
guide [here](https://github.com/RedGrapefruit09/ImprovedFood/blob/master/COMPILE_DEPRECATED.md)

# Contribute

I would love to receive pull requests, issues and contributions from this project's community.  
Although I'm not a full-time developer, and your pull request or issue might be reviewed after one or two days.  
I haven't set up code of conduct, pull request and issue templates yet. That will change later.

# Code

The code is written in Java 8 powered by AdoptOpenJDK 1.8  
It's carefully documented and commented to ensure readability.  
If you have refactoring or cleanup suggestions, open a pull request or issue, but there's a high chance I don't
approve.  
It's planned to port the mod to Kotlin using FLK (fabric-language-kotlin) after release.

# Frequently Asked Questions

Q: Will this mod be ported to Forge?  
A: No. I do not develop using Forge and will not spend my time supporting a mod on both  
platforms instead of actually doing something useful with the mod itself.  
Q: Will there be a CurseForge page?  
A: Yes, after the mod is released I will send my request to upload the mod to CurseForge.  
Q: Do you support snapshots?  
A: No. I don't support snapshots and only update between stable releases of Minecraft and Fabric's toolchain.

# Credits

- To Mojang's developers for creating Minecraft and making my childhood
- To Fabric's team and contributors for creating an astonishing modding toolchain
- To JetBrains's team and contributors for creating an amazing JVM IDE and skyrocketing my productivity
- To Aseprite's team and contributors for creating a lovely sprite editor
- To everyone who sees this for giving me motivation to continue

# Contact

You can email me at karpovanton729@gmail.com