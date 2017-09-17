package com.github.sah4ez.groovyexample

import org.uma.jmetal.algorithm.multiobjective.nsgaii.NSGAII
import org.uma.jmetal.operator.impl.selection.BestSolutionSelection

class TestNSGAII extends GroovyTestCase{

    def repositories = [new Repository("C1", 5, ["I1"] as ArrayList),
                        new Repository("C2", 4, ["I1"] as ArrayList)] as ArrayList<Repository>

    void testFirstTestCase() {
        def items = [new Item("T1","I1", 4),
                     new Item("T2","I1", 2),
                     new Item("T3","I1", 3, false)] as ArrayList<Item>
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

    void testSecondTestCase() {
        def items = [new Item("T1","I1", 4),
                     new Item("T2","I1", 2),
                     new Item("T3","I1", 3, false),
                     new Item("T4","I1", 1 ) ] as ArrayList<Item>
        NSGAII nsgaii = new NSGAII<RepositorySolution>(
                new RepositoryProblem(repositories, items, "First"),
                100,
                20,
                new RepositoryCrossover(),
                new RepositoryMutation(),
                new BestSolutionSelection<>(new SolutionComparator()),
                new RepositorySolutionListEvaluator()
        )
        nsgaii.run()
        nsgaii.result.forEach({
            println String.format("FreeSpace: %.2f, Not added items: %.2f", it.getObjectives(0), it.getObjectives(1))
        })
    }
}
