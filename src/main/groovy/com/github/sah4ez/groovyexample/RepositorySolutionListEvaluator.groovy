package com.github.sah4ez.groovyexample

import org.uma.jmetal.problem.Problem
import org.uma.jmetal.util.evaluator.SolutionListEvaluator

class RepositorySolutionListEvaluator implements SolutionListEvaluator<RepositorySolution> {
    @Override
    List<RepositorySolution> evaluate(List<RepositorySolution> solutionList, Problem<RepositorySolution> problem) {
        solutionList.forEach({problem.evaluate(it)})
        return solutionList
    }

    @Override
    void shutdown() {

    }
}
