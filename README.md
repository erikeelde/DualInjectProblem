# DualInjectProblem
Demonstration of dual injection problem using hilt + initializers in androidtests

## Reproduction

Run tests: 

> ./gradlew pixel2api30DebugAndroidTest

Tests start failing once we add injection to the Initializer using @EarlyEntryPoint.
