package com.github.sah4ez.groovyexample

import org.uma.jmetal.operator.CrossoverOperator

class RepositoryCrossover implements CrossoverOperator<RepositorySolution>{

    @Override
    int getNumberOfParents() {
        return 2
    }

    @Override
    List<RepositorySolution> execute(List<RepositorySolution> repositorySolutions) {
        return repositorySolutions
    }
}
