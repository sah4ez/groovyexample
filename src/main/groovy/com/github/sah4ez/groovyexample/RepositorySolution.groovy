package com.github.sah4ez.groovyexample

import org.uma.jmetal.solution.Solution
import org.uma.jmetal.solution.impl.AbstractGenericSolution

class RepositorySolution extends AbstractGenericSolution<Repository, RepositoryProblem> {
    def variables = [] as List<Integer>
    /**
     * Constructor
     */
    protected RepositorySolution(RepositoryProblem problem) {
        super(problem)
        problem.repositories.forEach({it.items.clear()})
        problem.repositories.forEach({variables.add(it.free())})
    }

    RepositorySolution(RepositorySolution solution) {
        super(solution.problem)
        this.variables = variables
    }

    Object getObjectives(int index){
        return this.getObjective(index)
    }

    @Override
    String getVariableValueString(int index) {
        return ""
    }

    @Override
    Solution<Repository> copy() {
        return new RepositorySolution(this)
    }

    int free() {
        def all = 0
        variables.forEach({all += it})
        all
    }
}
