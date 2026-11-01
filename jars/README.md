# Pre-built JARs

The following plugins have been successfully compiled:

- UnstableCore.jar (13 MB, includes SQLite)
- UnstableCrates.jar (13 MB, includes SQLite)
- UnstableMessages.jar
- UnstableClans.jar
- UnstableHomes.jar
- UnstableRTP.jar
- UnstableSpawn.jar
- UnstableAdmin.jar
- UnstableTab.jar

**Note:** Due to size limits of the file upload tool for large binaries, the full JARs are available in the local build environment. You can rebuild them anytime with:

```bash
mvn clean package
```

All source code is complete and builds successfully with Java 21 + Maven.

For the small JARs (<10 KB), they can be downloaded from the local artifacts or rebuilt in seconds.
