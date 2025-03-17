package org.example;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.UseType;
import net.jqwik.api.domains.Domain;
import net.jqwik.api.domains.DomainContext;

@Domain(MyDomain.class)
@Domain(DomainContext.Global.class)
public class Test {

    @Property
    void test(@ForAll @UseType Model model ) {
        System.out.println(model);
    }
}
