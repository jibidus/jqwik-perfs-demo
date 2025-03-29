package org.example.kotlin

import net.jqwik.api.Arbitrary
import net.jqwik.api.ForAll
import net.jqwik.api.Property
import net.jqwik.api.Provide
import net.jqwik.api.domains.Domain
import net.jqwik.api.domains.DomainContextBase
import net.jqwik.kotlin.api.any
import net.jqwik.kotlin.api.anyForSubtypeOf
import net.jqwik.kotlin.api.combine

@Domain(MyDomain::class)
@Domain(AnotherDomain::class)
class Test {

    @Property
    fun test(@ForAll model: Model) {
    }
}

class MyDomain : DomainContextBase() {
    @Provide
    fun model(): Arbitrary<Model> = anyForSubtypeOf<Model>()

    @Provide
    fun attribute() = combine {
        val value by Double.any()
        combineAs {
            Attr(value)
        }
    }
}

class AnotherDomain : DomainContextBase() {
    @Provide
    fun attribute() = combine {
        val value by Double.any()
        combineAs {
            Attr(value)
        }
    }
}

sealed interface Model

data class Model1(val attr1: Attr) : Model
data class Model2(val attr1: Attr) : Model

data class Attr(val value: Double)