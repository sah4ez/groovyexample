package com.github.sah4ez.groovyexample

import org.uma.jmetal.operator.MutationOperator

class RepositoryMutation implements MutationOperator<RepositorySolution>{
    @Override
    RepositorySolution execute(RepositorySolution repositorySolution) {
        return repositorySolution
    }
}
