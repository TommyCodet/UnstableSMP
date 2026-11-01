# UnstableSMP Plugin System

Complete modular plugin suite for UnstableSMP Minecraft Server.

**GitHub Repository:** https://github.com/TommyCodet/UnstableSMP

**Author:** TxmmyYT_  
**Minecraft:** Java 1.21.11  
**Server:** Paper  
**Java:** 21  

## Plugins

| Plugin          | Description |
|-----------------|-------------|
| **UnstableCore**    | Core API, Database (SQLite), Config, Messages foundation |
| **UnstableMessages**| Advanced messaging, titles, actionbars, sounds |
| **UnstableCrates**  | 5 crate types with key system & admin GUI |
| **UnstableClans**   | Full clan system (create, invite, home, chat) |
| **UnstableHomes**   | Multiple homes with countdown teleport |
| **UnstableRTP**     | Random safe teleport |
| **UnstableSpawn**   | Spawn system with setspawn |
| **UnstableAdmin**   | Fly, Vanish, Kick, Ban, Gamemode |
| **UnstableTab**     | Custom Tablist & Scoreboard |

## Installation

1. Clone or download the repository.
2. Build each plugin with `mvn clean package` (requires Java 21 + Maven).
3. Place the resulting JARs from `target/` into your server's `plugins/` folder.
4. Start with **UnstableCore**.
5. Configure each plugin's `config.yml`.
6. Set permissions (LuckPerms recommended).

Pre-built JARs are also available in the root of this folder (or can be downloaded from releases if added later).

## Recommended Load Order

UnstableCore → UnstableMessages → others.

## Features Overview

- **Shared API** via UnstableCore
- **SQLite** data storage
- **UUID-based** player identification
- **Permission-protected** commands
- **Persistent data** across restarts
- **Modular** – update individual plugins independently

## Development

Each plugin is a separate Maven project under its folder.  
To build all:

```bash
for d in Unstable*; do (cd $d && mvn clean package -DskipTests); done
```

## Permissions Summary

See individual plugin READMEs for full permission lists.

---

**Ready for deployment on UnstableSMP.**
