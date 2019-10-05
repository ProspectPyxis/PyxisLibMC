# Changelog
All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/), and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html) from release 2.0.0 onwards.

## [Unreleased]
### Fixed:
- `FluidUtils`'s `handleFluidMatAcceleration` function not being static

## [2.0.0] - 2019-10-04
### Added:
- New fluid handling classes: `FluidBase`, `BlockFluidClassicBase`, and `BlockFluidFiniteBase`
- New `IngredientFluid`, for crafting recipes that take fluid from an item capability (Code credit to BluSunrize)

### Changed:
- Renamed `ClientUtils` to `TileEntityRenderHelper` and moved its package from `prospectpyxis.pyxislib.client` to `prospectpyxis.pyxislib.client.tesr`

### Removed:
- Completely removed `CapabilityProvider` classes
- Deleted legacy `Utils` files - use the ones in `prospectpyxis.pyxislib.utils` instead
- `prospectpyxis.pyxislib.entity.player.PlayerUtils` has been removed

---
#### Note: Versions from here onwards do not adhere to Semantic Versioning.

## [1.3.3] - 2019-10-03
### Added:
- More methods to `BlockInformation` and `ItemInformation` related to ItemBlock handling

## [1.3.2] - 2019-10-03 [YANKED]
### Added:
- Missing necessary methods to `BlockInformation` and `ItemInformation`

## [1.3.1] - 2019-10-03 [YANKED]
### Added:
- Tile entity handling in `BlockInformation`

## [1.3.0] - 2019-10-03 [YANKED]
### Added:
- New `BlockInformation` and `ItemInformation` classes for easier registration handling
- New `ItemUtils` and `BlockUtils` classes in package `prospectpyxis.pyxislib.utils`

### Deprecated:
- Old `ItemUtils` and `BlockUtils` classes, use the new ones instead
- `CapabilityProviderBasic` and `CapabilityProviderSerializable`, to be removed in next major version

## [1.2.0] - 2019-03-30
### Added:
- New `PlayerUtils` class, currently just has a raytrace helper method

### Changed:
- Moved every class in `prospectpyxis.pyxislib.energy` to `prospectpyxis.pyxislib.capability.energy`

## [1.1.1] - 2019-03-27
### Added:
- New energy handler class: `EnergyManagerNoIO`

## [1.1.0] - 2019-03-27
### Added:
- Item capability provider classes `CapabilityProviderBasic` and `CapabilityProviderSerializable`
- New energy handler class: `EnergyConsumer`

## [1.0.2] - 2019-03-26
### Added:
- New invisible texture for general usage

## [1.0.1] - 2019-03-25
### Changed:
- `UV_OFFSET` value in `RendererUtils`

## [1.0.0] - 2019-03-25
### Added:
- New `RendererUtils` class for tile entity rendering

### Changed:
- Moved various classes and refactored various code for cleanliness, breaks compatibility

## [0.3.4] - 2019-03-15
### Added:
- New setters for `EnergyManager`

## [0.3.3] - 2019-03-14
### Changed:
- `IWrenchable`'s `applyWrench` function now requires more parameters

## [0.3.2] - 2019-03-14
### Fixed:
- Textures and assets for the wrench

## [0.3.1] - 2019-03-14
### Added:
- New `BlockWithTileEntity` class - exactly what it says on the tin

## [0.3.0] - 2019-03-13
### Added:
- New wrench item, along with `IWrenchable` interface
- New method in `ItemUtils` for creating a simple item
- New `BlockUtils` class, contains methods for creating a simple block

## Changed:
- Renamed `BlockWithTE` to `BlockWithTileEntity` and removed its dependency on `BlockBasic`

### Removed:
- `BlockBasic`, `ItemBasic`, and related classes, apparently this is a bad practice

## [0.2.0] - 2019-03-12
### Changed:
- Various improvements to `EnergyManager`

## [0.1.0] - 2019-03-08 [First Release]
### Added:
- Base block and base item classes
- `BlockWithTE` class to handle tile entities
- `EnergyManager` class for managing energy capabilities
- Preliminary mod information