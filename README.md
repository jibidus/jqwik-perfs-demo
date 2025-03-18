Demo project which illustrates a performance degradation in jqwik 1.9.0 (same with 1.9.1 and 1.9.2).

See [this test](src/test/java/org/example/Test.kt).

In my laptop, this test last **1mn47s with jqwik 1.9.0**, but **3s with jqwik 1.8.5**.

This test involves 3 elements:
* duplicated arbitrary providers in different domains (there is no duration difference without this)
* these providers uses `combine()` kotlin DSL with a single arbitrary (there is no duration difference with `Double.any().map{}` instead)
* usage of `anyForSubtypeOf<>()` (the duration difference is smaller with `Arbitraries.oneOf(anyForType<SubClass1>().enableRecursion(), …)`)

