package org.example

import net.jqwik.api.Arbitraries
import net.jqwik.api.Arbitrary
import net.jqwik.api.ForAll
import net.jqwik.api.Property
import net.jqwik.api.Provide
import net.jqwik.api.constraints.UseType
import net.jqwik.api.domains.Domain
import net.jqwik.api.domains.DomainContext
import net.jqwik.api.domains.DomainContextBase
import net.jqwik.kotlin.api.anyForSubtypeOf

@Domain(MyDomain::class)
@Domain(DomainContext.Global::class)
class Test {

    @Property
    fun test(@ForAll model: @UseType Model) {

    }
}


class MyDomain : DomainContextBase() {
    @Provide
    fun model(): Arbitrary<Model> = anyForSubtypeOf<Model>()
//    fun model(): Arbitrary<Model> = Arbitraries.just(Model1(1))
}

sealed interface Model

data class Model1(val int: Int) : Model
data class Model2(val int: String) : Model