# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/), and this project adheres
to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

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
