# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/), and this project adheres
to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [v0.2-preview.4]

### Added

#### General

- New crops:
  - Peanut
  - Pineapple

### Changed

#### Internal

- Redesigned kiwi crop textures

### Deprecated

#### Internal

- Set durations and amplifiers in FoodEffectConfig as they don't give the same effect as randomized ones

### Fixed

#### General

- Critical bug messing up effect amplifiers

## [v0.2-preview.3]

### Added

#### General

- New crops:
  - Blueberry
  - Raspberry
- Ranged durations and amplifiers to custom food effects (for example, from 300 to 500 ticks instead of 400 ticks)

#### Repository

- More badges from [shields.io](https://shields.io/)
- A brand-new Markdown blog

#### Security

- 0.2 series as a supported security version in the [policy](https://github.com/RedGrapefruit09/ImprovedFood/blob/master/SECURITY.md)

### Changed

#### General

- Completely redesigned crop textures for (with more coming in the next preview):
  - Tomato
  - Cucumber

#### Internal

- Changed Gradle ```duplicatesStrategy``` in the ```processResources``` task to ```EXCLUDE```
- Made permanent effect implementation cleaner

#### Toolchain

- Migrated mappings from ```1.16.5+build.8``` to ```1.16.5+build.9```

#### Repository

- Completely reformatted this changelog
- Changed badge colors to look nicer
- Minor README changes
- Credited [Croptopia](https://github.com/ExcessiveAmountsOfZombies/Croptopia) in the README

### Fixed

#### Internal

- Blackberry being named blueberry internally, it hadn't affected the gameplay

### Removed

#### Internal

- Unnecessary crop lang entries because crops don't have ```BlockItem```s

## [v0.2-preview.2]

### Added

#### General

- New crops:
    - Kiwi
    - Jackfruit
    - Blackberry
- Custom effects to **all** crops

### Changed

#### Internal

- Minor cleanup

### Fixed

#### General

- Overdue variants for crops being unregistered

## [v0.2-preview.1]

### Added

#### General

- Core of crop food:
    - Normal crop blocks
    - Tall crop blocks
    - Leaves crop blocks
- A few crops, but it's a start:
    - Tomatoes
    - Cucumbers

### Fixed

#### CI

- CI failure because of corrupted Gradle Wrapper JAR

## [v0.1.1f]

### Added

#### General

- Salt ore block
- Salt ore generation
- Salt ore => salt smelting recipe

## [v0.1f]

### Added

#### General

- **Everything** from:
    - v0.1-preview.1
    - v0.1-preview.2
    - v0.1-preview.3
    - v0.1-preview.4
    - v0.1-preview.5

### Changed

#### Repository

- Minor formatting and cleanup

### Removed

#### Repository

- Unnecessary HTML in README in the favor of Markdown formatting

## [v0.1-preview.5]

### Added

#### General

- Coverage for:
    - Rabbit stew
    - Spider eye
    - Suspicious stew
    - Sweet berries
    - Tropical fish
    - Cake

### Fixed

#### General

- Missing patch for potatoes
- Overdue cake being inedible

#### Internal

- Fixed saturation modifier being ```int``` instead of ```float```

## [v0.1-preview.4]

### Added

#### General

- Coverage for:
    - Potato
    - Baked potato
    - Beetroot
    - Beetroot soup
    - Bread
    - Chorus fruit
    - Cookie
    - Honey bottle
    - Melon slice
    - Mushroom stew
    - Pumpkin pie
- HARMFUL, MISC and COOKED categories

#### Repository

- Artifact compile guide and deprecated the old one

#### Security

- Important note to the Security Policy

### Changed

#### Internal

- Decoration changes and cleanup

### Fixed

#### General

- Fixed missing translation on the chorus fruit

#### CI

- Another Gradle Wrapper death

## [v0.1-preview.3]

### Added

#### General

- Coverage for:
    - Raw salmon
    - Cooked salmon
    - Raw cod
    - Cooked cod
    - Apple
    - Golden apple
    - Carrot
    - Golden carrot
- A new fish category

#### Repository

- Dependabot integration

#### Security

- Security policy

### Changed

#### Internal

- Reorganized com.redgrapefruit.improvedfood.core package

### Fixed

#### General

- A major bug disabling fridge logic

#### Repository

- Compile guide having the wrong version of the mod

#### Internal

- Minor cleanup and issues

### Removed

#### Internal

- Unused ```patch(Item, FoodConfig, RottenFoodItem, OverdueFoodItem)``` method in ```PatchRegistry```

## [v0.1-preview.2]

### Added

#### General

- Coverage for:
    - Raw mutton
    - Cooked mutton
    - Raw rabbit
    - Cooked rabbit

### Changed

#### General

- Vanilla food variants now override properties of their parent FoodComponent
- Vanilla rotten and overdue food variants now decrease hunger and saturation

### Fixed

#### General

- Food variants being inedible (see Changed.General #1)

## [v0.1-preview.1]

### Added

#### General

- Food can now overdue and rot
- Food has unique realistic properties
- Food can be put in fridges to slow down rot and overdue
- Food can be salted to slow down rot
- Food properties are displayed in a dynamic, self-expandable tooltip
- Vanilla food will also have these changes. List of currently covered food:
    - Raw porkchop
    - Cooked porkchop
    - Raw beef (raw steak)
    - Cooked beef (cooked steak)
    - Raw chicken
    - Cooked chicken
