# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/), and this project adheres
to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [0.1.0-daily4]

### Added

- Salt as a separate food variant.
- Salt implementation

### Changed

- CHANGELOG version change formatting is now much nicer

## [0.1.0-daily3]

### Added

- A salt item in a separate class
- Effect override-ability so rotten and overdue variants disable the effects
- Separate salted variants instead of a boolean

### Changed

- Fabric API dependency update: 0.33.0 => 0.33.1

### Fixed

- Unregistered variants leading to a complete mess
- README formatting being incorrect in the Infrequently Asked Questions section
- Unnecessary fields in the profile

## [0.1.0-daily2]

### Added

- A salter block meant to salt food. Not implemented yet
- Salt item
- Loot tables for blocks
- Internal API additions and modifications

### Changed

- Fabric API dependency update: 0.32.9 => 0.33.0

### Fixed

- A few tiny fixes

## [0.1.0-daily1]

### Added

- An advanced food system to improve vanilla food and new food
- Food rot
- Food overdue
- Putting food into fridges to slow down rot and overdue
- Informative tooltips displaying food properties in detail
- Raw porkchop modification

### Changed

- Changed mod version from 1.0-SNAPSHOT to 0.1-SNAPSHOT to display the version more accurately
- Changed fridge's textures to nicer ones

### Fixed

- Fridge graphics bug because one of textures' pixels being transparent