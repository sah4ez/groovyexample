package com.github.sah4ez.groovyexample

import org.uma.jmetal.algorithm.multiobjective.nsgaii.NSGAII
import org.uma.jmetal.operator.impl.selection.BestSolutionSelection

class TestNSGAII extends GroovyTestCase{

    def repositories = [new Repository("C1", 5, ["I1"] as ArrayList),
                        new Repository("C2", 2, ["I2"] as ArrayList)] as ArrayList<Repository>
    def items = [new Item("I1", 2), new Item("I1", 3), new Item("I2", 2)] as ArrayList<Item>

    void testRunner() {
        NSGAII nsgaii = new NSGAII(
                new RepositoryProblem(repositories, items, "First"),
                100,
                20,
                new RepositoryCrossover(),
                new RepositoryMutation(),
                new BestSolutionSelection<>(new SolutionComparator()),
                new RepositorySolutionListEvaluator()
        )
        nsgaii.run()
    }
}
