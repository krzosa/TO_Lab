# Changelog
### Karol Krzosa TO

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

Project structure refactor
Added: H2 database + Hibernate and logging.
Added: working string calculator
Fixed: error handling
Changed: exception handling
Added: calculator error handling, also set current paths for intelij build
Fixed: pathing problems for the maven project... but that creates problems with intelij project
Fix: temporary absolute path, FileNotFoundExceptions when creating class in webapp
Added: working calculator yay. Most work done.
Fixed: maven spring boot startup error
Fixed: errors with server
Added: webApp with SpringMVC
Added: Spring webApp, login page with user validation.

## [0.3.0] 2019.12.10

### Added

- Facade

### Fixed

- Plugin not found error by adding target to git

## [0.2.0] 2019.12.03

### Added

- CHANGELOG file
- Plugins folder with a plugin
- A method in Calc that loads a class and then invokes a method of that class
- Prototype design pattern

### Changed

- Project file structure

## [0.1.0] 2019.10.29

### Added

- Maven project with 3 subprojects
- Super basic calculator interface
