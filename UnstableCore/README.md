# UnstableCore

Central core plugin for the UnstableSMP Minecraft server.

## Features
- Shared API for all Unstable plugins
- SQLite database management
- Central configuration
- Message system foundation
- Player UUID handling

## Installation
1. Place `UnstableCore.jar` into your server's `plugins/` folder.
2. Restart the server.
3. Configure `plugins/UnstableCore/config.yml` if needed.
4. Install other Unstable plugins that depend on this core.

## Permissions
- `unstable.core.admin` - Admin access (default: op)

## Commands
No direct commands. Provides API for other plugins.

## Dependencies
- Paper 1.21+
- Java 21 recommended (compiled with 17 for compatibility in this build)

## Author
TxmmyYT_

## Build
```bash
mvn clean package
```
The shaded JAR will be in `target/UnstableCore-1.0.0.jar`
