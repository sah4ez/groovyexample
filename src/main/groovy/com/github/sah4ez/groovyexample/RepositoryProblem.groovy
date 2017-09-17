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
        items.sort({ !it.necessary })
        int notAdded = 0
        def indexes = randomIndex(repositories.size())
        repositories.forEach({it.items.clear()})
        items.forEach({
            def item = it
            boolean added
            indexes.forEach({
                if (!added){
                    repositories[it].add(item) ? added = true : {}
                }
            })
            added ? {} : notAdded++
        })
        indexes.forEach({ solution.variables[it] = repositories[it].free() })
        solution.setObjective(0, solution.free())
        solution.setObjective(1, notAdded)
    }

    static Set<Integer> randomIndex(int len) {
        Set<Integer> result = new HashSet<>(len)
        Random random = new Random()
        while (result.size() != len) {
            def i = random.nextInt(len)
            if (!result.contains(i)) {
                result.add(i)
            }
        }
        result
    }

    @Override
    RepositorySolution createSolution() {
        return new RepositorySolution(this)
    }
}
