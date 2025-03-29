package org.example.java;

import net.jqwik.api.*;
import net.jqwik.api.domains.Domain;
import net.jqwik.api.domains.DomainContextBase;
import org.example.kotlin.AnotherDomain;

@Domain(Test.MyDomain.class)
@Domain(Test.AnotherDomain.class)
public class Test {
    @Property
    void test(@ForAll Model model) {
    }

    static class MyDomain extends DomainContextBase {
        @Provide
        Arbitrary<Model> model() {
            return Arbitraries.oneOf(Arbitraries.forType(Model1.class).enableRecursion(), Arbitraries.forType(Model2.class).enableRecursion());
        }

        @Provide
        Arbitrary<Attr> attribute() {
            return Arbitraries.doubles().map(Attr::new);
        }
    }

    static class AnotherDomain extends DomainContextBase {
        @Provide
        Arbitrary<Attr> attribute() {
            return Arbitraries.doubles().map(Attr::new);
        }
    }

    interface Model { }

    static class Model1 implements Model {
        public Model1(Attr attr1) {
            this.attr1 = attr1;
        }

        private Attr attr1;
    }

    static class Model2 implements Model {
        public Model2(Attr attr1) {
            this.attr1 = attr1;
        }

        private Attr attr1;

    }

    static class Attr {
        private Double value;

        public Attr(Double value) {
            this.value = value;
        }
    }
}


