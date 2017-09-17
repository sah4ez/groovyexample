package com.github.sah4ez.groovyexample

import org.uma.jmetal.problem.Problem

class RepositoryProblem implements Problem<RepositorySolution> {

    def repositories = [] as ArrayList<Repository>
    def items = [] as ArrayList<Item>
    def name

    RepositoryProblem(repositories, items, name) {
        this.repositories = repositories
        this.items = items
        this.name = name
    }

    @Override
    int getNumberOfVariables() {
        return items.size()
    }

    @Override
    int getNumberOfObjectives() {
        return 2
    }

    @Override
    int getNumberOfConstraints() {
        return 2 * repositories.size()
    }

    @Override
    String getName() {
        return this.name
    }

    @Override
    void evaluate(RepositorySolution solution) {
        println "Hi!)) Me need implement"
    }

    @Override
    RepositorySolution createSolution() {
        return new RepositorySolution(this)
    }
}
