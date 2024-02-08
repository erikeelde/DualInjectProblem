# DualInjectProblem
Demonstration of dual injection problem using hilt + initializers in androidtests

## Reproduction

Run tests: 

> ./gradlew pixel2api30DebugAndroidTest

Tests start failing once we add injection to the Initializer using @EarlyEntryPoint.


## Links of interest:

Androidx Startup starts up before testing instrumentation is ready
> https://issuetracker.google.com/issues/230844558

Hilt component created rule
https://stackoverflow.com/questions/75605297/hilt-singleton-components-instantiated-multiple-times