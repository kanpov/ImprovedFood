# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/), and this project adheres
to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [v0.2-preview.1]

### Added

- Core of crop food:
  - Normal crop blocks
  - Tall crop blocks
  - Leaves crop blocks
- A few crops, but it's a start:
  - Tomatoes
  - Cucumbers

### Fixed

- _CI:_ Fixed CI failure because of corrupted Gradle Wrapper JAR

## [v0.1.1f]

### Added

- Salt ore block
- Salt ore generation
- Salt ore => salt smelting recipe

## [v0.1f]

### Added

- **Everything** from:
  - v0.1-preview.1
  - v0.1-preview.2
  - v0.1-preview.3
  - v0.1-preview.4
  - v0.1-preview.5

### Changed

- _Repository:_ Removed unnecessary HTML from README
- _Repository:_ Minor formatting and cleanup

## [v0.1-preview.5]

### Added

- Coverage for:
  - Rabbit stew
  - Spider eye
  - Suspicious stew
  - Sweet berries
  - Tropical fish
  - Cake

### Fixed

- Fixed missing patch for potatoes
- Fixed overdue cake being inedible
- _Internal:_ Fixed saturation modifier being ```int``` instead of ```float```

## [v0.1-preview.4]

### Added

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
- _Repository:_ added an artifact compile guide and deprecated the old one
- _Security:_ added an important note to the Security Policy
- HARMFUL, MISC and COOKED categories

### Changed

- _Internal:_ decoration changes and cleanup

### Fixed

- Fixed missing translation on the chorus fruit
- _CI:_ Another Gradle Wrapper death

## [v0.1-preview.3]

### Added

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
- _Internal:_ Dependabot integration
- _Internal:_ Security policy

### Changed

- _Internal:_ Reorganized com.redgrapefruit.improvedfood.core package

### Fixed

- _Repository_: Fixed compile guide having the wrong version of the mod
- _Internal_: Minor cleanup and issues
- Fixed a major bug disabling fridge logic

### Removed

- _Internal:_ Removed unused ```patch(Item, FoodConfig, RottenFoodItem, OverdueFoodItem)``` method
  in ```PatchRegistry```

## [v0.1-preview.2]

### Added

- Coverage for:
  - Raw mutton
  - Cooked mutton
  - Raw rabbit
  - Cooked rabbit

### Changed

- Vanilla food variants now override properties of their parent FoodComponent
- Vanilla rotten and overdue food variants now decrease hunger and saturation

### Fixed

- Fixed food variants being inedible (see Changed #1)

## [v0.1-preview.1]

### Added

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
