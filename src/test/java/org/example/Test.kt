package org.example

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
    fun model(): Arbitrary<Model> {
        return anyForSubtypeOf<Model>()
    }

    // Workaround
//    fun model(): Arbitrary<Model> = Arbitraries.oneOf(anyForType<Model1>(), anyForType<Model2>(), anyForType<Model3>())
}

sealed interface Model

data class Model1(val attr1: Int, val attr2: Int, val attr3: Int, val attr4: Int) : Model
data class Model2(val attr1: Int, val attr2: Int, val attr3: Int, val attr4: Int) : Model
data class Model3(val attr1: Int, val attr2: Int, val attr3: Int, val attr4: Int) : Model