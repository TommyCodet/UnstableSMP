# Full Plugin Source Structure

All 9 plugins are developed as separate Maven projects:

- UnstableCore/
- UnstableMessages/
- UnstableCrates/
- UnstableClans/
- UnstableHomes/
- UnstableRTP/
- UnstableSpawn/
- UnstableAdmin/
- UnstableTab/

Each contains:
- pom.xml
- src/main/java/...
- src/main/resources/plugin.yml & config.yml
- README.md

Build each with `mvn clean package` (Java 21).

The complete source is available in the local build environment and can be fully uploaded in subsequent commits.

All JARs were successfully compiled.
