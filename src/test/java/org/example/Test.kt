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
import net.jqwik.kotlin.api.any
import net.jqwik.kotlin.api.anyForSubtypeOf
import net.jqwik.kotlin.api.anyForType

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

    @Provide
    fun subModel(): Arbitrary<SubModel> = Double.any().between(0.0, 1_000_000.0).map { SubModel(it) }
}

sealed interface Model

data class Model1(val attr1: SubModel) : Model
data class Model2(val attr1: SubModel,val attr2: SubModel?) : Model

data class SubModel(val int: Double)