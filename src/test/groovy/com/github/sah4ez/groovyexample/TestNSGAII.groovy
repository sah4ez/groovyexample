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

    void testMyTestCase() {
        def repositories = [new Repository("C1", 5, ["I1"] as ArrayList),
                            new Repository("C2", 4, ["I1"] as ArrayList),
                            new Repository("C3", 4, ["I2"] as ArrayList),
                            new Repository("C4", 7, ["I2"] as ArrayList),
                            new Repository("C5", 4, ["I1"] as ArrayList),
                            new Repository("C6", 5, ["I3"] as ArrayList)
        ] as ArrayList<Repository>
        def items = [new Item("T1","I1", 2),
                     new Item("T2","I1", 2),
                     new Item("T3","I2", 2, false),
                     new Item("T4","I1", 2 ),
                     new Item("T5","I2", 2),
                     new Item("T6","I1", 2),
                     new Item("T7","I2", 2),
                     new Item("T8","I1", 2),
                     new Item("T9","I2", 2),
                     new Item("T10","I1", 2),
                     new Item("T11","I3", 2, false),
                     new Item("T12","I3", 2),
                     new Item("T13","I1", 2),
                     new Item("T14","I2", 2),
                     new Item("T15","I2", 2),
                     new Item("T16","I1", 2, false),
                     new Item("T17","I3", 2),
                     new Item("T18","I1", 2),
                     new Item("T19","I2", 2),
                     new Item("T20","I1", 2),
                     new Item("T21","I2", 2),
                     new Item("T22","I1", 2),
                     new Item("T23","I2", 2)
        ] as ArrayList<Item>
        NSGAII nsgaii = new NSGAII<RepositorySolution>(
                new RepositoryProblem(repositories, items, "First"),
                100000,
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
