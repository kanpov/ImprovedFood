# About

This is a guide on how to get the latest compiled artifacts (builds) of the mod through GitHub Actions.  
If you want to compile manually (not recommended), use the deprecated guide [here](https://github.com/RedGrapefruit09/ImprovedFood/blob/master/COMPILE_DEPRECATED.md).  

# Why

After looking at the [Releases page](https://github.com/RedGrapefruit09/ImprovedFood/releases) you may wonder why would you use compiled builds over official releases.  
Compiled builds have the latest and hottest features of all, so you can get even more content from the mod.  
But the official releases are tested and mostly-stable, so you should **always** backup your worlds before using compiled builds.

# Requirements

The only requirement for getting the artifacts is any viable archive program.  
I recommend WinRAR or 7-Zip for that task, but you can use any decent archive program if you want.

# Choosing a branch

When choosing a branch, you have two options:

- 'master' branch. Its code is mostly tested and works 70-80% of the time
- 'dev' branch. Its code is very new and experimental, may cause crashes and world corruptions. Has the latest features of all

Most of the time, you should use 'master' branch

# Process

- Go to the [Actions tab](https://github.com/RedGrapefruit09/ImprovedFood/actions) of the repository
- Select [build](https://github.com/RedGrapefruit09/ImprovedFood/actions/workflows/build.yml) workflow from the Workflows bar
- Click on the title of the top workflow run with your desired branch near the title
- Go to the Artifacts section and click on the Artifacts link with a box on the left
- Now you will download the ```Artifacts.zip``` archive
- Using your archive program, extract the contents of the ```Artifacts.zip``` archive somewhere on your computer
- Now use the JAR file with the shortest name as your mod file

# Final steps

Now you can follow the guide in the Install section of the [README.md](https://github.com/RedGrapefruit09/ImprovedFood/blob/master/README.md).  
**Remember** to use your artifact JAR as the mod JAR, **not** the JAR from the [Releases page](https://github.com/RedGrapefruit09/ImprovedFood/releases)