# Gilded Rose kata

Practicing [Emily Bache][emilybache]'s [Gilded Rose][gildedrose] kata

## Technical notes

This is the process used to reach the current state:

  * I've created a golden master testing strategy for the existing features
  * Break the dependencies to `GildedRose`, pushing behavior down to the newly-created objects
  * Follow TDD to add the new feature (`Conjured Item` support)
  * Do not add more unit test coverage, as there is no request for further user stories/business features*

### Protecting the Item

As the `Item` class cannot be modified, I've created a wrapper to push the behavior to the new class.

### Separating the rules

In the current solution, the behavior related to updating quality lives in the `domain.Item` class and its children.

This can be seen as a `Rule` and a `Rule Engine` pattern: the `domain.Item` (plus children) are the `Rule`s and the `Factory::build` is the `Rule Engine`

Each rule is autonomous on how to apply itself. The rule itself indicates whether there is a match or not (using an `Option`). The rule engine just iterates through them until a match is found. Therefore, the order of the rules matters

### Project as a legacy codebase

I've decided to handle this refactoring kata as a legacy codebase and do not add unit tests for the existing behavior. For the new behavior, on the other hand, it's now easy to create unit tests, follows a request from business to expand the behavior, so I've added unit tests

[gildedrose]: https://github.com/emilybache/GildedRose-Refactoring-Kata/tree/master/Java
[emilybache]: https://github.com/emilybache

